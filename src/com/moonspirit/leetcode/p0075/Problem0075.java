package com.moonspirit.leetcode.p0075;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0075
 * @Description    [Leetcode 0075](https://leetcode.com/problems/sort-colors/) 快速排序
 * @author         moonspirit
 * @date           2019年3月18日 下午4:40:38
 * @version        1.0.0
 */
public class Problem0075 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0075/Problem0075.txt"), "UTF-8");
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
	private void qSort(int[] nums, int low, int high) {
		if (low >= high)
			return;

		int key = nums[low];
		int left = low;
		int right = high;
		while (left < right) {
			while (key <= nums[right] && left < right)
				right--;
			if (left < right)
				nums[left++] = nums[right];
			while (nums[left] <= key && left < right)
				left++;
			if (left < right)
				nums[right--] = nums[left];
		}
		nums[left] = key;
		qSort(nums, low, left - 1);
		qSort(nums, left + 1, high);
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		qSort(nums, 0, nums.length - 1);
	}
}
