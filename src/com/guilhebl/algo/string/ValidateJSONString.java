package com.guilhebl.algo.string;

import java.util.Stack;

/**
 * 
 * https://careercup.com/question?id=5643209168388096
 *
 */
public class ValidateJSONString {

	public static void main(String[] args) {
		  System.out.println(isValidJSON("{a:b}"));
	      System.out.println(isValidJSON("{a:b, c:d}"));
	      System.out.println(isValidJSON("{a:b,c:{e:f}}"));
	      System.out.println(isValidJSON("{{a}}"));
	      System.out.println(isValidJSON("{{}}"));
	      System.out.println(isValidJSON("{}"));
	      System.out.println(isValidJSON("{a:b, c:dmomomo, f:efefefeokfoekfoekf, obj:{}}"));
	      System.out.println(isValidJSON("{a:b, , c:dm}"));
	      System.out.println(isValidJSON("{a:b, c:d:m}"));
	}
	
	public static boolean isValidJSON(String s) {
		if (s == null || s.equals("") || s.length() <= 1) {
			return false;
		}
		Stack<Character> stCBStart = new Stack<>();
		StringBuilder temp = new StringBuilder();
		
		char[] c = s.toCharArray();
		int j = 0;
		char cj;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '{') {				
				if (!stCBStart.isEmpty()) {
					if (temp.length() != 0) {
						j = temp.length()-1;
						if (temp.charAt(j) != ':') {
							return false;
						}
						cj = temp.charAt(j);
						j--;
						while(j >= 0 && cj != ',') {							
							cj = temp.charAt(j);	
							j--;
						}
						if (j == 0) {
							temp = new StringBuilder();
						} else if (j > 0 && cj == ',' && (j + 1) < temp.length()) {							
							temp.delete(j + 1, temp.length());
						}
						
						if (temp.length() > 0) {
							if (!validateJSONStr(temp)) {								
								return false;
							}
							temp = new StringBuilder();
						}
					}					
					
				}				
				stCBStart.push('{');				
			} else if (c[i] == '}') {
				if (stCBStart.isEmpty()) {
					return false;
				}
				if (temp.length() > 0) {
					if (!validateJSONStr(temp)) {
						return false;
					}
					temp = new StringBuilder();
				}								
				
				stCBStart.pop();				
			} else {
				temp.append(c[i]);
			}
		}		
		
		if (stCBStart.size() > 0 || temp.length() > 0) {
			return false;
		}
		
		return true;
	}

	private static boolean validateJSONStr(StringBuilder temp) {
		String[] commas = temp.toString().split(",");
		if (commas.length > 0) {
			for (int i = 0; i < commas.length; i++) {
				if (!isValidJSONExp(commas[i])) {
					return false;
				}
			}
		} else {
			if (!isValidJSONExp(temp.toString())) {
				return false;
			}			
		}		
		
		return true;
	}

	private static boolean isValidJSONExp(String string) {
		String[] groups = string.split(":");
		return groups != null && groups.length == 2;
	}
}