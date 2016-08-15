package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/mini-parser/
 *
 */

public class MiniParser {
	
	public static void main(String[] args) {
		MiniParser m = new MiniParser();
		NestedInteger n = m.deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]");
		System.out.println(n.toString());
	}

	public NestedInteger deserialize(String s) {
		if (!s.startsWith("[")) {
			return new NestedInteger(Integer.parseInt(s));
		}
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger ni = new NestedInteger();
		stack.push(ni);		
		int start = 1;
		char[] c = s.toCharArray();
		for(int i = 1; i < c.length; i++) {
			char curr = c[i];
			if (curr == '[') {
				NestedInteger nChild = new NestedInteger();
				stack.peek().add(nChild);
				stack.push(nChild);
				start = i + 1;
			} if (curr == ',' || curr == ']') {
				if (i > start) {
					NestedInteger nChild = new NestedInteger(Integer.valueOf(s.substring(start, i)));
					stack.peek().add(nChild);
				}								
				if (curr == ']') {
					stack.pop();
				}								
				start = i + 1;
			}
		}
		return ni;
    }
    
    
}

class NestedInteger {
	Integer num;
	List<NestedInteger> list;
	public NestedInteger() {
		list = new ArrayList<>();
	}
	public NestedInteger(int num) {
		super();
		this.num = new Integer(num);
	}
	public void add(NestedInteger ni) {
		this.list.add(ni);
	}
	public boolean isInteger() {
		return num != null;
	}
	public List<NestedInteger> getList() {
		return list;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.isInteger()) {
			sb.append(num);
		} else {			
			sb.append("[");
			List<NestedInteger> l = getList();
			for (NestedInteger nestedInteger : l) {
				sb.append(nestedInteger.toString());
				sb.append(",");
			}
			sb.append("]");
		}
		return sb.toString();
	}
}