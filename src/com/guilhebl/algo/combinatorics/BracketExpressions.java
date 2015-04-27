package com.guilhebl.algo.combinatorics;

import java.util.Stack;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13243
 * 
 * 
 */
public class BracketExpressions {

	public static void main(String[] args) {
		testBracketExpressions();
	}

	public static void testBracketExpressions() {
		String s = "([]{})";
		System.out.println(ifPossible(s));
		String s2 = "(())[]";
		System.out.println(ifPossible(s2));
		String s3 = "({])";
		System.out.println(ifPossible(s3));
		String s4 = "[]X";
		System.out.println(ifPossible(s4));
		String s5 = "([]X()[()]XX}[])X{{}}]";
		System.out.println(ifPossible(s5));
	}

	private static final String POSSIBLE = "possible";
	private static final String IMPOSSIBLE = "impossible";

	public static String ifPossible(String expression) {
		Stack<Character> opStack = new Stack<>();
		int oPar = 0, oBra = 0, oCur = 0;
		char[] c = expression.toCharArray();
		int numXs = 0;

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				oPar++;
				opStack.push('(');
			} else if (c[i] == '[') {
				oBra++;
				opStack.push('[');
			} else if (c[i] == '{') {
				oCur++;
				opStack.push('{');
			} else if (c[i] == ')') {
				oPar--;
				if (oPar >= 0 && opStack.peek() == '(') {
					opStack.pop();
				} else if (numXs == 0) {
					return IMPOSSIBLE;
				}
			} else if (c[i] == ']') {
				oBra--;
				if (oBra >= 0 && opStack.peek() == '[') {
					opStack.pop();
				} else if (numXs == 0) {
					return IMPOSSIBLE;
				}
			} else if (c[i] == '}') {
				oCur--;
				if (oCur >= 0 && opStack.peek() == '{') {
					opStack.pop();
				} else if (numXs == 0) {
					return IMPOSSIBLE;
				}
			} else if (c[i] == 'X') {
				numXs++;
			}
		}

		char c1;
		while (!opStack.isEmpty() && numXs > 0) {
			c1 = opStack.pop();
			if (c1 == '(') {
				oPar++;
				numXs--;
			} else if (c1 == '[') {
				oBra++;
				numXs--;
			} else if (c1 == '{') {
				oCur++;
				numXs--;
			} else if (c1 == ')') {
				oPar--;
				numXs--;
			} else if (c1 == ']') {
				oBra--;
				numXs--;
			} else if (c1 == '}') {
				oCur--;
				numXs--;
			}
		}

		if (!opStack.isEmpty()) {
			return IMPOSSIBLE;
		}

		if (numXs > 0 && numXs % 2 != 0
				&& (oPar == 0 && oBra == 0 && oCur == 0)) {
			return IMPOSSIBLE;
		}

		while (numXs > 0 && ((oPar != 0 || oBra != 0 || oCur != 0))) {
			if (Math.abs(oPar) > 0) {
				numXs -= Math.abs(oPar);
				oPar = oPar < 0 ? oPar + 1 : oPar - 1;
			}
			if (Math.abs(oBra) > 0) {
				numXs -= Math.abs(oBra);
				oBra = oBra < 0 ? oBra + 1 : oBra - 1;
			}
			if (Math.abs(oCur) > 0) {
				numXs -= Math.abs(oCur);
				oCur = oCur < 0 ? oCur + 1 : oCur - 1;
			}
		}

		if (numXs == 0 || numXs % 2 == 0) {
			return POSSIBLE;
		}

		return IMPOSSIBLE;
	}

}
