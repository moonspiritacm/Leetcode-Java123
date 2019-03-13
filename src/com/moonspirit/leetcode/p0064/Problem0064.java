package com.moonspirit.leetcode.p0064;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0064
 * @Description    [Leetcode 0064](https://leetcode.com/problems/minimum-path-sum/) 动态规划
 * @author         moonspirit
 * @date           2019年3月4日 下午4:12:35
 * @version        1.0.0
 */
public class Problem0064 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0064/Problem0064.txt"), "UTF-8");
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
	private int dfs(int[][] grid, int m, int n) {
		if (m == 0 && n == 0)
			return grid[0][0];

		if (m == 0)
			return grid[0][n] + dfs(grid, 0, n - 1);
		else if (n == 0)
			return grid[m][0] + dfs(grid, m - 1, 0);
		else
			return grid[m][n] + Math.min(dfs(grid, m, n - 1), dfs(grid, m - 1, n));
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		return dfs(grid, m - 1, n - 1);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    记忆化递归，时间复杂度 O(mn)
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:20
 * @version        1.0.0
 */
class SolutionB {
	private int[][] dp;

	private int dfs(int[][] grid, int m, int n) {
		if (m == 0 && n == 0)
			return grid[0][0];
		if (dp[m][n] != 0)
			return dp[m][n];

		if (m == 0)
			dp[m][n] = grid[m][n] + dfs(grid, 0, n - 1);
		else if (n == 0)
			dp[m][n] = grid[m][n] + dfs(grid, m - 1, 0);
		else
			dp[m][n] = grid[m][n] + Math.min(dfs(grid, m, n - 1), dfs(grid, m - 1, n));
		return dp[m][n];
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		dp = new int[m][n];
		return dfs(grid, m - 1, n - 1);
	}
}

/**
 * @ClassName      SolutionC
 * @Description    二维动态规划，时间复杂度 O(mn)
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:33
 * @version        1.0.0
 */
class SolutionC {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int j = 1; j < n; j++)
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
			for (int j = 1; j < n; j++)
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
		}
		return dp[m - 1][n - 1];
	}
}

/**
 * @ClassName      SolutionD
 * @Description    二维动态规划，优化空间复杂度
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:40
 * @version        1.0.0
 */
class SolutionD {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for (int j = 1; j < n; j++)
			dp[j] = dp[j - 1] + grid[0][j];
		for (int i = 1; i < m; i++) {
			dp[0] = dp[0] + grid[i][0];
			for (int j = 1; j < n; j++)
				dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
		}
		return dp[n - 1];
	}
}
