package com.moonspirit.leetcode.p092;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem092
 * @Description    [Leetcode 092](https://leetcode.com/problems/reverse-linked-list-ii/) 链表
 * @author         moonspirit
 * @date           2019年2月28日 下午10:00:57
 * @version        1.0.0
 */
public class Problem092 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p092/Problem092.txt"), "UTF-8");
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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;

		int i = 1;
		ListNode dummyRoot = new ListNode(-1);
		dummyRoot.next = head;
		ListNode pre = dummyRoot;
		ListNode curr = head;
		while (i < m) {
			i++;
			pre = curr;
			curr = curr.next;
		}
		ListNode start = pre;
		ListNode end = curr;
		while (i <= n) {
			i++;
			ListNode tmp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = tmp;
		}
		start.next = pre;
		end.next = curr;
		return dummyRoot.next;
	}
}
