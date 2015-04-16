package com.guilhebl.algo.combinatorics;

/**
 * Find if a pattern matches given String:
 * 
		isMatchPattern("abcddd", "abcd*"));
		isMatchPattern("ccca", "c*a"));
		isMatchPattern("ab", ".*"));
		isMatchPattern("abcdefffffffg", "a*c..f*"));
		isMatchPattern("fffffffgcdeeeeeee","f*g..e*")) = 
		isMatchPattern("abc", "...e*"));
 * 
 * 
 * output:
 * 
 * Match true
Match true
Match true
Match false
Match true
Match true
 * 
 * @author root
 *
 */
public class PatternMatcher {

	public static void main(String[] args) {
		 System.out.println("Match " + isMatchPattern("abcddd", "abcd*"));
		 System.out.println("Match " + isMatchPattern("ccca", "c*a"));
		 System.out.println("Match " + isMatchPattern("ab", ".*"));
		 System.out.println("Match " + isMatchPattern("abcdefffffffg",
		 "a*c..f*"));
		 System.out.println("Match " + isMatchPattern("fffffffgcdeeeeeee",
		 "f*g..e*"));
		 System.out.println("Match " + isMatchPattern("abc", "...e*"));
	}


	public static boolean isMatchPattern(String s, String p) {

		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();

		boolean inRep = false;
		int i = 0, j = 0;

		while (i < cs.length && j < cp.length) {
			if (j + 1 < cp.length) {
				if (cp[j + 1] == '*') {
					inRep = true;
				}
			}
			if (cs[i] == cp[j] || cp[j] == '.') {
				if (inRep && cp[j] != '.' && cp[j] != '*') {
					while (i < cs.length && j < cp.length && cs[i] == cp[j]) {
						i++;
					}
					j += 2;
					inRep = false;
				} else {
					i++;
					j++;
				}
			} else {
				if (inRep) {
					i++;
					j++;
					inRep = false;
				} else {
					return false;
				}
			}
		}

		if (i < cs.length) {
			return false;
		}

		return true;
	}

}
