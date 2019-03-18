package com.moonspirit.leetcode.p0048;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0048
 * @Description    [Leetcode 0048](https://leetcode.com/problems/rotate-image/) 旋转图像
 * @author         moonspirit
 * @date           2019年3月18日 上午10:09:11
 * @version        1.0.0
 */
public class Problem0048 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0048/Problem0048.txt"), "UTF-8");
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
 * @ClassName      Solution
 * @Description    先以左斜对角线为轴翻转，再以竖对称轴翻转
 * @author         moonspirit
 * @date           2019年3月18日 上午10:10:54
 * @version        1.0.0
 */
class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
				matrix[j][i] = matrix[i][j] ^ matrix[j][i];
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = matrix[i][j] ^ matrix[i][n - 1 - j];
				matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
			}
		}
	}
}
