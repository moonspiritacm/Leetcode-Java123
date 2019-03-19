package com.moonspirit.leetcode.p0142;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0142
 * @Description    [Leetcode 0141](https://leetcode.com/problems/linked-list-cycle-ii/) 快慢指针
 * @author         moonspirit
 * @date           2019年3月19日 下午11:21:14
 * @version        1.0.0
 */
public class Problem0142 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0142/Problem0142.txt"), "UTF-8");
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
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				break;
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
