package com.moonspirit.leetcode.p790;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem790
 * @Description    [Leetcode 790](https://leetcode.com/problems/domino-and-tromino-tiling/) 动态规划——计数问题
 * @author         moonspirit
 * @date           2018年12月18日 下午9:19:59
 * @version        1.0.0
 */
public class Problem790 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p790/Problem790.txt"), "UTF-8");
		SolutionA1 solution = new SolutionA1();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			int n = in.nextInt();
			System.out.println(solution.numTilings(n));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    动态规划——计数问题，dp[i][0] 表示 2 × i 区域填充，且第 i 列全部填满，dp[i][1] 表示 2 × i 区域填充，第 i 列 部分填满，时间复杂度 O(n)。
 * @author         moonspirit
 * @date           2018年12月18日 下午9:03:17
 * @version        1.0.0
 */
class Solution {
	public int numTilings(int N) {
		if (N == 1)
			return 1;
		if (N == 2)
			return 2;

		int modNum = 1000000007;
		long[][] dp = new long[N + 1][2];
		dp[0][0] = dp[1][0] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % modNum;
			dp[i][1] = (dp[i - 1][1] + dp[i - 2][0]) % modNum;
		}
		return (int) dp[N][0];
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    动态规划——计数问题，存储空间优化，时间复杂度 O(n)。
 * @author         moonspirit
 * @date           2018年12月18日 下午9:03:17
 * @version        1.0.0
 */
class SolutionA1 {
	public int numTilings(int N) {
		if (N == 1)
			return 1;
		if (N == 2)
			return 2;

		int modNum = 1000000007;
		long[][] dp = new long[2][2];
		dp[0][0] = dp[1][0] = 1;

		for (int i = 2; i <= N; i++) {
			long tmp = (dp[(i - 1) % 2][0] + dp[(i - 2) % 2][0] + 2 * dp[(i - 1) % 2][1]) % modNum;
			dp[i % 2][1] = (dp[(i - 1) % 2][1] + dp[(i - 2) % 2][0]) % modNum;
			dp[i % 2][0] = tmp;
		}
		return (int) dp[N % 2][0];
	}
}
