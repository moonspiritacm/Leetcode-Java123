package com.moonspirit.leetcode.p016;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem015
 * @Description    [Leetcode 015](https://leetcode.com/problems/3sum/)
 * @author         moonspirit
 * @date           2019年1月21日 下午3:34:48
 * @version        1.0.0
 */
public class Problem015 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++)
			output[i] = Integer.parseInt(parts[i].trim());
		return output;
	}

	public static String integerArrayToString(int[] input) {
		if (input.length == 0)
			return "[]";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++)
			sb.append(input[i]).append(", ");
		return "[" + sb.substring(0, sb.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p001/Problem001.txt"), "UTF-8");
		SolutionB solution = new SolutionB();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			int[] nums = stringToIntegerArray(in.nextLine());
			int target = Integer.parseInt(in.nextLine());
			System.out.println(integerArrayToString(solution.twoSum(nums, target)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int sum = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (Math.abs(sum - target) > Math.abs(temp - target)) {
						sum = temp;
					}
				}
			}
		}
		return sum;
	}
}
