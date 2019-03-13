package com.moonspirit.leetcode.p0124;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0124
 * @Description    [Leetcode 0124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) 二叉树最大路径和 深度优先搜索
 * @author         moonspirit
 * @date           2019年3月13日 下午8:42:32
 * @version        1.0.0
 */
public class Problem0124 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0124/Problem0124.txt"), "UTF-8");
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

/**
 * @ClassName      Solution
 * @Description    路径由某一节点和其左右分支（可能为空）组成，递归计算从各节点出发的最大路径，同时更新全局最大路径，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年3月13日 下午8:43:47
 * @version        1.0.0
 */
class Solution {
	private int res = Integer.MIN_VALUE;

	private int helper(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int l = Math.max(0, helper(root.left));
		int r = Math.max(0, helper(root.right));
		res = Math.max(res, l + r + root.val);
		return Math.max(l, r) + root.val;
	}

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;

		helper(root);
		return res;
	}
}
