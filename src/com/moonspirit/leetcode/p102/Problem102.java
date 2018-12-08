package com.moonspirit.leetcode.p102;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem102
 * @Description    [Leetcode 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) 数据结构——二叉树
 * @author         moonspirit
 * @date           2018年12月8日 下午4:34:41
 * @version        1.0.0
 */
public class Problem102 {
	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String tmp = parts[0].trim();
		TreeNode root = new TreeNode(Integer.parseInt(tmp));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();

			if (i == parts.length) {
				break;
			}
			tmp = parts[i++].trim();
			if (!tmp.equals("null")) {
				node.left = new TreeNode(Integer.parseInt(tmp));
				queue.add(node.left);
			}

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

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p102/Problem102.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.levelOrder(stringToTreeNode(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      TreeNode
 * @Description    二叉树类
 * @author         moonspirit
 * @date           2018年12月8日 下午6:15:46
 * @version        1.0.0
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * @ClassName      Solution
 * @Description    广度优先搜索，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月8日 下午6:05:42
 * @version        1.0.0
 */
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> curr = new LinkedList<>();
		curr.add(root);
		while (!curr.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			Queue<TreeNode> next = new LinkedList<>();
			while (!curr.isEmpty()) {
				TreeNode node = curr.remove();
				level.add(node.val);
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}
			res.add(level);
			curr = next;
		}
		return res;
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    改进广度优先搜索，当前队列在内层循环结束后替换为新内容，故可以不进行出队直接遍历，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2018年12月8日 下午6:02:34
 * @version        1.0.0
 */
class SolutionA1 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> curr = new LinkedList<>();
		curr.add(root);
		while (!curr.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			Queue<TreeNode> next = new LinkedList<>();
			for (TreeNode node : curr) {
				level.add(node.val);
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}
			res.add(level);
			curr = next;
		}
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    深度优先搜索
 * @author         moonspirit
 * @date           2018年12月8日 下午6:14:57
 * @version        1.0.0
 */
class SolutionB {
	public List<List<Integer>> DFS(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null)
			return list;

		while (list.size() <= level)
			list.add(new ArrayList<>());
		list.get(level).add(root.val);
		list = DFS(list, root.left, level + 1);
		list = DFS(list, root.right, level + 1);
		return list;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		return DFS(res, root, 0);
	}
}
