package com.moonspirit.leetcode.p312;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem312
 * @Description    [Leetcode 312](https://leetcode.com/problems/burst-balloons/) 动态规划
 * @author         moonspirit
 * @date           2018年12月13日 上午1:18:25
 * @version        1.0.0
 */
public class Problem312 {
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

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p312/Problem312.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.maxCoins(stringToIntegerArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    动态规划，dp[i][j] 表示 [i, j] 区间可获得的最大值，k 为 [i, j] 内最后打破的气球，将问题转化为 dp[i][k-1] 与 dp[k+1][j]，时间复杂度 O(n^3)
 * @author         moonspirit
 * @date           2018年12月13日 上午1:14:01
 * @version        1.0.0
 */
class Solution {
	public int maxCoins(int[] nums) {
		int[][] dp = new int[nums.length + 2][nums.length + 2];
		int[] numList = new int[nums.length + 2];
		numList[0] = numList[nums.length + 1] = 1;
		for (int i = 1; i <= nums.length; i++) {
			numList[i] = nums[i - 1];
		}

		for (int l = 1; l <= nums.length; l++)
			for (int i = 1; i <= nums.length - l + 1; i++) {
				int j = i + l - 1;
				dp[i][j] = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					dp[i][j] = Math.max(dp[i][j],
							dp[i][k - 1] + numList[i - 1] * numList[k] * numList[j + 1] + dp[k + 1][j]);
				}
			}
		return dp[1][nums.length];
	}
}
