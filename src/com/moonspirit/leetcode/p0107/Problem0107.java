package com.moonspirit.leetcode.p0107;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName      Problem0107
 * @Description    [Leetcode 0107](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) 二叉树
 * @author         moonspirit
 * @date           2019年3月9日 下午10:19:25
 * @version        1.0.0
 */
public class Problem0107 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0107/Problem0107.txt"), "UTF-8");
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

class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> ans = new ArrayList<>();
			int count = queue.size();
			while (count-- > 0) {
				TreeNode node = queue.remove();
				ans.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(0, ans);
		}
		// Collections.reverse(res);
		return res;
	}
}
