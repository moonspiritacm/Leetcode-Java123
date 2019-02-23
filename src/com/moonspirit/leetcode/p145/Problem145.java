package com.moonspirit.leetcode.p145;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName      Problem145
 * @Description    [Leetcode 144](https://leetcode.com/problems/binary-tree-postorder-traversal/) 二叉树——后序遍历
 * @author         moonspirit
 * @date           2019年2月22日 下午5:49:36
 * @version        1.0.0
 */
public class Problem145 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p145/Problem145.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.postorderTraversal(stringToTreeNode(str)));
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
 * @date           2019年2月22日 下午5:50:44
 * @version        1.0.0
 */
class SolutionA {
	private void postOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;

	}
}

/**
 * @ClassName      SolutionB
 * @Description    迭代求解，转化为逆后序遍历的逆序输出，逆后序遍历即先处理右子树再处理左子树的前序遍历过程，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午6:17:00
 * @version        1.0.0
 */
class SolutionB {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> reverse = new Stack<>();
		while (true) {
			// 根节点不为空时，右侧分支依次入栈
			while (root != null) {
				stack.push(root);
				reverse.push(root);
				root = root.right;
			}
			// 根节点为空时，转向处理左子树
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.left;
		}
		while (!reverse.isEmpty()) {
			res.add(reverse.pop().val);
		}
		return res;
	}
}

/**
 * @ClassName      SolutionB1
 * @Description    迭代求解，转化为逆后序遍历的逆序输出，逆后序遍历即先处理右子树再处理左子树的前序遍历过程，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月23日 上午10:42:31
 * @version        1.0.0
 */
class SolutionB1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> reverse = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			reverse.push(root);
			if (root.left != null)
				stack.push(root.left);
			if (root.right != null)
				stack.push(root.right);
		}
		while (!reverse.isEmpty()) {
			res.add(reverse.pop().val);
		}
		return res;
	}
}

/**
 * @ClassName      SolutionC
 * @Description    迭代求解，引入变量记录上次访问节点，右节点为空或已被访问则访问根节点，否则遍历右子树
 * @author         moonspirit
 * @date           2019年2月23日 下午12:02:13
 * @version        1.0.0
 */
class SolutionC {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

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
			} else { // 否则跳过根节点，遍历右子树
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
