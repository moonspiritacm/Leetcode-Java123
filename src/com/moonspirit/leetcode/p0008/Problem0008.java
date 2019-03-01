package com.moonspirit.leetcode.p0008;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0008
 * @Description    [Leetcode 0008](https://leetcode.com/problems/string-to-integer-atoi/) 字符串
 * @author         moonspirit
 * @date           2019年3月2日 上午12:41:53
 * @version        1.0.0
 */
public class Problem0008 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0008/Problem0008.txt"), "UTF-8");
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
	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		int res = 0;
		boolean start = false;
		boolean negative = false;
		char[] chs = str.toCharArray();
		for (char ch : chs) {
			if (!start) {
				if (ch == ' ') {
				} else if (ch == '+') {
					start = true;
				} else if (ch == '-') {
					start = true;
					negative = true;
				} else if (Character.isDigit(ch)) {
					start = true;
					if (negative)
						res -= (int) (ch - '0');
					else
						res += (int) (ch - '0');
				} else {
					return 0;
				}
			} else {
				if (Character.isDigit(ch)) {
					int tmp = (int) (ch - '0');
					if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7))
						return 2147483647;
					if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp > 8))
						return -2147483648;
					if (negative)
						res = res * 10 - (int) (ch - '0');
					else
						res = res * 10 + (int) (ch - '0');
				} else {
					return res;
				}
			}
		}
		return res;
	}
}
