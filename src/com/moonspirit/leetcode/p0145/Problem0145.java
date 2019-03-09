package com.moonspirit.leetcode.p0145;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0145
 * @Description    [Leetcode 0145](https://leetcode.com/problems/binary-tree-postorder-traversal/) 二叉树
 * @author         moonspirit
 * @date           2019年3月10日 上午2:00:29
 * @version        1.0.0
 */
public class Problem0145 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0145/Problem0145.txt"), "UTF-8");
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
	private void postOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;

		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();

		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}
}
