package com.moonspirit.leetcode.p0238;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0238
 * @Description    [Leetcode 0238](https://leetcode.com/problems/product-of-array-except-self/) 数学
 * @author         moonspirit
 * @date           2019年3月1日 下午5:32:05
 * @version        1.0.0
 */
public class Problem0238 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0238/Problem0238.txt"), "UTF-8");
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

class SolutionA {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int zero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				product *= nums[i];
			else
				zero++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (zero == 0)
					nums[i] = product / nums[i];
				else
					nums[i] = 0;
			} else {
				if (zero == 1)
					nums[i] = product;
				else
					nums[i] = 0;
			}
		}
		return nums;
	}
}

class SolutionB {
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 1;
		right[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			left[i] = left[i] * right[i];
		}
		return left;
	}
}

class SolutionC {
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int right = 1;
		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			right *= nums[i + 1];
			left[i] *= right;
		}
		return left;
	}
}
