package com.guilhebl.algo.combinatorics;

import java.util.HashMap;
import java.util.Map;

public class SubGroupCombination {
	 
	//Driver program
	public static void main(String args[]) {
	    int number[] = {2, 3, 4};	  
	    Map<Integer, String> mapChars = new HashMap<>();
	    mapChars.put(2, "abcd");
	    mapChars.put(3, "def");
	    mapChars.put(4, "ghi");	    
	    Map<Character, Integer[]> mapInts = new HashMap<>();
	    Integer[] arr = new Integer[3];
	    arr[0] = 1;
	    arr[1] = 2;
	    arr[2] = 3;
	    mapInts.put('C', arr);
	    arr = new Integer[3];
	    arr[0] = 4;
	    arr[1] = 5;
	    arr[2] = 6;
	    mapInts.put('B', arr);
	    arr = new Integer[3];
	    arr[0] = 7;
	    arr[1] = 8;
	    arr[2] = 9;
	    mapInts.put('A', arr);
	    printCombos(number, mapChars);
	}

	public static void printCombos(int a[], Map<Integer, String> mapsS) {
		char[] c = new char[a.length];
		printCombos(a, 0, c, mapsS);
	}

	public static void printCombos(int a[], int i, char[] c, Map<Integer, String> mapsS) {
		if (i == a.length) {
			System.out.println(c);
		} else if (i < a.length) {
			for (int j = 0; j < mapsS.get(a[i]).length(); j++) {
				c[i] = mapsS.get(a[i]).charAt(j);
				printCombos(a, i + 1, c, mapsS);
			}
		}
	}
	
	public static void printInts(char[] c,  Map<Character, Integer[]> mapInts) {	
		int[] r = new int[c.length];
		printInts(c, 0, r, mapInts);		
	}
	
	public static void printInts(char[] c, int i, int[] r, Map<Character, Integer[]> mapInts) {
		if (i == c.length) {
			printArray(r);
		} else if (i < c.length) {
			for (int j = 0; j < mapInts.get(c[i]).length; j++) {
				r[i] = mapInts.get(c[i])[j];
				printInts(c, i + 1, r, mapInts);			
			}			
		}				
	}
	
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// A wrapper over printWordsUtil().  It creates an output array and
	// calls printWordsUtil()
	public static void printWords(int[] number, Map<Integer, String> mapChars)
	{
		char[] c = new char[3];
	    printWordsUtil(number, 0, c, mapChars);
	}

	 
	// A recursive function to print all possible words that can be obtained
	// by input number[] of size n.  The output words are one by one stored
	// in output[]
	public static void printWordsUtil(int number[], int curr_digit, char[] c, Map<Integer, String> mapChars) 
	{
	    // Base case, if current output word is prepared
	    int i;
	    if (curr_digit == number.length) {
	        System.out.println(c);
	        return;
	    }
	 
	    // Try all 3 possible characters for current digir in number[]
	    // and recur for remaining digits
	    for (i = 0; i < mapChars.get(number[curr_digit]).length(); i++)
	    {
	        c[curr_digit] = mapChars.get(number[curr_digit]).charAt(i);
	        printWordsUtil(number, curr_digit+1, c, mapChars);
	        if (number[curr_digit] == 0 || number[curr_digit] == 1)
	            return;
	    }
	}
	 	
}
