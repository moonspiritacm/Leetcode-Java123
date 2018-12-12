package com.moonspirit.leetcode.p174;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem174
 * @Description    [Leetcode 174](https://leetcode.com/problems/dungeon-game/) 动态规划
 * @author         moonspirit
 * @date           2018年12月10日 下午7:46:47
 * @version        1.0.0
 */
public class Problem174 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	public static int[][] stringToInt2dArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0][0];

		String[] parts = input.split("],");
		int[][] output = new int[parts.length][];
		for (int i = 0; i < parts.length - 1; i++) {
			output[i] = stringToIntegerArray(parts[i] + "]");
		}
		output[parts.length - 1] = stringToIntegerArray(parts[parts.length - 1]);
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p174/Problem174.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.calculateMinimumHP(stringToInt2dArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    动态规划，dp[i][j] 表示从 (i, j) 移动到右下角需要的最少血量，时间复杂度 O(n^2)
 * @author         moonspirit
 * @date           2018年12月10日 下午9:53:30
 * @version        1.0.0
 */
class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] dp = new int[row + 1][col + 1];

		for (int j = col - 2; j >= 0; j--)
			dp[row][j] = Integer.MAX_VALUE;
		for (int i = row - 2; i >= 0; i--)
			dp[i][col] = Integer.MAX_VALUE;
		dp[row][col - 1] = dp[row - 1][col] = 1;

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				dp[i][j] = Integer.max(1, Integer.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
			}
		}
		return dp[0][0];
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    动态规划，存储空间优化，当前状态仅与右方（本轮循环）和下方（上轮循环）状态有关，时间复杂度 O(n^2)
 * @author         moonspirit
 * @date           2018年12月10日 下午10:15:17
 * @version        1.0.0
 */
class SolutionA1 {
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[] dp = new int[col + 1];

		for (int j = col; j >= 0; j--)
			dp[j] = Integer.MAX_VALUE;
		dp[col - 1] = 1;

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				dp[j] = Integer.max(1, Integer.min(dp[j + 1], dp[j]) - dungeon[i][j]);
			}
		}
		return dp[0];
	}
}
