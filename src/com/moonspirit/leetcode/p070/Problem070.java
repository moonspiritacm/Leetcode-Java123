package com.moonspirit.leetcode.p070;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem070
 * @Description    [Leetcode 070](https://leetcode.com/problems/climbing-stairs/) 动态规划
 * @author         moonspirit
 * @date           2018年12月13日 上午1:45:28
 * @version        1.0.0
 */
public class Problem070 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p070/Problem070.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.climbStairs(in.nextInt()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    动态规划，dp[i] 表示爬 i 阶楼梯的方案数，初始值 dp[0] = dp[1] = 1，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月13日 上午1:30:59
 * @version        1.0.0
 */
class Solution {
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    动态规划，存储空间优化，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月13日 上午1:30:59
 * @version        1.0.0
 */
class SolutionA1 {
	public int climbStairs(int n) {
		int two = 1;
		int one = 1;
		int curr = 1;

		for (int i = 2; i <= n; i++) {
			curr = two + one;
			two = one;
			one = curr;
		}
		return curr;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    非记忆化递归，子问题求解多次
 * @author         moonspirit
 * @date           2018年12月13日 上午1:41:23
 * @version        1.0.0
 */
class SolutionB {
	public int climbStairs(int n) {
		if (n <= 1)
			return 1;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
}

/**
 * @ClassName      SolutionB1
 * @Description    记忆化递归，即递归版的动态规划
 * @author         moonspirit
 * @date           2018年12月13日 上午1:43:18
 * @version        1.0.0
 */
class SolutionB1 {
	private int[] dp;

	public int climbStairs(int n) {
		dp = new int[n + 1];
		return func(n);
	}

	private int func(int n) {
		if (n <= 1)
			return 1;
		if (dp[n] == 0)
			dp[n] = func(n - 1) + func(n - 2);
		return dp[n];
	}
}
