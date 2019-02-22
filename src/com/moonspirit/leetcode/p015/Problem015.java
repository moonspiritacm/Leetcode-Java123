package com.moonspirit.leetcode.p015;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return res;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int ptr1 = i + 1;
			int ptr2 = nums.length - 1;
			while (ptr1 < ptr2) {
				if (nums[i] + nums[ptr1] + nums[ptr2] == 0) {
					res.add(new ArrayList<>(Arrays.asList(nums[i], nums[ptr1], nums[ptr2])));
					while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 + 1])
						ptr1++;
					while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 - 1])
						ptr2--;
					ptr1++;
					ptr2--;
				} else if (nums[i] + nums[ptr1] + nums[ptr2] < 0) {
					while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 + 1])
						ptr1++;
					ptr1++;
				} else {
					while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 - 1])
						ptr2--;
					ptr2--;
				}
			}
		}
		return res;
	}
}