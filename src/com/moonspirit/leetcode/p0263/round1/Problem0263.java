package com.moonspirit.leetcode.p0263.round1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0263
 * @Description    [Leetcode 0263](https://leetcode.com/problems/ugly-number/) 判断丑数
 * @author         moonspirit
 * @date           2019年3月11日 下午5:28:23
 * @version        1.0.0
 */
public class Problem0263 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0263/Problem0263.txt"), "UTF-8");
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
	public boolean isUgly(int num) {
		if (num < 1)
			return false;

		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		if (num == 1)
			return true;
		else
			return false;
	}
}
