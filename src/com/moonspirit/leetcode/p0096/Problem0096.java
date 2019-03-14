package com.moonspirit.leetcode.p0096;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0096
 * @Description    [Leetcode 0096](https://leetcode.com/problems/unique-binary-search-trees/) 动态规划
 * @author         moonspirit
 * @date           2019年3月15日 上午12:37:54
 * @version        1.0.0
 */
public class Problem0096 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0096/Problem0096.txt"), "UTF-8");
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
 * @Description    固定根节点的种类数 = 左子树种类数 * 右子树种类数
 * @author         moonspirit
 * @date           2019年3月15日 上午12:39:59
 * @version        1.0.0
 */
class Solution {
	public int numTrees(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;

		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++)
			for (int j = 0; j < i; j++)
				dp[i] += dp[j] * dp[i - 1 - j];
		return dp[n];
	}
}
