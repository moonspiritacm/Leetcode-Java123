package com.moonspirit.leetcode.p0264;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0264
 * @Description    [Leetcode 0264](https://leetcode.com/problems/ugly-number-ii/) 丑数 动态规划
 * @author         moonspirit
 * @date           2019年3月11日 下午5:40:49
 * @version        1.0.0
 */
public class Problem0264 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0264/Problem0264.txt"), "UTF-8");
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
 * @Description    暴力求解，顺序判断丑数，直到找到第 N 个丑数
 * @author         moonspirit
 * @date           2019年3月11日 下午5:58:31
 * @version        1.0.0
 */
class SolutionA {
	private boolean isUgly(int num) {
		if (num <= 0)
			return false;

		while (num % 2 == 0)
			num = num / 2;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		if (num == 1)
			return true;
		else
			return false;
	}

	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;

		int num = 0;
		while (n > 0) {
			num++;
			if (isUgly(num))
				n--;
		}
		return num;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    动态规划，下一丑数 = 某一丑数 * 2/3/5。为保证丑数数组的有序性，每轮循环只选择最小的丑数加入数组，同时更新相应因子位置。
 * @author         moonspirit
 * @date           2019年3月11日 下午5:59:58
 * @version        1.0.0
 */
class SolutionB {
	public int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;

		int[] ids = new int[3];
		int[] uglys = new int[n];
		uglys[0] = 1;
		for (int i = 1; i < n; i++) {
			int a = uglys[ids[0]] * 2;
			int b = uglys[ids[1]] * 3;
			int c = uglys[ids[2]] * 5;
			int min = Math.min(a, Math.min(b, c));
			uglys[i] = min;
			if (min == a)
				ids[0]++;
			if (min == b)
				ids[1]++;
			if (min == c)
				ids[2]++;
		}
		return uglys[n - 1];
	}
}
