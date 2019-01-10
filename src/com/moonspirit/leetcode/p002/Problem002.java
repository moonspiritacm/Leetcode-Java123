package com.moonspirit.leetcode.p002;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem002
 * @Description    [Leetcode 002](https://leetcode.com/problems/add-two-numbers/) 模拟加法
 * @author         moonspirit
 * @date           2019年1月10日 上午11:13:00
 * @version        1.0.0
 */
public class Problem002 {
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

	public static ListNode stringToListNode(String input) {
		int[] nodeValues = stringToIntegerArray(input);
		ListNode dummyRoot = new ListNode(0);
		ListNode head = dummyRoot;
		for (int item : nodeValues) {
			head.next = new ListNode(item);
			head = head.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode root) {
		List<Integer> res = new ArrayList<>();
		while (root != null) {
			res.add(root.val);
			root = root.next;
		}
		return res.toString();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p002/Problem002.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			ListNode l1 = stringToListNode(in.nextLine());
			ListNode l2 = stringToListNode(in.nextLine());
			System.out.println(listNodeToString(solution.addTwoNumbers(l1, l2)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      ListNode
 * @Description    链表节点类
 * @author         moonspirit
 * @date           2019年1月10日 上午11:02:00
 * @version        1.0.0
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/**
 * @ClassName      Solution
 * @Description    模拟加法，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年1月10日 上午11:12:26
 * @version        1.0.0
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyRoot = new ListNode(0);
		ListNode head = dummyRoot;
		int val1 = 0;
		int val2 = 0;
		int carry = 0;

		while (l1 != null || l2 != null) {
			if (l1 == null) {
				val1 = 0;
			} else {
				val1 = l1.val;
				l1 = l1.next;
			}
			if (l2 == null) {
				val2 = 0;
			} else {
				val2 = l2.val;
				l2 = l2.next;
			}
			int sum = carry + val1 + val2;
			carry = sum / 10;
			head.next = new ListNode(sum % 10);
			head = head.next;
		}
		if (carry != 0)
			head.next = new ListNode(carry);
		return dummyRoot.next;
	}
}
