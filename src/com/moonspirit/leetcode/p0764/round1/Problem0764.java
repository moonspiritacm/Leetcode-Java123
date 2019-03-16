package com.moonspirit.leetcode.p0764.round1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName      Problem0764
 * @Description    [Leetcode 0764](https://leetcode.com/problems/largest-plus-sign/) 动态规划
 * @author         moonspirit
 * @date           2019年3月16日 下午4:52:56
 * @version        1.0.0
 */
public class Problem0764 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0764/Problem0764.txt"), "UTF-8");
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
 * @Description    暴力求解，时间复杂度 O(n^3)，空间复杂度 O(1)
 * @author         moonspirit
 * @date           2019年3月16日 下午4:54:38
 * @version        1.0.0
 */
class SolutionA {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		if (N < 1)
			return 0;
		if (mines == null || mines.length == 0)
			return (N + 1) / 2;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mines.length; i++)
			set.add(mines[i][0] * N + mines[i][1]);
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = 0;
				while (0 <= i - k && i + k < N && 0 <= j - k && j + k < N && !set.contains((i - k) * N + j)
						&& !set.contains((i + k) * N + j) && !set.contains(i * N + j - k)
						&& !set.contains(i * N + j + k))
					k++;
				res = res > k ? res : k;
			}
		}
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    二维动态规划分别计算各个位置上下左右连续1的个数，四者的最小值为该位置的标志数，遍历所有位置计算最大标志数，时间复杂度 O(n^2)，空间复杂度 O(4 * n^2)
 * @author         moonspirit
 * @date           2019年3月16日 下午5:34:40
 * @version        1.0.0
 */
class SolutionB {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		if (N < 1)
			return 0;
		if (mines == null || mines.length == 0)
			return (N + 1) / 2;

		int[][] left = new int[N][N];
		int[][] right = new int[N][N];
		int[][] up = new int[N][N];
		int[][] down = new int[N][N];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mines.length; i++)
			set.add(mines[i][0] * N + mines[i][1]);
		for (int i = 0; i < N; i++) {
			left[i][0] = set.contains(i * N) ? 0 : 1;
			for (int j = 1; j < N; j++) {
				left[i][j] = set.contains(i * N + j) ? 0 : left[i][j - 1] + 1;
			}
			right[i][N - 1] = set.contains(i * N + N - 1) ? 0 : 1;
			for (int j = N - 2; j >= 0; j--) {
				right[i][j] = set.contains(i * N + j) ? 0 : right[i][j + 1] + 1;
			}
		}
		for (int j = 0; j < N; j++) {
			up[0][j] = set.contains(j) ? 0 : 1;
			for (int i = 1; i < N; i++) {
				up[i][j] = set.contains(i * N + j) ? 0 : up[i - 1][j] + 1;
			}
			down[N - 1][j] = set.contains((N - 1) * N + j) ? 0 : 1;
			for (int i = N - 2; i >= 0; i--) {
				down[i][j] = set.contains(i * N + j) ? 0 : down[i + 1][j] + 1;
			}
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = Integer.MAX_VALUE;
				tmp = Math.min(tmp, left[i][j]);
				tmp = Math.min(tmp, right[i][j]);
				tmp = Math.min(tmp, up[i][j]);
				tmp = Math.min(tmp, down[i][j]);
				res = Math.max(res, tmp);
			}
		}
		return res;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    将四个二维矩阵优化为一个二维矩阵，空间复杂度 O(n^2)
 * @author         moonspirit
 * @date           2019年3月16日 下午5:48:24
 * @version        1.0.0
 */
class SolutionC {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		if (N < 1)
			return 0;
		if (mines == null || mines.length == 0)
			return (N + 1) / 2;

		int res = 0;
		int count = 0;
		int[][] dp = new int[N][N];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < mines.length; i++)
			set.add(mines[i][0] * N + mines[i][1]);
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				dp[i][j] = count;
			}
			count = 0;
			for (int j = N - 1; j >= 0; j--) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				dp[i][j] = Math.min(dp[i][j], count);
			}
		}
		for (int j = 0; j < N; j++) {
			count = 0;
			for (int i = 0; i < N; i++) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				dp[i][j] = Math.min(dp[i][j], count);
			}
			count = 0;
			for (int i = N - 1; i >= 0; i--) {
				count = set.contains(i * N + j) ? 0 : count + 1;
				dp[i][j] = Math.min(dp[i][j], count);
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}
}
