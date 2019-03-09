package com.moonspirit.leetcode.p0144;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem0144
 * @Description    [Leetcode 0144](https://leetcode.com/problems/binary-tree-preorder-traversal/) 二叉树
 * @author         moonspirit
 * @date           2019年3月10日 上午1:21:58
 * @version        1.0.0
 */
public class Problem0144 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0144/Problem0144.txt"), "UTF-8");
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

/**
 * @ClassName      SolutionA
 * @Description    递归
 * @author         moonspirit
 * @date           2019年3月10日 上午2:18:36
 * @version        1.0.0
 */
class SolutionA {
	private void preOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;

		res.add(root.val);
		preOrder(root.left, res);
		preOrder(root.right, res);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    迭代，右子节点先入后出，左子节点后入先出，仅适用于前序遍历，栈深度有所增加
 * @author         moonspirit
 * @date           2019年3月10日 上午2:19:31
 * @version        1.0.0
 */
class SolutionB {
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return res;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    迭代，沿左侧分支展开，自上而下访问左侧分支上的节点，到达末端后转向，自下而上地遍历它们的右子树
 * @author         moonspirit
 * @date           2019年3月10日 上午2:26:17
 * @version        1.0.0
 */
class SolutionC {
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.right;
		}
		return res;
	}
}
