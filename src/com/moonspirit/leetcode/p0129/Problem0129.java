package com.moonspirit.leetcode.p0129;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0129
 * @Description    [Leetcode 0129](https://leetcode.com/problems/sum-root-to-leaf-numbers/) 二叉树路径组成的数字之和 深度优先搜索
 * @author         moonspirit
 * @date           2019年3月13日 下午9:07:50
 * @version        1.0.0
 */
public class Problem0129 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0129/Problem0129.txt"), "UTF-8");
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
	private int res = 0;

	private void helper(TreeNode root, int sum) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			res += sum * 10 + root.val;
		helper(root.left, sum * 10 + root.val);
		helper(root.right, sum * 10 + root.val);
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;

		helper(root, 0);
		return res;
	}
}
