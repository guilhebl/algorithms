package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all permutations of string
 * 
 * Example:
 * 
 * input: "abc"
 * 
 * output:
 * 
abc
acb
bac
bca
cba
cab

 * @author root
 *
 */
public class PrintAllPerms {

	public static void main(String[] args) {
		solvePrintAllPerms();
	}

	public static void solvePrintAllPerms() {
		String s = "abc";
		printAllPerms(s.toCharArray(), 0);
	}

	public static void printAllPerms(char[] a, int i) {
		if (i > a.length) {
			return;
		} else if (i == a.length) {
			System.out.println(a);
		}
		for (int j = i; j < a.length; j++) {
			swap(a, i, j);
			printAllPerms(a, i + 1);
			swap(a, i, j);
		}
	}

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}