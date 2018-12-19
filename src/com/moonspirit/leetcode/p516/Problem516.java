package com.moonspirit.leetcode.p516;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem300
 * @Description    [Leetcode 516](https://leetcode.com/problems/longest-palindromic-subsequence/) 最长回文子序列
 * @author         ***moonspirit***
 * @date           2018年11月29日 下午4:28:10
 * @version        1.0.0
 */
public class Problem516 {
	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p516/Problem516.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.longestPalindromeSubseq(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 516](https://leetcode.com/problems/longest-palindromic-subsequence/) 最长回文子序列——动态规划 O(n^2)
 * @author         moonspirit
 * @date           2018年11月30日 上午11:50:31
 * @version        1.0.0
 */
class Solution {
	/**
	 * @MethodName       longestPalindromeSubseq
	 * @Description      TODO
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] array = s.toCharArray();
		int[] dp = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = i + 1; i < array.length; j++) {
				if (array[i] == array[j]) {
					dp[j]=dp[]
				}
			}
		}

		return 0;
	}
}
