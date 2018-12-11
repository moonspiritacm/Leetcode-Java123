package com.moonspirit.leetcode.p304;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem304
 * @Description    [Leetcode 304](https://leetcode.com/problems/range-sum-query-2d-immutable/) 动态规划
 * @author         moonspirit
 * @date           2018年12月11日 下午10:08:16
 * @version        1.0.0
 */
public class Problem304 {
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
		if (input.length() == 0) {
			return new int[0][0];
		}

		String[] parts = input.split("],");
		int[][] output = new int[parts.length][];
		for (int i = 0; i < parts.length - 1; i++) {
			output[i] = stringToIntegerArray(parts[i] + "]");
		}
		output[parts.length - 1] = stringToIntegerArray(parts[parts.length - 1]);
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p304/Problem304.txt"), "UTF-8");

		long begin = System.currentTimeMillis();
		String str = in.nextLine();
		NumMatrix obj = new NumMatrix(stringToInt2dArray(str));
		while (in.hasNextLine()) {
			int row1 = in.nextInt();
			int col1 = in.nextInt();
			int row2 = in.nextInt();
			int col2 = in.nextInt();
			System.out.println(obj.sumRegion(row1, col1, row2, col2));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      NumMatrix
 * @Description    动态规划，dp[i][j] 表示 (0, 0) 到 (i-1,j-1) 区域的元素和，dp[0][j] 与 dp[i][0] 用于处理边界情况，时间复杂度 O(n^2+m)
 * @author         moonspirit
 * @date           2018年12月12日 上午12:35:50
 * @version        1.0.0
 */
class NumMatrix {
	private int[][] dp;

	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int rowLen = matrix.length + 1;
		int colLen = matrix[0].length + 1;
		dp = new int[rowLen][colLen];
		for (int i = 1; i < rowLen; i++)
			for (int j = 1; j < colLen; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
	}
}
