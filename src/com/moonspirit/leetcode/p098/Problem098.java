package com.moonspirit.leetcode.p098;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem098 {
	/**
	 * @MethodName       stringToTreeNode
	 * @Description      字符串转二叉树
	 * @param            input 待处理字符串格式 [5,1,4,null,null,3,6]
	 * @return           TreeNode 二叉树根节点
	 */
	public static TreeNode stringToTreeNode(String input) {
		// 预处理，去除前后括号及多余空格
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return null;
		}

		// 创建根节点，同时将其加入队列
		String[] parts = input.split(",");
		String tmp = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(tmp));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();

			// 构建左子树
			if (i == parts.length) {
				break;
			}
			tmp = parts[i++].trim();
			if (!tmp.equals("null")) {
				node.left = new TreeNode(Integer.parseInt(tmp));
				queue.add(node.left);
			}

			// 构建右子树
			if (i == parts.length) {
				break;
			}
			tmp = parts[i++].trim();
			if (!tmp.equals("null")) {
				node.right = new TreeNode(Integer.parseInt(tmp));
				queue.add(node.right);
			}
		}
		return root;
	}

	/**
	 * @MethodName       preOrderTraverse1
	 * @Description      二叉树前序遍历的递归实现，打印输出
	 * @param            root 二叉树根节点
	 */
	public static void preOrderTraverse1(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrderTraverse1(root.left);
			preOrderTraverse1(root.right);
		}
	}

	/**
	 * @MethodName       preOrderTraverse2
	 * @Description      二叉树前序遍历的递归实现，返回数组
	 * @param            root 二叉树根节点
	 */
	public static List<Integer> preOrderTraverse2(List<Integer> list, TreeNode root) {
		if (root != null) {
			list.add(root.val);
			list = preOrderTraverse2(list, root.left);
			list = preOrderTraverse2(list, root.right);
		} else {
			return list;
		}
	}

	/**
	 * @MethodName       inOrderTraverse1
	 * @Description      二叉树中序遍历的递归实现，打印输出
	 * @param            root 二叉树根节点
	 */
	public static void inOrderTraverse1(TreeNode root) {
		if (root != null) {
			inOrderTraverse1(root.left);
			System.out.print(root.val + " ");
			inOrderTraverse1(root.right);
		}
	}

	/**
	 * @MethodName       postOrderTraverse1
	 * @Description      二叉树后序遍历的递归实现，打印输出
	 * @param            root 二叉树根节点
	 */
	public static void postOrderTraverse1(TreeNode root) {
		if (root != null) {
			postOrderTraverse1(root.left);
			postOrderTraverse1(root.right);
			System.out.print(root.val + " ");
		}
	}

	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p098/Problem098.txt"), "UTF-8");
		// Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			preOrderTraverse1(stringToTreeNode(str));
			System.out.println();
			inOrderTraverse1(stringToTreeNode(str));
			System.out.println();
			postOrderTraverse1(stringToTreeNode(str));
			System.out.println();
		}
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
