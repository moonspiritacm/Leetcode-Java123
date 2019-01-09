package com.moonspirit.leetcode.p001;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName      Problem001
 * @Description    [Leetcode 001](https://leetcode.com/problems/two-sum/) 数据结构——映射
 * @author         moonspirit
 * @date           2019年1月10日 上午1:30:13
 * @version        1.0.0
 */
public class Problem001 {
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

/**
 * @ClassName      SolutionA
 * @Description    暴力求解，时间复杂度 O(n)。
 * @author         moonspirit
 * @date           2019年1月10日 上午1:04:58
 * @version        1.0.0
 */
class SolutionA {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    使用映射集合记录索引与数值的对应关系，实现在 O(1) 时间内通过数值查找索引，总的时间复杂度 O(n)。
 * 				   Java 三类集合：列表（有序）、集（去重无序）、映射（键值一一对应）
 * @author         moonspirit
 * @date           2019年1月10日 上午1:16:08
 * @version        1.0.0
 */
class SolutionB {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i)
				return new int[] { i, map.get(target - nums[i]) };
		}
		return null;
	}
}

/**
 * @ClassName      SolutionB1
 * @Description    两趟遍历改进为一趟遍历，一边填充 Map 一边搜索结果，相当于前向搜索，渐进时间复杂度仍为 O(n)。
 * @author         moonspirit
 * @date           2019年1月10日 上午1:27:41
 * @version        1.0.0
 */
class SolutionB1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i)
				return new int[] { map.get(target - nums[i]), i };
			map.put(nums[i], i);
		}
		return null;
	}
}
