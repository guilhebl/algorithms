package com.guilhebl.algo.bit;

/**
 * You are asked to decode a string. The original String is in binary format. 
 * The encoded string is formed by adding both neighboring digits to the current digit.
 * 
 * @author root
 *
 *Examples
0)	
    	
"123210122"
Returns: { "011100011",  "NONE" }
The example from above.

1)	
    	
"11"
Returns: { "01",  "10" }
We know that one of the digits must be '1', and the other must be '0'. We return both cases.

2)	
    	
"22111"
Returns: { "NONE",  "11001" }
Since the first digit of the encrypted string is '2', the first two digits of the original string must be '1'. Our test fails when we try to assume that P[0] = 0.

3)	
    	
"123210120"
Returns: { "NONE",  "NONE" }
This is the same as the first example, but the rightmost digit has been changed to something inconsistent with the rest of the original string. No solutions are possible.

4)	
    	
"3"
Returns: { "NONE",  "NONE" }
5)	
    	
"12221112222221112221111111112221111"
Returns: 
{ "01101001101101001101001001001101001",
 "10110010110110010110010010010110010" }

 */
public class DecodeBitSequenceArray {

	private static final String NONE = "NONE";
	
	public static void main(String[] args) {
		printArrayString(decode("123210122"));
	}
	
	public static void printArrayString(String[] message) {
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
		}
	}
	
	public static String[] decode(String message) {
		if (message == null || message.equals("")) {
			return null;
		}
		
		String[] result = new String[2];
		result[0] = getPossibleSequence(message, false);
		result[1] = getPossibleSequence(message, true);
	  	return result;
	}

	private static String getPossibleSequence(String message, boolean firstIsSet) {
		int[] s = getIntArrayFromString(message);
		int[] a = new int[s.length];
		
		if (s.length == 1){
			if (s[0] == 1 && firstIsSet) {
				return "1";
			} else if (s[0] == 0 && !firstIsSet) {
				return "0";
			} else {
				return NONE;
			}						
		}
		
		// first index
		if (firstIsSet) {			
			a[0] = 1;				
		} else {
			a[0] = 0;
		}
		
		int diff = 0, a1, b, c;
		for (int i = 1; i < s.length-1; i++) {			
			a1 = s[i-1];
			b = a[i-1];			
			c = (i == 1) ? 0 : a[i-2];  
			diff = a1 - b - c;
			
			if ((diff > 1) || (diff < 0)) {
				return NONE;	
			} 						
			a[i] = diff;						
		}
		
		// last index
		if (s[s.length-1] == 0) {
			if (s[s.length-2] != 0) {
				return NONE;	
			}
			a[s.length-1] = 0;			
		} else if (s[s.length-1] == 1) {						
			if (a[s.length-2] == 1) {
				a[s.length-1] = 0;	
			} else {
				a[s.length-1] = 1;
			}
		} else if (s[s.length-1] == 2) {						
			if (a[s.length-2] == 1) {
				a[s.length-1] = 1;	
			} else {
				return NONE;
			}
		} else {
			return NONE;
		}		
		
		return getStringFromArray(a);
	}

	private static String getStringFromArray(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		return sb.toString();
	}

	private static int[] getIntArrayFromString(String message) {
		char[] c = message.toCharArray();
		int[] res = new int[c.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(new Character(c[i]).toString());
		}
		
		return res;
	}
}
