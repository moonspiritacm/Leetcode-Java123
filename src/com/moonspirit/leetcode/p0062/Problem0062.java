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

class SolutionA {
	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1)
			return 1;

		if (m == 1)
			return uniquePaths(m, n - 1);
		if (n == 1)
			return uniquePaths(m - 1, n);
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
}

class SolutionB {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int j = 1; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}