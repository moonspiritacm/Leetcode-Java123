package com.moonspirit.leetcode.p303;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem303
 * @Description    [Leetcode 303](https://leetcode.com/problems/range-sum-query-immutable/) 动态规划
 * @author         moonspirit
 * @date           2018年12月11日 下午9:27:02
 * @version        1.0.0
 */
public class Problem303 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p303/Problem303.txt"), "UTF-8");

		long begin = System.currentTimeMillis();
		String str = in.nextLine();
		NumArray obj = new NumArray(stringToIntegerArray(str));
		while (in.hasNextLine()) {
			int i = in.nextInt();
			int j = in.nextInt();
			System.out.println(obj.sumRange(i, j));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      NumArray
 * @Description    动态规划，dp[i] 表示前i个元素之和，即 nums[0] + nums[1] + …… + nums[i-1]，特殊地，dp[0] = 0 用于处理边界情况，时间复杂度 O(n+m)
 * @author         moonspirit
 * @date           2018年12月11日 下午9:41:03
 * @version        1.0.0
 */
class NumArray {
	private int[] dp;

	public NumArray(int[] nums) {
		dp = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			dp[i] = dp[i - 1] + nums[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		if (i > j)
			return 0;
		return dp[j + 1] - dp[i];
	}
}