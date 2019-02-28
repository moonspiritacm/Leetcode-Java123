package com.moonspirit.leetcode.p206;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem206
 * @Description    [Leetcode 206](https://leetcode.com/problems/reverse-linked-list/) 链表
 * @author         moonspirit
 * @date           2019年2月28日 下午10:00:57
 * @version        1.0.0
 */
public class Problem206 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p206/Problem206.txt"), "UTF-8");
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
	}
}

class SolutionA {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		return pre;
	}
}

class SolutionB {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode node = reverseList(head.next);
		head.next.next = head;
		head = null;
		return node;
	}
}
