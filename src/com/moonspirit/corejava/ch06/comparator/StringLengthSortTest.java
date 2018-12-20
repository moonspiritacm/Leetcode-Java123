package com.moonspirit.corejava.ch06.comparator;

import java.util.Arrays;

public class StringLengthSortTest {
	public static void main(String[] args) {
		String[] words = { "a", "zzz", "bcde" };
//		Arrays.sort(words);
//		for (String word : words)
//			System.out.println(word);
		Arrays.sort(words, new StringLengthComparator());
		for (String word : words)
			System.out.println(word);
	}
}
