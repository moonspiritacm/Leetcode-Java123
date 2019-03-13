package com.moonspirit.leetcode.p0112;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0112
 * @Description    [Leetcode 0112](https://leetcode.com/problems/path-sum/) 二叉树路径和 深度优先搜索
 * @author         moonspirit
 * @date           2019年3月11日 上午12:46:29
 * @version        1.0.0
 */
public class Problem0112 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0112/Problem0112.txt"), "UTF-8");
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
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.val == sum && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
