package com.moonspirit.leetcode.p0242;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0242
 * @Description    [Leetcode 0242](https://leetcode.com/problems/valid-anagram/) 判断字母异位词
 * @author         moonspirit
 * @date           2019年3月18日 下午3:54:41
 * @version        1.0.0
 */
public class Problem0242 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0242/Problem0242.txt"), "UTF-8");
		// Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		/*
		 * while (in.hasNextLine()) { int[] nums = stringToIntegerArray(in.nextLine());
		 * int target = Integer.parseInt(in.nextLine());
		 * System.out.println(integerArrayToString(solution.twoSum(nums, target))); }
		 */
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] count = new int[26];
		char[] chs1 = s.toCharArray();
		char[] chs2 = t.toCharArray();
		for (char ch : chs1)
			count[ch - 'a']++;
		for (char ch : chs2)
			count[ch - 'a']--;
		for (int i = 0; i < 26; i++)
			if (count[i] != 0)
				return false;
		return true;
	}
}
