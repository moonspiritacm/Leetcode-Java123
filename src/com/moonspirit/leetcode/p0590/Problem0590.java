package com.moonspirit.leetcode.p0590;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem0590
 * @Description    [Leetcode 0590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/) 多叉树
 * @author         moonspirit
 * @date           2019年3月10日 下午4:42:29
 * @version        1.0.0
 */
public class Problem0590 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0590/Problem0590.txt"), "UTF-8");
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
	private void postOrder(Node root, List<Integer> res) {
		if (root == null)
			return;

		for (Node node : root.children)
			postOrder(node, res);
		res.add(root.val);
	}

	public List<Integer> postorder(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}
}

class SolutionB {
	public List<Integer> postorder(Node root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(0, node.val);
			for (Node tNode : node.children)
				stack.push(tNode);
		}
		return res;
	}
}
