package com.moonspirit.leetcode.p0053.round1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0053
 * @Description    [Leetcode 0053](https://leetcode.com/problems/maximum-subarray/) 动态规划
 * @author         moonspirit
 * @date           2019年3月16日 下午6:42:25
 * @version        1.0.0
 */
public class Problem0053 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0053/Problem0053.txt"), "UTF-8");
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

/**
 * @ClassName      SolutionA
 * @Description    一维动态规划，dp[i] 表示以 i 结尾的子数组最大和，dp[i] = max(dp[i-1] + nums[i], nums[i])，时间复杂度 O(n)，空间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年3月16日 下午6:42:18
 * @version        1.0.0
 */
class SolutionA {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		int res = nums[0];
		int[] dp = new int[n];
		dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    本轮计算只与上轮计算结果有关，将空间复杂度优化到 O(1)
 * @author         moonspirit
 * @date           2019年3月16日 下午7:32:01
 * @version        1.0.0
 */
class SolutionB {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int res = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			res = Math.max(res, sum);
		}
		return res;
	}
}
