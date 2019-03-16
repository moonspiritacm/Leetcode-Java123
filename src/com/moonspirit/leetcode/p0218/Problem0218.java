package com.moonspirit.leetcode.p0218;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0218
 * @Description    [Leetcode 0218](https://leetcode.com/problems/the-skyline-problem/) 几何问题 扫描线算法 优先级队列（最大堆）
 * @author         moonspirit
 * @date           2019年3月15日 下午4:36:05
 * @version        1.0.0
 */
public class Problem0218 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0218/Problem0218.txt"), "UTF-8");
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
	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0)
			return new ArrayList<>();

		List<int[]> res = new ArrayList<>();
		return res;
	}
}
