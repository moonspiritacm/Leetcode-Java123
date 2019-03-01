package com.moonspirit.leetcode.p0065;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0065
 * @Description    [Leetcode 0065](https://leetcode.com/problems/valid-number/) 字符串
 * @author         moonspirit
 * @date           2019年3月2日 上午2:06:56
 * @version        1.0.0
 */
public class Problem0065 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0065/Problem0065.txt"), "UTF-8");
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
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;

		char[] chs = s.toCharArray();
		boolean digit = false;
		boolean dot = false;
		boolean exp = false;
		int i = 0;
		while (i < chs.length && chs[i] == ' ')
			i++;
		if (i < chs.length && (chs[i] == '+' || chs[i] == '-')) {
			i++;
		}

		while (i < chs.length) {
			if (chs[i] == '.') {
				if (dot || exp) {
					return false;
				} else {
					dot = true;
				}
			} else if (chs[i] == 'e') {
				if (exp || !digit) {
					return false;
				} else {
					exp = true;
					digit = false;
				}
			} else if (Character.isDigit(chs[i])) {
				digit = true;
			} else if ((chs[i] == '+' || chs[i] == '-') && chs[i - 1] == 'e') {
			} else {
				break;
			}
			i++;
		}
		while (i < chs.length && chs[i] == ' ')
			i++;

		return digit && i == chs.length;
	}
}
