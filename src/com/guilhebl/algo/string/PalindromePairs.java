package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 */
public class PalindromePairs {
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("aaa.@#$%!@#!@#!$.....,::://aaa"));
//		
//		String[] words = {"abcd","dcba","lls","s","sssll"};
//		List<List<Integer>> r = palindromePairs(words);
//		
//		
//		for (List<Integer> list : r) {
//			System.out.print("[");			
//			for (Integer integer : list) {
//				System.out.print(integer + ",");
//			}
//			System.out.print("]");
//		}
	}
	
	    public static List<List<Integer>> palindromePairs(String[] words) {
	        Set<List<Integer>> res = new HashSet<List<Integer>>();
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        for(int i=0;i<words.length;i++) {
	            map.put(words[i],i);
	        }
	        for(int i=0;i<words.length;i++) {
	            String s = words[i];
	            for(int k=0;k<=s.length();k++) {
	                String prefix = s.substring(0,k);
	                String suffix = s.substring(k);
	                if(isPalindrome(prefix) && map.containsKey(reverse(suffix)) &&
	                    map.get(reverse(suffix)) != i) {
	                    ArrayList<Integer> tmp = new ArrayList<Integer>();
	                    tmp.add(map.get(reverse(suffix)));
	                    tmp.add(i);
	                    res.add(tmp);        
	                }
	            }
	            s = reverse(words[i]);
	            for(int k=0;k<=s.length();k++) {
	                String prefix = s.substring(0,k);
	                String suffix = s.substring(k);
	                if(isPalindrome(prefix) && map.containsKey(suffix) &&
	                    map.get(suffix) != i) {
	                    ArrayList<Integer> tmp = new ArrayList<Integer>();
	                    tmp.add(i);
	                    tmp.add(map.get(suffix));
	                    res.add(tmp);        
	                }
	            }

	        }
	        List<List<Integer>> retVal =new ArrayList<List<Integer>>();
	        for(List<Integer> l:res) {
	            retVal.add(l);
	        }
	        return retVal;
	    }
	    public static String reverse(String s) {
	        return new StringBuilder(s).reverse().toString();
	    }

		public static boolean isPalindrome(String s) {
			if (s == null) return false;
			if (s.equals("")) return true;
			String[] words = s.split("\\W");
			StringBuilder sb = new StringBuilder(words[0]);
			
			for (int i = 1; i < words.length; i++) {
				if (!words[i].trim().equals("")) {
					sb.append(words[i]);
				}
			}
			
			s = sb.toString();
			for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
				if (s.charAt(i) != s.charAt(j))
					return false;
			}
			return true;
		}	
}