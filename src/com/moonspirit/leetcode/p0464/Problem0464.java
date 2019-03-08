package com.moonspirit.leetcode.p0464;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0464
 * @Description    [Leetcode 0464](https://leetcode.com/problems/can-i-win/) 记忆化递归 状态压缩 博弈论
 * @author         moonspirit
 * @date           2019年3月8日 上午10:58:38
 * @version        1.0.0
 */
public class Problem0464 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0464/Problem0464.txt"), "UTF-8");
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
 * @Description    排列数 O(n!)，组合数 O(2^n)，游戏中选择的先后顺序不影响游戏结果，将排列数转化为组合数，压缩状态空间。
 *                  2^n 个子问题，求解每个子问题的时间复杂度 O(n)，总的时间复杂度 O(n2^n)。
 *                  1. 记忆化递归
 *                  2. 使用一个字节存储结果 0、+1、-1
 *                  3. 使用一个整型存储序列（二进制）
 *                  4. 如果下一个状态有一个是必败的，那么当前状态就是必胜的
 * @author         moonspirit
 * @date           2019年3月8日 上午10:27:02
 * @version        1.0.0
 */
class Solution {
	private byte[] dp;

	private boolean helper(int maxChoosableInteger, int desiredTotal, int seq) {
		if (desiredTotal <= 0)
			return false;
		if (dp[seq] == 1)
			return true;
		if (dp[seq] == -1)
			return false;

		for (int i = 0; i < maxChoosableInteger; i++) {
			if ((seq & (1 << i)) > 0)
				continue;
			if (!helper(maxChoosableInteger, desiredTotal - i - 1, seq | (1 << i))) {
				dp[seq] = 1;
				return true;
			}
		}
		dp[seq] = -1;
		return false;
	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (maxChoosableInteger >= desiredTotal)
			return true;
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
			return false;

		dp = new byte[1 << maxChoosableInteger]; // 2^M 种状态
		return helper(maxChoosableInteger, desiredTotal, 0);
	}
}
