package com.moonspirit.leetcode.p0429;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem0429
 * @Description    [Leetcode 0429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/) N叉树
 * @author         moonspirit
 * @date           2019年3月9日 下午10:48:30
 * @version        1.0.0
 */
public class Problem0429 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0429/Problem0429.txt"), "UTF-8");
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

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

class SolutionA {
	public List<List<Integer>> levelOrder(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> ans = new ArrayList<>();
			int count = queue.size();
			while (count-- > 0) {
				Node node = queue.remove();
				ans.add(node.val);
				for (Node tNode : node.children) {
					queue.add(tNode);
				}
			}
			res.add(ans);
		}
		return res;
	}
}

class SolutionB {
	private void levelOrder(Node root, int level, List<List<Integer>> res) {
		if (root == null)
			return;

		if (level == res.size())
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		for (Node node : root.children)
			levelOrder(node, level + 1, res);
	}

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		levelOrder(root, 0, res);
		return res;
	}
}
