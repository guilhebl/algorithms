package com.guilhebl.algo.string;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *   You are given two strings. String T is a string where characters need to be reordered.
 *   String O contains characters (none of them repeated) which defines the order/precendence
 *   to be used while reordering the string T. Write an algorithm to do the reordering.
 *   
 * @author root
 *
 */
public class OrderStringByReferenceString {

	public static void main(String[] args) {

		String t = "water";
		String o = "zealot";
		System.out.println(orderStringByRef(t, o));
	}

	public static String orderStringByRef(String t, String o) {

		StringBuilder sb = new StringBuilder();
		char c;
		int indexOfChar = -1;
		List<CharSeq> list = new ArrayList<>();

		for (int i = 0; i < t.length(); i++) {
			c = t.charAt(i);
			indexOfChar = o.indexOf(c);
			if (indexOfChar >= 0) {
				CharSeq cs = new CharSeq();
				cs.c = c;
				cs.i = indexOfChar;
				list.add(cs);
			} else {
				sb.append(c);
			}
		}

		list.sort(new CharSeqComparator());

		for (CharSeq cs : list) {
			sb.append(cs.c);
		}

		return sb.toString();
	}

}

class CharSeq {
	char c;
	int i;
}

class CharSeqComparator implements Comparator<CharSeq> {

	@Override
	public int compare(CharSeq a, CharSeq b) {
		if (a.i < b.i) {
			return -1;
		} else if (a.i == b.i) {
			return 0;
		} else if (a.i > b.i) {
			return 1;
		}
		return -1;
	}
}