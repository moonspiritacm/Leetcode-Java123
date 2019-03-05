package com.moonspirit.leetcode.p0509;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0509
 * @Description    [Leetcode 0509](https://leetcode.com/problems/fibonacci-number/) 动态规划
 * @author         moonspirit
 * @date           2019年3月5日 下午12:20:32
 * @version        1.0.0
 */
public class Problem0509 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0509/Problem0509.txt"), "UTF-8");
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
class Solution {
	public int fib(int N) {
		if (N < 2)
			return N;
		return fib(N - 1) + fib(N - 2);
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
			return n;
		if (dp[n] != 0)
			return dp[n];

		dp[n] = helper(n - 1) + helper(n - 2);
		return dp[n];
	}

	public int fib(int N) {
		dp = new int[N + 1];
		return helper(N);
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
	public int fib(int N) {
		if (N < 2)
			return N;

		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < N + 1; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[N];
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
	public int fib(int N) {
		if (N < 2)
			return N;

		int[] dp = new int[2];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < N + 1; i++)
			dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
		return dp[N % 2];
	}
}
