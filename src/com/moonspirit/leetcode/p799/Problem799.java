package com.moonspirit.leetcode.p799;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem799
 * @Description    [Leetcode 799](https://leetcode.com/problems/champagne-tower/) 动态规划
 * @author         moonspirit
 * @date           2018年12月19日 上午12:06:51
 * @version        1.0.0
 */
public class Problem799 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p799/Problem799.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.champagneTower(in.nextInt(), in.nextInt(), in.nextInt()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    动态规划，假设杯子空间无限，将连续问题转化为逐层推进的离散问题。dp[i][j] 表示第 i 层的第 j 个杯子水量，仅与 dp[i-1][j-1]、dp[i-1][j] 有关，即 push 模式，时间复杂度 O(n)。
 * @author         moonspirit
 * @date           2018年12月19日 上午12:55:02
 * @version        1.0.0
 */
class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[query_row + 1][query_row + 1];
		dp[0][0] = (double) poured;

		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[i][j] > 1) {
					dp[i + 1][j] += (dp[i][j] - 1) / 2;
					dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
				}
			}
		}
		if (dp[query_row][query_glass] > 1)
			return 1;
		else
			return dp[query_row][query_glass];
	}
}

/**
 * @ClassName      SolutionB
 * @Description    动态规划，dp[i][j] 表示第 i 层的第 j 个杯子水量，仅对 dp[i][j]、dp[i][j+1] 有影响，即 pull 模式，时间复杂度 O(n)。
 * @author         moonspirit
 * @date           2018年12月19日 上午12:58:50
 * @version        1.0.0
 */
class SolutionB {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[query_row + 1][query_row + 1];
		dp[0][0] = (double) poured;

		for (int i = 1; i <= query_row; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 >= 0 && dp[i - 1][j - 1] > 1)
					dp[i][j] += (dp[i - 1][j - 1] - 1) / 2;
				if (j <= i - 1 && dp[i - 1][j] > 1)
					dp[i][j] += (dp[i - 1][j] - 1) / 2;
			}
		}
		if (dp[query_row][query_glass] > 1)
			return 1;
		else
			return dp[query_row][query_glass];
	}
}
