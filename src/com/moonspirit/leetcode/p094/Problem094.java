package com.moonspirit.leetcode.p094;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem094 {
	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();

		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(" ");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (i == parts.length) {
				break;
			}
			item = parts[i++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				queue.add(node.left);
			}
			if (i == parts.length) {
				break;
			}
			item = parts[i++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				queue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p094/Problem094.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			TreeNode root = stringToTreeNode(str);
			List<Integer> list = solution.inorderTraversal(root);
			for (int i : list) {
				System.out.print(i + "　");
			}
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);

		while (!stk.isEmpty()) {
		}

		return list;
	}
}
