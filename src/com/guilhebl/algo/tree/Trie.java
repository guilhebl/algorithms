package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Trie implementation in Java.
 * 
 */
public class Trie {

	public static void main(String[] args) {
		testTrieNode();
	}

	public static void testTrieNode() {

		TrieNode root = new TrieNode();
		root.insertWord("tree");
		root.insertWord("faith");
		root.insertWord("father");		
		root.insertWord("treemap");
		root.insertWord("also");
		root.insertWord("algorithm");
		root.insertWord("aligator");
		root.insertWord("treck");
		root.insertWord("track");

		List<String> results = root.findPrefixes("tre");
		printListOfStr(results);
		
		results = root.findPrefixes("fa");
		printListOfStr(results);

		results = root.findPrefixes("al");
		printListOfStr(results);

	}
	
	public static void printListOfStr(List<String> results) {
		for (String str : results) {
			System.out.println(str);
		}		
	}
}

class TrieNode {

	String value;
	boolean isWord = false;
	Map<Character, TrieNode> children;

	public TrieNode() {
		this("");
	}

	public TrieNode(String val) {
		this.value = val;
		this.children = new HashMap<>();
	}

	public TrieNode addChild(Character c) {
		String val = this.value;

		if (val == null) {
			val = c.toString();
		} else {
			val = val + c;
		}
		TrieNode n1 = new TrieNode(val);

		this.children.put(c, n1);
		return n1;
	}

	public void insertWord(String word) {
		char[] chars = word.toCharArray();
		TrieNode n = this;

		for (int i = 0; i < chars.length; i++) {
			if (n.children.containsKey(chars[i])) {
				n = n.children.get(chars[i]);
			} else {
				n = n.addChild(chars[i]);
			}
		}
		n.isWord = true;
	}

	public List<String> findAllWordsOfPrefix(String word) {
		List<String> result = new ArrayList<>();
		if (this.isWord) {
			result.add(this.value);
			return result;
		} else {
			for (Map.Entry<Character, TrieNode> node : this.children.entrySet()) {
				result.addAll(node.getValue().findAllWordsOfPrefix(word));
			}
		}
		return result;
	}

	public List<String> findPrefixes(String word) {
		char[] chars = word.toCharArray();
		TrieNode n = this;

		for (int i = 0; i < chars.length; i++) {
			if (n.children.containsKey(chars[i])) {
				n = n.children.get(chars[i]);
			} else {
				return null;
			}
		}

		List<String> result = new ArrayList<String>();
		if (n.isWord) {
			result.add(n.value);
		} else {
			result.addAll(n.findAllWordsOfPrefix(n.value));
		}

		return result;
	}

}
