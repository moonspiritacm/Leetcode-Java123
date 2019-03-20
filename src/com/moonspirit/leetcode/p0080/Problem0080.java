package com.moonspirit.leetcode.p0080;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0080
 * @Description    [Leetcode 0080](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) 有序数组剔除重复元素
 * @author         moonspirit
 * @date           2019年3月20日 下午3:59:17
 * @version        1.0.0
 */
public class Problem0080 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0080/Problem0080.txt"), "UTF-8");
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
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length < 3)
			return nums.length;

		int pos = 0;
		int count = 1;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[j - 1]) {
				pos++;
				nums[pos] = nums[j];
				count = 1;
			} else {
				if (count < 2) {
					pos++;
					nums[pos] = nums[j];
					count++;
				}
			}
		}
		return pos + 1;
	}
}
