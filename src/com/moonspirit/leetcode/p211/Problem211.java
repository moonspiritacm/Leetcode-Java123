package com.moonspirit.leetcode.p211;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem211
 * @Description    [Leetcode 211](https://leetcode.com/problems/add-and-search-word-data-structure-design/) 字典树
 * @author         moonspirit
 * @date           2019年2月27日 上午12:32:56
 * @version        1.0.0
 */
public class Problem211 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p211/Problem211.txt"), "UTF-8");
		WordDictionary obj = new WordDictionary();

		long begin = System.currentTimeMillis();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class TrieNode {
	boolean isWord;
	TrieNode[] next;

	public TrieNode() {
		next = new TrieNode[26];
	}
}

class WordDictionary {
	TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word == null)
			return;
		if (word.length() == 0) {
			root.isWord = true;
			return;
		}

		char[] chs = word.toCharArray();
		TrieNode curr = root;
		for (char ch : chs) {
			if (curr.next[ch - 'a'] == null) {
				curr.next[ch - 'a'] = new TrieNode();
			}
			curr = curr.next[ch - 'a'];
		}
		curr.isWord = true;
		return;
	}

	private boolean search(TrieNode root, char[] chs, int s) {
		if (s == chs.length)
			return root.isWord;

		if (chs[s] != '.') {
			if (root.next[chs[s] - 'a'] == null) {
				return false;
			} else {
				return search(root.next[chs[s] - 'a'], chs, s + 1);
			}
		} else {
			for (int i = 0; i < 26; i++) {
				if (root.next[i] != null && search(root.next[i], chs, s + 1)) {
					return true;
				}
			}
			return false;
		}
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		if (word == null)
			return false;
		if (word.length() == 0) {
			return root.isWord;
		}

		char[] chs = word.toCharArray();
		return search(root, chs, 0);
	}
}
