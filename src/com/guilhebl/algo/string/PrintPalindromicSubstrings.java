package com.guilhebl.algo.string;

import java.util.HashSet;

public class PrintPalindromicSubstrings {

	public static void main(String[] args) {
		palindromeSubStrs("pop this tacocat seems nice at noon");
	}
	
	public static void palindromeSubStrs(String s)
	{
	    HashSet<String> m = new HashSet<>();
	    int n = s.length();
	 
	    // table for storing results (2 rows for odd-
	    // and even-length palindromes
	    int[][] r = new int[2][n+1];
	 
	    // Find all sub-string palindromes from the given input
	    // string insert 'guards' to iterate easily over s
	    String s2 = "@" + s + "#";
	    char[] c = s2.toCharArray();
	 
	    for (int j = 0; j <= 1; j++)
	    {
	        int rp = 0;   // length of 'palindrome radius'	
	        r[j][0] = 0;
	 
	        int i = 1;
	        while (i <= n)
	        {
	            //  Attempt to expand palindrome centered at i
	            while (c[i - rp - 1] == c[i + j + rp])
	                rp++;  // Incrementing the length of palindromic
	                       // radius as and when we find vaid palindrome
	 
	            // Assigning the found palindromic length to odd/even
	            // length array
	            r[j][i] = rp;
	            int k = 1;
	            while ((r[j][i - k] != rp - k) && (k < rp))
	            {
	                r[j][i + k] = Math.min(r[j][i - k],rp - k);
	                k++;
	            }
	            rp = Math.max(rp - k,0);
	            i += k;
	        }
	    }
	 
	    // Put all obtained palindromes in a hash map to
	    // find only distinct palindromess	    
	    for (int i = 1; i <= n; i++) {
	        for (int j = 0; j <= 1; j++) {
	            for (int rp = r[j][i]; rp > 0; rp--) {
	               int begin = i - rp - 1;
	               int end = begin + 2 * rp + j;
	               String substring = s.substring(begin, end);
	               if (!substring.trim().equals("") && substring.length() >= 3) {
	            	   m.add(substring);   
	               }	               	               
	            }
	        }
	    }
	 
	    //printing all distinct palindromes from hash map	   
	    for (String str : m) {
	    	System.out.println(str);
	    }
	    
	}
}
