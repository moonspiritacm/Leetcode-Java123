package com.moonspirit.leetcode.p0237;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0237
 * @Description    [Leetcode 0237](https://leetcode.com/problems/delete-node-in-a-linked-list/) 链表
 * @author         moonspirit
 * @date           2019年3月1日 下午5:11:21
 * @version        1.0.0
 */
public class Problem0237 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0237/Problem0237.txt"), "UTF-8");
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
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
