package com.guilhebl.algo.string;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/valid-parentheses/
 *
 */
public class ValidParen {

	public static void main(String[] args) {
		System.out.println(isValid("(())"));
	}
	
    public static boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        if (s.length() == 1) return false;
        char[] c = s.toCharArray();
        Stack<Character> st = new Stack<>();        
        
        for(int i = 0; i < c.length; i++) {
        	if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                st.push(c[i]);                
            } else {
            	if (st.isEmpty()) return false;
            	Character head = st.pop();
            	if ((c[i] == ')' && !head.equals('(')) ||
            			 (c[i] == ']' && !head.equals('[')) ||
            			 (c[i] == '}' && !head.equals('{'))) {
                    return false;
                }            	            	            	
            }            
        }
        return st.isEmpty();
    }
    
}
