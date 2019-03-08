package com.moonspirit.leetcode.p0104;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem0104
 * @Description    [Leetcode 0104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) 二叉树
 * @author         moonspirit
 * @date           2019年3月8日 下午12:08:31
 * @version        1.0.0
 */
public class Problem0104 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0104/Problem0104.txt"), "UTF-8");
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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class SolutionA {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}
}

class SolutionB {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		int count = 1; // 当前层节点数
		int depth = 0; // 树最大深度
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			count--;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			if (count == 0) {
				depth++;
				count = queue.size();
			}
		}
		return depth;
	}
}
