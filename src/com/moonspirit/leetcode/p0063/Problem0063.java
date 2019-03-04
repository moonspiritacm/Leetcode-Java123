package com.moonspirit.leetcode.p0063;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0063
 * @Description    [Leetcode 0063](https://leetcode.com/problems/unique-paths-ii/) 动态规划
 * @author         moonspirit
 * @date           2019年3月5日 上午12:43:21
 * @version        1.0.0
 */
public class Problem0063 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0063/Problem0063.txt"), "UTF-8");
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
	private int helper(int[][] obstacleGrid, int m, int n) {
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		if (m == 1 && n == 1)
			return 1;

		if (m == 1)
			return helper(obstacleGrid, m, n - 1);
		else if (n == 1)
			return helper(obstacleGrid, m - 1, n);
		else
			return helper(obstacleGrid, m, n - 1) + helper(obstacleGrid, m - 1, n);
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		return helper(obstacleGrid, m, n);
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

	private int helper(int[][] obstacleGrid, int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		if (dp[m][n] != 0)
			return dp[m][n];

		if (m == 1)
			dp[m][n] = helper(obstacleGrid, m, n - 1);
		else if (n == 1)
			dp[m][n] = helper(obstacleGrid, m - 1, n);
		else
			dp[m][n] = helper(obstacleGrid, m, n - 1) + helper(obstacleGrid, m - 1, n);
		return dp[m][n];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		dp = new int[m + 1][n + 1];
		return helper(obstacleGrid, m, n);
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
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 0)
				dp[0][j] = dp[0][j - 1];
			else
				dp[0][j] = 0;
		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0)
				dp[i][0] = dp[i - 1][0];
			else
				dp[i][0] = 0;
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0)
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				else
					dp[i][j] = 0;
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
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 0)
				dp[j] = dp[j - 1];
			else
				dp[j] = 0;
		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0)
				dp[0] = dp[0];
			else
				dp[0] = 0;
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0)
					dp[j] = dp[j - 1] + dp[j];
				else
					dp[j] = 0;
			}
		}
		return dp[n - 1];
	}
}
