package com.guilhebl.algo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/word-break/
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreak {

	public static void main(String[] args) {
		 Set<String> dictionary = new HashSet<>();		 
		 dictionary.add("mobile");
		 dictionary.add("samsung");
		 dictionary.add("sam");
		 dictionary.add("sung");
		 dictionary.add("man");
		 dictionary.add("mango");
		 dictionary.add("icecream");
		 dictionary.add("and");
		 dictionary.add("go");
		 dictionary.add("i");
		 dictionary.add("like");
		 dictionary.add("ice");
		 dictionary.add("cream");
		 System.out.println(wordBreak("ilikelikeimangoiii", dictionary));
		 System.out.println(wordBreak("samsungandmangok", dictionary));
		 
		 Set<String> dictionary2 = new HashSet<>();		 
		 dictionary2.add("cat");
		 dictionary2.add("cats");
		 dictionary2.add("and");
		 dictionary2.add("sand");
		 dictionary2.add("dog");
		 printList(wordBreak2("catsanddog", dictionary2));
	}
	
	public static void printList(List<String> s) {
		System.out.println();
		for (String string : s) {
			System.out.print(string + " --- ");
		}		
	}
	
    public static boolean wordBreak(String s, Set<String> wordDict) {
      if (s == null || s.equals("")) {
    	  return true;
      }
      int size = s.length();
      boolean[] dp = new boolean[size+1];
      
      for (int i = 1; i <= size; i++) {
		if (!dp[i] && wordDict.contains(s.substring(0, i))) {
			dp[i] = true;
		}
		
		if (dp[i]) {
			for (int j = i + 1; j <= size; j++) {
				if (!dp[j] && wordDict.contains(s.substring(i, i + j - i))) {
					dp[j] = true;
				}				
			}
		}	
      }
      
      return dp[size];
    }
    
    public static List<String> wordBreak2(String s, Set<String> wordDict) {
    	List<String> strs = new ArrayList<>();
    	if (s == null || s.equals("")) {
      	  return strs;
        }
    	wordBreakHelper(s, wordDict, 0, "", strs);    	
        return strs;
    }
    
    public static void wordBreakHelper(String s, Set<String> wordDict, int start, String sol, List<String> result) {
    	if (start == s.length()) {
    		result.add(sol);
    	} 
    	else {
    		for (int i = start; i < s.length(); i++) {
    			String substring = s.substring(start, i + 1);    			
    			if (wordDict.contains(substring)) {
    				String str = sol + (sol.length() == 0 ? "" : " ") + substring;
    				wordBreakHelper(s, wordDict, i + 1, str, result);
    			}
			}
    	}
    }

}
