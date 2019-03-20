package com.moonspirit.leetcode.p0328;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0328
 * @Description    [Leetcode 0328](https://leetcode.com/problems/odd-even-linked-list/) 奇偶链表
 * @author         moonspirit
 * @date           2019年3月20日 下午7:43:43
 * @version        1.0.0
 */
public class Problem0328 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0328/Problem0328.txt"), "UTF-8");
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

class Solution {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
