package com.moonspirit.leetcode.p0062;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0062
 * @Description    [Leetcode 0062](https://leetcode.com/problems/unique-paths/) 动态规划
 * @author         moonspirit
 * @date           2019年3月4日 下午4:55:40
 * @version        1.0.0
 */
public class Problem0062 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0062/Problem0062.txt"), "UTF-8");
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
 * @date           2019年3月5日 上午12:11:14
 * @version        1.0.0
 */
class SolutionA {
	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1)
			return 1;

		if (m == 1)
			return uniquePaths(m, n - 1);
		else if (n == 1)
			return uniquePaths(m - 1, n);
		else
			return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    记忆化递归，时间复杂度 O(mn)
 * @author         moonspirit
 * @date           2019年3月5日 上午12:12:55
 * @version        1.0.0
 */
class SolutionB {
	private int[][] dp;

	private int helper(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (dp[m][n] != 0)
			return dp[m][n];

		if (m == 1)
			dp[m][n] = helper(m, n - 1);
		else if (n == 1)
			dp[m][n] = helper(m - 1, n);
		else
			dp[m][n] = helper(m, n - 1) + helper(m - 1, n);
		return dp[m][n];
	}

	public int uniquePaths(int m, int n) {
		dp = new int[m + 1][n + 1];
		return helper(m, n);
	}
}

/**
 * @ClassName      SolutionC
 * @Description    二维动态规划，时间复杂度 O(mn)
 * @author         moonspirit
 * @date           2019年3月5日 上午12:14:31
 * @version        1.0.0
 */
class SolutionC {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int j = 1; j < n; j++)
			dp[0][j] = 1;
		for (int i = 1; i < m; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}

/**
 * @ClassName      SolutionD
 * @Description    二维动态规划，滚动数组优化空间复杂度
 * @author         moonspirit
 * @date           2019年3月5日 上午12:15:27
 * @version        1.0.0
 */
class SolutionD {
	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int j = 1; j < n; j++)
			dp[j] = 1;
		for (int i = 1; i < m; i++) {
			dp[0] = 1;
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}
}
