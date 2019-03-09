package com.moonspirit.leetcode.p0144;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
