package com.guilhebl.algo.string;

/**
 * 
 * https://careercup.com/question?id=5652856112676864
 *
 */
public class StringSequenceEncoder {

	public static void main(String[] args) {
		String s = "p14akkkkkkkkpq";
		System.out.println(encodeStr(s));
	}
	
	public static String encodeStr(String str) {		
		char[] c = str.toCharArray();
		char cur;
		char prev;
		int j = 0;
		
		StringBuilder sb = new StringBuilder(new Character(str.charAt(0)).toString());		
		for (int i = 1; i < c.length; i++) {
			cur = c[i];
			prev = c[i-1];
			
			j = 0;
			if (cur == prev) {
				while (cur == prev) {								
					j++;
					i++;
					cur = c[i];
					prev = c[i-1];				
				}
			}
			if (j > 1) {
				sb.deleteCharAt(sb.length()-1);
				sb.append(j + 1).append("x").append(prev);
				i--;
			} else {
				sb.append(cur);
			}
		}		
		
		return sb.toString();
	}
}
