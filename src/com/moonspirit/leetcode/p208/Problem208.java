package com.moonspirit.leetcode.p208;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem208
 * @Description    [Leetcode 208](https://leetcode.com/problems/implement-trie-prefix-tree/) 字典树
 * @author         moonspirit
 * @date           2019年2月26日 上午1:20:24
 * @version        1.0.0
 */
public class Problem208 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p208/Problem208.txt"), "UTF-8");
		Trie obj = new Trie();

		long begin = System.currentTimeMillis();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("app"));
		System.out.println(obj.startsWith("app"));
		obj.insert("app");
		System.out.println(obj.search("app"));
		System.out.println(obj.startsWith("app"));
		System.out.println(obj.search(""));
		obj.insert("");
		System.out.println(obj.startsWith(""));
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/*
 * class TrieNode { boolean isWord; TrieNode[] next;
 * 
 * public TrieNode() { next = new TrieNode[26]; } }
 * 
 * class Trie { TrieNode root;
 * 
 * public Trie() { root = new TrieNode(); }
 * 
 * public void insert(String input) { if (input == null || input.length() == 0)
 * return;
 * 
 * char[] chs = input.toCharArray(); TrieNode curr = root; for (char ch : chs) {
 * if (curr.next[ch - 'a'] == null) { curr.next[ch - 'a'] = new TrieNode(); }
 * curr = curr.next[ch - 'a']; } curr.isWord = true; }
 * 
 * public boolean search(String input) { if (input == null || input.length() ==
 * 0) return true;
 * 
 * char[] chs = input.toCharArray(); TrieNode curr = root; for (char ch : chs) {
 * if (curr.next[ch - 'a'] == null) { return false; } curr = curr.next[ch -
 * 'a']; } return curr.isWord; }
 * 
 * public boolean startsWith(String input) { if (input == null || input.length()
 * == 0) return true;
 * 
 * char[] chs = input.toCharArray(); TrieNode curr = root; for (char ch : chs) {
 * if (curr.next[ch - 'a'] == null) { return false; } curr = curr.next[ch -
 * 'a']; } return true; } }
 */

class TrieNode {
	boolean isWord;
	Map<Character, TrieNode> next;

	public TrieNode() {
		next = new HashMap<>();
	}
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String input) {
		if (input == null)
			return;
		if (input.length() == 0) {
			root.isWord = true;
			return;
		}

		char[] chs = input.toCharArray();
		TrieNode curr = root;
		for (char ch : chs) {
			if (!curr.next.containsKey(ch)) {
				curr.next.put(ch, new TrieNode());
			}
			curr = curr.next.get(ch);
		}
		curr.isWord = true;
	}

	public boolean search(String input) {
		if (input == null)
			return false;
		if (input.length() == 0 && root.isWord)
			return true;

		char[] chs = input.toCharArray();
		TrieNode curr = root;
		for (char ch : chs) {
			if (!curr.next.containsKey(ch)) {
				return false;
			}
			curr = curr.next.get(ch);
		}
		return curr.isWord;
	}

	public boolean startsWith(String input) {
		if (input == null)
			return false;
		if (input.length() == 0)
			return true;

		char[] chs = input.toCharArray();
		TrieNode curr = root;
		for (char ch : chs) {
			if (!curr.next.containsKey(ch)) {
				return false;
			}
			curr = curr.next.get(ch);
		}
		return true;
	}
}
