package com.guilhebl.algo.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/roman-to-integer/
 *
 *

Symbol	I	V	X	L	C	D	M
Value	1	5	10	50	100	500	1,000

 */
public class RomanToInt {

	
	public static void main(String[] args) {
		RomanToInt ri = new RomanToInt();
		System.out.println(ri.romanToInt("I"));
		System.out.println(ri.romanToInt("II"));
		System.out.println(ri.romanToInt("III"));
		System.out.println(ri.romanToInt("IV"));
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
    public int romanToInt(String s) {    	
    	// build map of symbols
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	char[] c = s.toCharArray();
    	Character curr = c[c.length-1];
    	Character lastChar = c[c.length-1];
    	
    	int sum = 0;
    	int dec = 0;
    	int digitSum = 0;    	
    	int val = 0;
    	int powVal = 0;
    	
    	for (int i = c.length-2; i >= 0; i--) {
    		curr = c[i];
    		val = map.get(curr);    		
    		powVal = new Double(Math.pow(10, dec)).intValue();
    		
			if (curr == 'I') {
				// if (map.get(lastChar) == 'I') {
				// sum += digitSum;
				// }
				if (map.get(lastChar) > val) {
					dec--;					
					digitSum = val * powVal;
					sum -= digitSum;
				} else {		    		
		    		digitSum = val * powVal;					
					sum += digitSum;
				}
			} else if (curr == 'V') {					
				
			} else {
				
			}
    		lastChar = curr;
		}
    	
    	return sum;
    }
}
