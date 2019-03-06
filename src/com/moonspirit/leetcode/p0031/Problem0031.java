package com.moonspirit.leetcode.p0031;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0031
 * @Description    [Leetcode 0031](https://leetcode.com/problems/next-permutation/) 排列数
 * @author         moonspirit
 * @date           2019年3月7日 上午12:58:37
 * @version        1.0.0
 */
public class Problem0031 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0031/Problem0031.txt"), "UTF-8");
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
	public void nextPermutation(int[] nums) {
		if (nums == null && nums.length == 0)
			return;

		int posA = -1;
		int posB = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				posA = i;
				break;
			}
		}
		if (posA >= 0) {
			for (int i = nums.length - 1; i > posA; i--) {
				if (nums[i] > nums[posA]) {
					posB = i;
					break;
				}
			}
			int tmp = nums[posA];
			nums[posA] = nums[posB];
			nums[posB] = tmp;
		}
		int left = posA + 1;
		int right = nums.length - 1;
		while (left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}
}
