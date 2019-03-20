package com.moonspirit.leetcode.p0287;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0287
 * @Description    [Leetcode 0287](https://leetcode.com/problems/find-the-duplicate-number/) 链表成环问题 快慢指针
 * @author         moonspirit
 * @date           2019年3月20日 下午2:46:50
 * @version        1.0.0
 */
public class Problem0287 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0287/Problem0287.txt"), "UTF-8");
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
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int fast = nums[0];
		int slow = nums[0];
		while (true) {
			fast = nums[fast];
			fast = nums[fast];
			slow = nums[slow];
			if (fast == slow)
				break;
		}
		fast = nums[0];
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;
	}
}
