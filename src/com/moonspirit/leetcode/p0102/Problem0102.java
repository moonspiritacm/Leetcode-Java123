package com.moonspirit.leetcode.p0102;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem0102
 * @Description    [Leetcode 0102](https://leetcode.com/problems/binary-tree-level-order-traversal/) 二叉树
 * @author         moonspirit
 * @date           2019年3月9日 下午9:53:22
 * @version        1.0.0
 */
public class Problem0102 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0102/Problem0102.txt"), "UTF-8");
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> ans = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			ans.add(node.val);
			count--;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			if (count == 0) {
				res.add(ans);
				count = queue.size();
				ans = new ArrayList<>();
			}
		}
		return res;
	}
}

class SolutionB {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> ans = new ArrayList<>();
			int count = queue.size();
			while (count-- > 0) {
				TreeNode node = queue.remove();
				ans.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(ans);
		}
		return res;
	}
}

class SolutionC {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> curr = new LinkedList<>();
		curr.add(root);
		while (!curr.isEmpty()) {
			Queue<TreeNode> next = new LinkedList<>();
			List<Integer> ans = new ArrayList<>();
			while (!curr.isEmpty()) {
				TreeNode node = curr.remove();
				ans.add(node.val);
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
			}
			res.add(ans);
			curr = next;
		}
		return res;
	}
}

class SolutionD {
	private void levelOrder(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null)
			return;

		if (res.size() == level)
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		if (root.left != null)
			levelOrder(root.left, level + 1, res);
		if (root.right != null)
			levelOrder(root.right, level + 1, res);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		levelOrder(root, 0, res);
		return res;
	}
}
