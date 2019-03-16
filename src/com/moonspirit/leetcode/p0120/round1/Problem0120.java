package com.moonspirit.leetcode.p0120.round1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0120
 * @Description    [Leetcode 0120](https://leetcode.com/problems/triangle/) 动态规划
 * @author         moonspirit
 * @date           2019年3月16日 下午3:10:45
 * @version        1.0.0
 */
public class Problem0120 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0120/Problem0120.txt"), "UTF-8");
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
 * @Description    二维动态规划，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]，时间复杂度 O(n^2)，空间复杂度 O(n^2)
 * 				            边界情况 dp[0][0] = triangle[0][0]，dp[i][0] = dp[i-1][0] + triangle[i][0]，dp[i][i] = dp[i-1][i-1] + triangle[i][i]
 * 					     有待空间优化
 * @author         moonspirit
 * @date           2019年3月16日 下午3:17:25
 * @version        1.0.0
 */
class SolutionA {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		int n = triangle.size();
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; j++)
				dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
			dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++)
			min = min < dp[n - 1][j] ? min : dp[n - 1][j];
		return min;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    本轮计算只与上轮计算结果有关，故可以采用滚动数组优化空间复杂度，空间复杂度 O(2*n)
 * @author         moonspirit
 * @date           2019年3月16日 下午3:29:34
 * @version        1.0.0
 */
class SolutionB {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		int n = triangle.size();
		int[][] dp = new int[2][n];
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; j++)
				dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle.get(i).get(j);
			dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle.get(i).get(i);
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++)
			min = min < dp[(n - 1) % 2][j] ? min : dp[(n - 1) % 2][j];
		return min;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    使用原数组存储计算结果，只需要常数个额外空间
 * @author         moonspirit
 * @date           2019年3月16日 下午4:02:27
 * @version        1.0.0
 */
class SolutionC {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		int n = triangle.size();
		for (int i = 1; i < n; i++) {
			triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
			for (int j = 1; j < i; j++)
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
			triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++)
			min = min < triangle.get(n - 1).get(j) ? min : triangle.get(n - 1).get(j);
		return min;
	}
}
