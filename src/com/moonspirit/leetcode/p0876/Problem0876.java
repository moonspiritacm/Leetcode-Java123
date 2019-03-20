package com.moonspirit.leetcode.p0876;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0876
 * @Description    [Leetcode 0876](https://leetcode.com/problems/middle-of-the-linked-list/) 定位链表中间节点 快慢指针
 * @author         moonspirit
 * @date           2019年3月20日 下午3:20:22
 * @version        1.0.0
 */
public class Problem0876 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0876/Problem0876.txt"), "UTF-8");
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
	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (fast == null || fast.next == null)
				return slow;
			fast = fast.next.next;
			slow = slow.next;
		}
	}
}
