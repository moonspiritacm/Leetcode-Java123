package com.moonspirit.leetcode.p0111;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem0111
 * @Description    [Leetcode 0111](https://leetcode.com/problems/minimum-depth-of-binary-tree/) 二叉树
 * @author         moonspirit
 * @date           2019年3月8日 上午11:29:23
 * @version        1.0.0
 */
public class Problem0111 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0111/Problem0111.txt"), "UTF-8");
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
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left == 0)
			return right + 1;
		else if (right == 0)
			return left + 1;
		else
			return (left < right) ? left + 1 : right + 1;
	}
}

class SolutionB {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 1;
		int depth = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			count--;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			if (node.left == null && node.right == null)
				return depth + 1;

			if (count == 0) {
				depth++;
				count = queue.size();
			}
		}
		return depth;
	}
}
