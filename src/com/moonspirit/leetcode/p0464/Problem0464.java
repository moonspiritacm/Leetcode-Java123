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
 * @Description    1. 压缩状态空间：二人先后在 [1, 2, ……, M] 范围内选数，所有可能为 M！种，即排列数。
 *                                      实际上，序列的顺序不影响胜负结果，考虑在给定序列 S 的基础上开始游戏，S 具体是按照什么顺序选择而形成的无关紧要。
 *                                      因此，将排列数转化为组合数，即所有可能的状态为 2^M 种。
 *                 2. 划分子问题：在特定序列 S 的基础上开始游戏，先手能否赢得比赛。子问题个数 2^M，求解每个子问题的时间复杂度 O(M)，总的时间复杂度 O(M * 2^M)。
 *                 3. 记忆化递归，子问题不再重复求解。
 *                 4. 存储空间优化：使用一个 32 位整数存储当前序列，使用一个字节存储结果（0、-1、+1）。
 *                 5. 博弈策略：下一状态全胜时，当前状态必败；只要下一状态有失败情况，那么当前状态必胜（选择下一状态对手失败的情况）。
 * @author         moonspirit
 * @date           2019年3月8日 上午10:27:02
 * @version        1.0.0
 */
class Solution {
	private byte[] dp;

	private boolean helper(int M, int T, int seq) {
		if (T <= 0)
			return false;
		if (dp[seq] == 1)
			return true;
		if (dp[seq] == -1)
			return false;

		for (int i = 0; i < M; i++) {
			if ((seq & (1 << i)) != 0)
				continue;
			if (!helper(M, T - i - 1, seq | (1 << i))) {
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

		dp = new byte[1 << maxChoosableInteger];
		return helper(maxChoosableInteger, desiredTotal, 0);
	}
}
