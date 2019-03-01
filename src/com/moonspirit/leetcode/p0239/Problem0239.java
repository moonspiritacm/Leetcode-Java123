package com.moonspirit.leetcode.p0239;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0239
 * @Description    [Leetcode 0239](https://leetcode.com/problems/sliding-window-maximum/) 单调队列
 * @author         moonspirit
 * @date           2019年3月1日 下午6:03:08
 * @version        1.0.0
 */
public class Problem0239 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0239/Problem0239.txt"), "UTF-8");
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
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return nums;

		int[] res = new int[nums.length + 1 - k];
		for (int i = 0; i <= nums.length - k; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < k; j++) {
				max = max > nums[i + j] ? max : nums[i + j];
			}
			res[i] = max;
		}
		return res;
	}
}
