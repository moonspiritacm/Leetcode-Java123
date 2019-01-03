package com.moonspirit.leetcode.p082;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem083
 * @Description    [Leetcode 083](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) 数据结构——链表
 * @author         moonspirit
 * @date           2019年1月4日 上午12:44:06
 * @version        1.0.0
 */
public class Problem083 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p083/Problem083.txt"), "UTF-8");
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

/**
 * @ClassName      SolutionA
 * @Description    时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年1月4日 上午12:37:44
 * @version        1.0.0
 */
class SolutionA {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummyRoot = new ListNode(0);
		dummyRoot.next = head;

		while (head != null) {
			if (head.next == null)
				break;
			if (head.next.val == head.val)
				head.next = head.next.next;
			else
				head = head.next;
		}
		return dummyRoot.next;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    递归，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年1月4日 上午12:43:21
 * @version        1.0.0
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummyRoot = new ListNode(0);
        ListNode pre = dummyRoot;
        ListNode cur = head;
        dummyRoot.next = head;
        head = head.next;
        boolean dup = false;
        
        while(head != null) {
            if(cur.val == head.val) {
                dup = true;
                head = head.next;
            }else{
                if(dup){
                    cur = head;
                    head = head.next;
                }else{
                    pre.next = head;
                    pre = cur;
                    cur = head;
                    head = head.next;
                }
                dup = false;
            }
        }
        return dummyRoot.next;
    }
}

