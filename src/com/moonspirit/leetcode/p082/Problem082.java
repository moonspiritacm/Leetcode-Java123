package com.moonspirit.leetcode.p082;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem082
 * @Description    [Leetcode 082](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) 数据结构——链表
 * @author         moonspirit
 * @date           2019年1月4日 上午10:25:37
 * @version        1.0.0
 */
public class Problem082 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p082/Problem082.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(listNodeToString(solution.deleteDuplicates(stringToListNode(in.nextLine()))));
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

class SolutionA {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummyRoot = new ListNode(0);
		ListNode pre = dummyRoot;
		ListNode cur = head;
		boolean dup = false;
		dummyRoot.next = head;
		head = head.next;

		while (head != null) {
			if (cur.val == head.val) {
				dup = true;
			} else {
				if (dup) {
					dup = false;
					cur = head;
				} else {
					pre.next = cur;
					pre = cur;
					cur = head;
				}
			}
			head = head.next;
		}
		if (!dup)
			pre.next = cur;
		else
			pre.next = null;
		return dummyRoot.next;
	}
}

class SolutionB {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummyRoot = new ListNode(0);
		ListNode pre = dummyRoot;
		dummyRoot.next = head;

		while (head != null) {
			while (head.next != null && head.val == head.next.val)
				head = head.next;
			if (pre.next == head)
				pre = pre.next;
			else
				pre.next = head.next;
			head = head.next;
		}
		return dummyRoot.next;
	}
}
