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
 * @Description    递归求解，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午5:50:44
 * @version        1.0.0
 */
class SolutionA {
	private List<Integer> res;

	private void postOrder(TreeNode root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		res.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		postOrder(root);
		return res;

	}
}

/**
 * @ClassName      Solution
 * @Description    后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现
 * @author         moonspirit
 * @date           2019年2月22日 下午6:09:42
 * @version        1.0.0
 */
/**
 * @ClassName      Solution
 * @Description    迭代求解，后序遍历是先处理右子树的前序遍历的逆输出，据此可以用栈存储逆后续遍历结果，依次出栈输出，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月22日 下午6:17:00
 * @version        1.0.0
 */
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				output.push(root);
				stack.push(root);
				root = root.right;
			} else {
				root = stack.pop();
				root = root.left;
			}
		}
		while (!output.isEmpty()) {
			res.add(output.pop().val);
		}
		return res;
	}
}
