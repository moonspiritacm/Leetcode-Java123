package com.moonspirit.leetcode.p438;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem438 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p438/Problem438.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String s = in.nextLine();
			String p = in.nextLine();
			System.out.println(solution.findAnagrams(s, p));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class SolutionA {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		char[] sArray = s.toCharArray();
		char[] pArray = p.toCharArray();
		int[] target = new int[26];
		for (int i = 0; i < pArray.length; i++) {
			target[pArray[i] - 'a']++;
		}

		for (int i = 0; i <= sArray.length - pArray.length; i++) {
			int[] map = new int[26];
			for (int j = 0; j < pArray.length; j++) {
				map[sArray[i + j] - 'a']++;
			}
			if (Arrays.equals(target, map)) {
				res.add(i);
			}
		}
		return res;
	}
}

class SolutionB {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		char[] sArray = s.toCharArray();
		char[] pArray = p.toCharArray();
		int[] target = new int[26];
		int[] map = new int[26];
		for (int i = 0; i < pArray.length; i++) {
			target[pArray[i] - 'a']++;
		}

		int left = 0;
		int right = 0;
		while (right < sArray.length) {
			map[sArray[right] - 'a']++;
			if (right - left + 1 == pArray.length) {
				if (Arrays.equals(target, map)) {
					res.add(left);
				}
				map[sArray[left++] - 'a']--;
			}
			right++;
		}
		return res;
	}
}
