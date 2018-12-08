package com.moonspirit.leetcode.p021;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem021
 * @Description    [Leetcode 021](https://leetcode.com/problems/merge-two-sorted-lists/) 数据结构——链表
 * @author         moonspirit
 * @date           2018年12月6日 上午11:30:51
 * @version        1.0.0
 */
public class Problem021 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		int[] nodeValues = stringToIntegerArray(input);
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p021/Problem021.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			ListNode l1 = stringToListNode(in.nextLine());
			ListNode l2 = stringToListNode(in.nextLine());
			System.out.println(listNodeToString(solution.mergeTwoLists(l1, l2)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      ListNode
 * @Description    链表类
 * @author         moonspirit
 * @date           2018年12月6日 上午11:21:07
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
 * @Description    迭代解法，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月6日 上午11:11:28
 * @version        1.0.0
 */
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummyRoot = new ListNode(0);
		ListNode tail = dummyRoot;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}

		if (l1 == null)
			tail.next = l2;
		if (l2 == null)
			tail.next = l1;
		return dummyRoot.next;
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    改进迭代解法，通过 flag 记录当前尾部所属原链表，减少 tail.next 修改次数，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月6日 上午11:11:57
 * @version        1.0.0
 */
class SolutionA1 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummyRoot = new ListNode(0);
		ListNode tail = dummyRoot;
		int flag = 0;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				if (flag != 1) {
					tail.next = l1;
					flag = 1;
				}
				l1 = l1.next;
			} else {
				if (flag != 2) {
					tail.next = l2;
					flag = 2;
				}
				l2 = l2.next;
			}
			tail = tail.next;
		}

		if (l1 == null)
			tail.next = l2;
		if (l2 == null)
			tail.next = l1;
		return dummyRoot.next;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    递归解法，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月6日 上午11:10:47
 * @version        1.0.0
 */
class SolutionB {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
