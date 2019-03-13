package com.moonspirit.leetcode.p0108;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem0108
 * @Description    [Leetcode 0108](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) 平衡二叉搜索树
 * @author         moonspirit
 * @date           2019年3月14日 上午12:27:49
 * @version        1.0.0
 */
public class Problem0108 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0108/Problem0108.txt"), "UTF-8");
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
	private TreeNode helper(int[] nums, int left, int right) {
		if (left > right)
			return null;

		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, left, mid - 1);
		node.right = helper(nums, mid + 1, right);
		return node;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		return helper(nums, 0, nums.length - 1);
	}
}
