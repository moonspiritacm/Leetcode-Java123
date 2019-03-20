package com.moonspirit.leetcode.p0026;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0026
 * @Description    [Leetcode 0026](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) 有序数组剔除重复元素
 * @author         moonspirit
 * @date           2019年3月20日 下午3:39:42
 * @version        1.0.0
 */
public class Problem0026 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0026/Problem0026.txt"), "UTF-8");
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
		if (nums == null || nums.length == 0)
			return 0;

		int pos = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[pos] != nums[i]) {
				pos++;
				nums[pos] = nums[i];
			}
		}
		return pos + 1;
	}
}
