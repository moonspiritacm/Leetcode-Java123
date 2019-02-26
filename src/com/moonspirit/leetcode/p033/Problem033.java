package com.moonspirit.leetcode.p033;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem033
 * @Description    [Leetcode 033](https://leetcode.com/problems/search-in-rotated-sorted-array/) 二分查找
 * @author         moonspirit
 * @date           2019年2月26日 下午4:51:26
 * @version        1.0.0
 */
public class Problem033 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p033/Problem033.txt"), "UTF-8");
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
 * @Description    二分查找，时间复杂度 O(logn)，整体无序，局部有序，借助 low mid high 仍然可以二分区间，实现二分查找
 * @author         moonspirit
 * @date           2019年2月26日 下午4:52:30
 * @version        1.0.0
 */
class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[low] == target)
				return low;
			if (nums[high] == target)
				return high;
			if (nums[mid] >= nums[low]) { // 左侧有序
				if (nums[mid] < target) { // 搜索区间只位于右侧
					low = mid + 1;
				} else {
					if (nums[low] < target) { // 搜索区间位于左侧
						high = mid - 1;
					} else { // 搜索区间位于右侧
						low = mid + 1;
					}
				}
			} else { // 右侧有序
				if (nums[mid] > target) { // 搜索区间只位于左侧
					high = mid - 1;
				} else {
					if (nums[high] < target) { // 搜索区间位于左侧
						high = mid - 1;
					} else { // 搜索区间位于右侧
						low = mid + 1;
					}
				}
			}
		}
		return -1;
	}
}
