package com.moonspirit.leetcode.p0094;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0094
 * @Description    [Leetcode 0094](https://leetcode.com/problems/binary-tree-inorder-traversal/) 二叉树
 * @author         moonspirit
 * @date           2019年3月10日 上午1:29:20
 * @version        1.0.0
 */
public class Problem0094 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0094/Problem0094.txt"), "UTF-8");
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
	private void inOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;

		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		inOrder(root, res);
		return res;
	}
}
