package com.moonspirit.leetcode.p0141;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0141
 * @Description    [Leetcode 0141](https://leetcode.com/problems/linked-list-cycle/) 快慢指针
 * @author         moonspirit
 * @date           2019年3月19日 下午10:50:31
 * @version        1.0.0
 */
public class Problem0141 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0141/Problem0141.txt"), "UTF-8");
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

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (fast == null || fast.next == null)
				return false;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
	}
}
