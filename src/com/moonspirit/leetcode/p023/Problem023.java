package com.moonspirit.leetcode.p023;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem023 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return new int[0];
		}

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

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p021/Problem021.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str1 = in.nextLine();
			String str2 = in.nextLine();
			System.out.println(solution.mergeTwoLists(stringToListNode(str1), stringToListNode(str2)));
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

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		ListNode dummyRoot = new ListNode(0);
		ListNode tail = dummyRoot;
		while (true) {
			int max = Integer.MIN_VALUE;
			int maxPos = -1;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null && lists[i].val < max) {
					max = lists[i].val;
					maxPos = i;
				}
			}
			if (maxPos == -1) {
				break;
			}
			tail.next = lists[maxPos];
			tail = tail.next;
			lists[maxPos] = lists[maxPos].next;
		}
		return dummyRoot.next;
	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
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

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];

		int len = (lists.length + 1) / 2;
		ListNode[] mergeLists = new ListNode[len];
		for (int i = 0; i < lists.length / 2; i++) {
			mergeLists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
		}
		if (lists.length % 2 != 0) {
			mergeLists[len - 1] = lists[lists.length - 1];
		}
		mergeKLists(mergeLists);
	}}

Brute Force

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0)
				return null;

			ListNode dummyRoot = new ListNode(0);
			ListNode tail = dummyRoot;
			int flag = -1;
			while (true) {
				int max = Integer.MAX_VALUE;
				int maxPos = -1;
				for (int i = 0; i < lists.length; i++) {
					if (lists[i] != null && lists[i].val < max) {
						max = lists[i].val;
						maxPos = i;
					}
				}
				if (maxPos == -1)
					break;
				if (flag != maxPos) {
					tail.next = lists[maxPos];
					flag = maxPos;
				}
				lists[maxPos] = lists[maxPos].next;
				tail = tail.next;
			}
			return dummyRoot.next;
		}
	}

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0)
				return null;

			ListNode dummyRoot = new ListNode(0);
			ListNode tail = dummyRoot;
			while (true) {
				int max = Integer.MAX_VALUE;
				int maxPos = -1;
				for (int i = 0; i < lists.length; i++) {
					if (lists[i] != null && lists[i].val < max) {
						max = lists[i].val;
						maxPos = i;
					}
				}
				if (maxPos == -1)
					break;
				tail.next = lists[maxPos];
				lists[maxPos] = lists[maxPos].next;
				tail = tail.next;
			}
			return dummyRoot.next;
		}
}