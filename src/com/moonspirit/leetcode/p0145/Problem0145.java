package com.moonspirit.leetcode.p0145;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem0145
 * @Description    [Leetcode 0145](https://leetcode.com/problems/binary-tree-postorder-traversal/) 二叉树
 * @author         moonspirit
 * @date           2019年3月10日 上午2:00:29
 * @version        1.0.0
 */
public class Problem0145 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0145/Problem0145.txt"), "UTF-8");
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
	private void postOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;

		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    引入变量记录上次访问节点，右节点为空或已被访问则访问根节点，否则遍历右子树
 * @author         moonspirit
 * @date           2019年3月10日 上午2:55:33
 * @version        1.0.0
 */
class SolutionB {
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			root = stack.peek();
			if (root.right == null || root.right == pre) { // 没有右子树或者右子树已访问时，访问根节点并出栈
				res.add(root.val);
				pre = root;
				stack.pop();
			} else { // 跳过根节点，遍历右子树
				root = root.right;
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
			}
		}
		return res;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    逆后序遍历：先访问根节点，再处理右子树，最后处理左子树
 * @author         moonspirit
 * @date           2019年3月10日 上午2:39:41
 * @version        1.0.0
 */
class SolutionC {
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(0, node.val);
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
		return res;
	}
}
