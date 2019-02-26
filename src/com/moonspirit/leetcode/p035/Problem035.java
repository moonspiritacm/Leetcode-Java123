package com.moonspirit.leetcode.p035;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem035
 * @Description    [Leetcode 035](https://leetcode.com/problems/search-insert-position/) 二分查找
 * @author         moonspirit
 * @date           2019年2月26日 下午3:39:06
 * @version        1.0.0
 */
public class Problem035 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p035/Problem035.txt"), "UTF-8");
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
 * @Description    暴力搜索，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月26日 下午3:16:46
 * @version        1.0.0
 */
class SolutionA {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target)
				return i;
		}
		return nums.length;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    二分查找，时间复杂度 O(logn)，循环终止时，low 位置恰好大于 target，high 位置恰好小于 target，均可能越界。
 * @author         moonspirit
 * @date           2019年2月26日 下午3:34:18
 * @version        1.0.0
 */
class SolutionB {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}
