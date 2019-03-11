package com.moonspirit.leetcode.p0400;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0400
 * @Description    [Leetcode 0400](https://leetcode.com/problems/nth-digit/) 水题
 * @author         moonspirit
 * @date           2019年3月11日 下午7:25:15
 * @version        1.0.0
 */
public class Problem0400 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0400/Problem0400.txt"), "UTF-8");
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
	public int findNthDigit(int n) {
		// 个位数 9；十位数 90*2；百位数 900*3
		if (n <= 0)
			return 0;

		int i = 1;
		while (true) {
			if (n <= 9 * Math.pow(10, i - 1) * i)
				break;
			n -= 9 * Math.pow(10, i - 1) * i;
			i++;
		}
		int x = (n - 1) / i;
		int y = (n - 1) % i;
		int num = (int) Math.pow(10, i - 1) + x;
		for (int j = 0; j < i - y - 1; j++)
			num = num / 10;
		return num % 10;
	}
}
