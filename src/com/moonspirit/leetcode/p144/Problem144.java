package com.moonspirit.leetcode.p144;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem144
 * @Description    [Leetcode 144](https://leetcode.com/problems/binary-tree-preorder-traversal/) 二叉树——前序遍历
 * @author         moonspirit
 * @date           2019年2月22日 下午3:23:00
 * @version        1.0.0
 */
public class Problem144 {

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

			// 左子节点
			if (i == parts.length)
				break;
			val = parts[i++].trim();
			if (!val.equals("null")) {
				node.left = new TreeNode(Integer.parseInt(val));
				queue.add(node.left);
			}

			// 右子节点
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p144/Problem144.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.preorderTraversal(stringToTreeNode(str)));
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
 * @Description    递归求解，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午3:51:26
 * @version        1.0.0
 */
class SolutionA {

	private List<Integer> res;

	private void preOrder(TreeNode root) {
		if (root == null)
			return;
		res.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		preOrder(root);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    迭代求解，时间复杂度 O(n)
 * 				   - Print and push all left nodes into the stack till it hits NULL.
 * 				   - Pop the top element from the stack, and make the root point to its right.
 * 				   - Keep iterating till both the below conditions are met : Stack is empty and Root is NULL.
 * @author         moonspirit
 * @date           2019年2月22日 下午4:20:27
 * @version        1.0.0
 */
class SolutionB {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) { // 根节点不为空时，入栈，处理左子树
				res.add(root.val);
				stack.push(root);
				root = root.left;
			} else { // 根节点为空时，出栈，处理右子树
				root = stack.pop();
				root = root.right;
			}
		}
		return res;
	}
}

/**
 * @ClassName      SolutionB1
 * @Description    迭代求解，先将右子节点入栈，再将左子节点入栈，不具备通用性，栈深度增加，效率降低，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午4:03:28
 * @version        1.0.0
 */
class SolutionB1 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
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
