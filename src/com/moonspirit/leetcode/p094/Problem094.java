package com.moonspirit.leetcode.p094;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem094
 * @Description    [Leetcode 094](https://leetcode.com/problems/binary-tree-inorder-traversal/) 二叉树——中序遍历
 * @author         moonspirit
 * @date           2019年2月22日 下午5:33:15
 * @version        1.0.0
 */
public class Problem094 {
	/**
	 * @MethodName       stringToTreeNode
	 * @Description      字符串转二叉树
	 * @param            input 待处理字符串 [1,null,2,3]
	 * @return           TreeNode 二叉树根节点
	 */
	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return null;

		String[] parts = input.split(",");
		String val = parts[0].trim();
		TreeNode root = new TreeNode(Integer.parseInt(val));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();

			if (i == parts.length)
				break;
			val = parts[i++].trim();
			if (!val.equals("null")) {
				node.left = new TreeNode(Integer.parseInt(val));
				queue.add(node.left);
			}

			if (i == parts.length)
				break;
			val = parts[i++].trim();
			if (!val.equals("null")) {
				node.right = new TreeNode(Integer.parseInt(val));
				queue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p094/Problem094.txt"), "UTF-8");
		SolutionB solution = new SolutionB();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.inorderTraversal(stringToTreeNode(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      TreeNode
 * @Description    二叉树节点类
 * @author         moonspirit
 * @date           2019年2月22日 下午3:26:00
 * @version        1.0.0
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

/**
 * @ClassName      SolutionA
 * @Description    递归求解，时间复杂度 O(n) = O(1) + O(p) + O(q)，其中 p + q + 1 = n
 * @author         moonspirit
 * @date           2019年2月22日 下午3:51:26
 * @version        1.0.0
 */
class SolutionA {
	private void inOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inOrder(root, res);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    迭代求解，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午4:20:27
 * @version        1.0.0
 */
class SolutionB {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			// 根节点不为空时，左侧分支依次入栈
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			// 根节点为空时，转向处理右子树
			if (stack.isEmpty())
				break;
			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
}
