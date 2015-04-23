package com.guilhebl.algo.combinatorics;

import java.util.HashSet;
import java.util.Set;



/**
 * Print all permutations of string
 * 
 * Example:
 * 
 * input: "abc"
 * 
 * output:
 * 
abc
acb
bac
bca
cba
cab

 * @author root
 *
 */
public class PrintAllPerms {

	
	public static void main(String[] args) {
	  printAllListStringsPermutations("abc".toCharArray(), 0);
		
	  Set<String> stringSet = new HashSet<String>();
	  getPermutationOfString("trek".toCharArray(), 0, stringSet);
	  printSets(stringSet);		
	}

	public static void printAllListStringsPermutations(char[] s, int i) {
		if (i == s.length) {
			System.out.println(s);
		} else if (i < s.length) {
			for (int j = i; j < s.length; j++) {
				swapElements(s, i, j);
				printAllListStringsPermutations(s, i + 1);
				swapElements(s, i, j);
			}
		}
	}

	public static void swapElements(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
		
	public static void getPermutationOfString(char[] a, int i, Set<String> stringSet) {
		if (i == a.length) {
			stringSet.add(new String(a));
		} else if (i < a.length) {
			for (int j = i; j < a.length; j++) {
				swap(a, i, j);
				getPermutationOfString(a, i + 1, stringSet);
				swap(a, i, j);
			}
		}
	}

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void printSets(Set<String> strs) {
		for (String string : strs) {
			System.out.println(string);
		}
	}
		
	
	public static void solvePrintAllPerms() {
		String s = "abc";
		printAllPerms(s.toCharArray(), 0);
	}

	public static void printAllPerms(char[] a, int i) {
		if (i > a.length) {
			return;
		} else if (i == a.length) {
			System.out.println(a);
		}
		for (int j = i; j < a.length; j++) {
			swap(a, i, j);
			printAllPerms(a, i + 1);
			swap(a, i, j);
		}
	}

}