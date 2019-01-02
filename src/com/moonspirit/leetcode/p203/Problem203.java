package com.moonspirit.leetcode.p203;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem203
 * @Description    [Leetcode 203](https://leetcode.com/problems/remove-linked-list-elements/) 数据结构——链表
 * @author         moonspirit
 * @date           2019年1月2日 下午4:15:17
 * @version        1.0.0
 */
public class Problem203 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p203/Problem203.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out
					.println(listNodeToString(solution.removeElements(stringToListNode(in.nextLine()), in.nextInt())));
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
 * @date           2019年1月2日 下午4:19:56
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
 * @Description    时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年1月2日 下午4:20:37
 * @version        1.0.0
 */
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyRoot = new ListNode(0);
		ListNode preNode = dummyRoot;
		dummyRoot.next = head;

		while (head != null) {
			if (head.val == val) {
				preNode.next = head.next;
			} else {
				preNode = head;
			}
			head = preNode.next;
		}
		return dummyRoot.next;
	}
}
