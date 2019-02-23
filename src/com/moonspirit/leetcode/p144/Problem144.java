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
 * @Description    递归求解，时间复杂度 O(n) = O(1) + O(p) + O(q)，其中 p + q + 1 = n
 * @author         moonspirit
 * @date           2019年2月22日 下午3:51:26
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
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    迭代求解，迭代过程沿左侧分支展开，先自上而下访问左侧分支上的节点，到达末端后转向，自下而上地遍历它们的右子树，时间复杂度 O(n)
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
		while (true) {
			// 根节点不为空时，左侧分支依次入栈
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			// 根节点为空时，转向处理右子树
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.right;
		}
		return res;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    迭代求解，右子节点先入后出，左子节点后入先出，仅适用于前序遍历，栈深度增加，效率降低，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午4:03:28
 * @version        1.0.0
 */
class SolutionC {
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
