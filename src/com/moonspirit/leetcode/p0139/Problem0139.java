package com.moonspirit.leetcode.p0139;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0139
 * @Description    [Leetcode 0139](https://leetcode.com/problems/word-break/) 动态规划
 * @author         moonspirit
 * @date           2019年3月7日 上午10:32:35
 * @version        1.0.0
 */
public class Problem0139 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0139/Problem0139.txt"), "UTF-8");
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
 * @Description    记忆化递归
 * @author         moonspirit
 * @date           2019年3月7日 上午10:34:15
 * @version        1.0.0
 */
class SolutionA {
	private int[] dp;

	private boolean helper(String s, Set<String> dict) {
		if (dp[s.length()] == 1)
			return true;
		if (dp[s.length()] == -1)
			return false;
		if (dict.contains(s)) {
			dp[s.length()] = 1;
			return true;
		}

		for (int i = 1; i < s.length(); i++) {
			if (helper(s.substring(0, i), dict) && dict.contains(s.substring(i))) {
				dp[s.length()] = 1;
				return true;
			}
		}
		dp[s.length()] = -1;
		return false;
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return true;

		dp = new int[s.length() + 1];
		Set<String> dict = new HashSet<>();
		for (String word : wordDict)
			dict.add(word);

		return helper(s, dict);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    动态规划
 * @author         moonspirit
 * @date           2019年3月7日 上午10:55:05
 * @version        1.0.0
 */
class SolutionB {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return true;

		boolean[] dp = new boolean[s.length() + 1];
		Set<String> dict = new HashSet<>();
		for (String word : wordDict)
			dict.add(word);

		dp[0] = true;
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
