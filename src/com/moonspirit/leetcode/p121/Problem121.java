package com.moonspirit.leetcode.p121;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      *Problem121
 * @Description    [Leetcode 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/) 买卖股票
 * @author         moonspirit
 * @date           2018年11月30日 下午5:44:31
 * @version        1.0.0
 */
public class Problem121 {
	/**
	 * @MethodName       stringToIntegerArray
	 * @Description      (预处理)字符串转整型数组
	 * @param            input 传入字符串格式 [1,1,0]
	 * @return           int[] 处理后的整型数组
	 */
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p121/Problem121.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.maxProfit(stringToIntegerArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      SolutionBruteForce
 * @Description    暴力搜索，时间复杂度 O(n^2)
 * @author         moonspirit
 * @date           2018年11月30日 下午4:47:02
 * @version        1.0.0
 */
class SolutionBruteForce {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int res = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int profit = 0;
			for (int j = i + 1; j < prices.length; j++) {
				profit = Math.max(profit, prices[j]);
			}
			profit = profit - prices[i];
			res = Math.max(res, profit);
		}
		return res;
	}
}

/**
 * @ClassName      SolutionOnePass
 * @Description    一趟遍历，同时更新和维护最小值和最大差值，时间复杂度 O(n)
 * 				   prices[i] >= min 时，才有机会更新最大收益，保证买入在前，卖出在后
 * @author         moonspirit
 * @date           2018年11月30日 下午5:37:06
 * @version        1.0.0
 */
class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (res < prices[i] - min) {
					res = prices[i] - min;
				}
			}
		}
		return res;
	}
}
