package com.moonspirit.leetcode.p0313;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0313
 * @Description    [Leetcode 0313](https://leetcode.com/problems/super-ugly-number/) 超级丑数 动态规划
 * @author         moonspirit
 * @date           2019年3月11日 下午6:18:38
 * @version        1.0.0
 */
public class Problem0313 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0313/Problem0313.txt"), "UTF-8");
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

class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0)
			return 0;

		int[] ids = new int[primes.length];
		int[] uglys = new int[n];
		uglys[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int pos = -1;
			for (int j = 0; j < primes.length; j++) {
				int tmp = uglys[ids[j]] * primes[j];
				if (tmp < min) {
					min = tmp;
					pos = j;
				} else if (tmp == min) {
					ids[j]++;
				}
			}
			uglys[i] = min;
			ids[pos]++;
		}
		return uglys[n - 1];
	}
}
