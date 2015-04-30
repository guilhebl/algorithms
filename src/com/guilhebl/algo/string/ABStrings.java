package com.guilhebl.algo.string;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13642
 *
 */
public class ABStrings {

	public static void main(String[] args) {
		solveABStrings();
	}

	private static void solveABStrings() {
		System.out.println(getABString(3,2));
		System.out.println(getABString(2, 0));
		System.out.println(getABString(5, 8));
		System.out.println(getABString(10, 12));
		System.out.println(getABString(9, 7));
	}

	private static String getABString(int n, int k) {
		int max = new Double(Math.pow((n / 2), 2)).intValue();
		max = max == 1 ? 2 : max;

		StringBuilder sb = new StringBuilder();
		StringBuilder sbA = new StringBuilder();
		int i = 0, size = 0, len = 0;

		if (k > max) {
			return "";
		} else if (k == 0) {
			while (len < n / 2) {
				sb.append("B");
				len++;
			}
			while (len < n) {
				sb.append("A");
				len++;
			}
			return sb.toString();
		}

		if (k <= 2) {
			sb.append("B");
			len++;
		}

		while (i < max && len < n) {
			sb.append("B");
			sbA.append("A");
			size++;
			len += 2;
			i = (size * size);
		}
		sb = sbA.append(sb);

		int v = max, factor = n / 2;
		int iA, iB;
		while (v > k) {
			iA = sb.indexOf("B") - 1;
			iB = sb.lastIndexOf("B");
			swap(sb, iA, iB);
			v -= factor;
		}

		int diff = k - v;
		while (diff > 0) {
			iB = sb.lastIndexOf("B");
			swap(sb, iB, iB + 1);
			diff--;
		}

		int lenFinal = sb.length();
		while (lenFinal < n) {
			sb.append("A");
			lenFinal++;
		}

		return sb.toString();
	}

	private static void swap(StringBuilder sb, int i, int j) {
		char temp1 = sb.charAt(i);
		char temp2 = sb.charAt(j);
		sb.setCharAt(i, temp2);
		sb.setCharAt(j, temp1);
	}
}