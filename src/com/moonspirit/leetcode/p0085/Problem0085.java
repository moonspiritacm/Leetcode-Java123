package com.moonspirit.leetcode.p0085;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem0085
 * @Description    [Leetcode 0085](https://leetcode.com/problems/maximal-rectangle/) 动态规划 栈模拟
 * @author         moonspirit
 * @date           2019年3月8日 下午11:14:35
 * @version        1.0.0
 */
public class Problem0085 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0085/Problem0085.txt"), "UTF-8");
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
 * @Description    动态规划，确定矩形的三要素（左边界、右边界、高度）：逢 0 重置，逢 1 更新。
 * @author         moonspirit
 * @date           2019年3月8日 下午11:22:18
 * @version        1.0.0
 */
class SolutionA {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int m = matrix.length; // 行数
		int n = matrix[0].length; // 列数
		int height[] = new int[n]; // 从上到下的高度，初始化为 0
		int left[] = new int[n]; // 从左到右，出现连续 1 的最左位置，初始化为 0
		int right[] = new int[n]; // 从右到左，出现连续 1 的最右位置，初始化为 n
		int res = 0;
		Arrays.fill(right, n);
		for (int i = 0; i < m; i++) {
			int currLeft = 0;
			int currRight = n;
			// 更新 height 数组，逢 0 重置高度，逢 1 高度加一
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			// 更新 left 数组，逢 0 置 0，逢 1 取最大值（最严格左边界）
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(currLeft, left[j]);
				} else {
					left[j] = 0;
					currLeft = j + 1;
				}
			}
			// 更新 right 数组，逢 0 置 n，逢 1 取最小值（最严格右边界）
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(currRight, right[j]);
				} else {
					right[j] = n;
					currRight = j;
				}
			}
			for (int j = 0; j < n; j++) {
				res = Math.max(res, (right[j] - left[j]) * height[j]);
			}
		}
		return res;
	}
}

class SolutionB {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int m = matrix.length; // 行数
		int n = matrix[0].length; // 列数
		int res = 0;
		int[] height = new int[n + 1];
		height[n] = 0;

		for (int i = 0; i < m; i++) {
			Stack<Integer> stack = new Stack<>(); // 存储位置
			// 更新 height 数组
			for (int j = 0; j < n + 1; j++) {
				if (j < n) {
					if (matrix[i][j] == '1')
						height[j]++;
					else
						height[j] = 0;
				}
				if (stack.isEmpty() || height[stack.peek()] <= height[j]) {
					stack.push(j);
				} else {
					while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
						int cur = height[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
						res = Math.max(res, cur);
					}
					stack.push(j);
				}
			}
		}
		return res;
	}
}
