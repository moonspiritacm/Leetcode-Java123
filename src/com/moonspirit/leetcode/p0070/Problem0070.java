package com.moonspirit.leetcode.p0070;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0070
 * @Description    [Leetcode 0070](https://leetcode.com/problems/climbing-stairs/) 动态规划
 * @author         moonspirit
 * @date           2019年3月5日 上午11:07:57
 * @version        1.0.0
 */
public class Problem0070 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0070/Problem0070.txt"), "UTF-8");
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
 * @Description    普通递归，重复求解子问题，时间复杂度 O(2^n)
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:01
 * @version        1.0.0
 */
class SolutionA {
	public int climbStairs(int n) {
		if (n < 2)
			return 1;

		return climbStairs(n - 1) + climbStairs(n - 2);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    记忆化递归，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:20
 * @version        1.0.0
 */
class SolutionB {
	private int[] dp;

	private int helper(int n) {
		if (n < 2)
			return 1;
		if (dp[n] != 0)
			return dp[n];

		dp[n] = helper(n - 1) + helper(n - 2);
		return dp[n];
	}

	public int climbStairs(int n) {
		dp = new int[n + 1];
		return helper(n);
	}
}

/**
 * @ClassName      SolutionC
 * @Description    一维动态规划，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:33
 * @version        1.0.0
 */
class SolutionC {
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < n + 1; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}
}

/**
 * @ClassName      SolutionD
 * @Description    一维动态规划，滚动数组优化空间复杂度
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:40
 * @version        1.0.0
 */
class SolutionD {
	public int climbStairs(int n) {
		int[] dp = new int[2];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < n + 1; i++)
			dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
		return dp[n % 2];
	}
}
