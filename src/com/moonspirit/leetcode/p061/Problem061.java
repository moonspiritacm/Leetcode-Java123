package com.moonspirit.leetcode.p061;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem061
 * @Description    [Leetcode 061](https://leetcode.com/problems/rotate-list/) 链表
 * @author         moonspirit
 * @date           2019年2月28日 下午10:00:57
 * @version        1.0.0
 */
public class Problem061 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p061/Problem061.txt"), "UTF-8");
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
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		int n = 1;
		ListNode curr = head;
		while (curr.next != null) {
			n++;
			curr = curr.next;
		}

		curr.next = head;
		curr = head;
		int i = n - k % n - 1;
		while (i > 0) {
			i--;
			curr = curr.next;
		}
		head = curr.next;
		curr.next = null;
		return head;
	}
}
