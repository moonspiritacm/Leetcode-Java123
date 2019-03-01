package com.moonspirit.leetcode.p0007;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0007
 * @Description    [Leetcode 0007](https://leetcode.com/problems/reverse-integer/) 数学
 * @author         moonspirit
 * @date           2019年3月1日 下午11:23:12
 * @version        1.0.0
 */
public class Problem0007 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0007/Problem0007.txt"), "UTF-8");
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
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			// 2147483647
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
				return 0;
			}
			// -2147483648
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
				return 0;
			}
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}
}
