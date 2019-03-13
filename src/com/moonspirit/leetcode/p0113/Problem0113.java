package com.moonspirit.leetcode.p0113;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0113
 * @Description    [Leetcode 0113](https://leetcode.com/problems/path-sum-ii/) 二叉树路径和 深度优先搜索
 * @author         moonspirit
 * @date           2019年3月11日 上午1:06:06
 * @version        1.0.0
 */
public class Problem0113 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0113/Problem0113.txt"), "UTF-8");
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
	private List<List<Integer>> res = new ArrayList<>();
	private List<Integer> ans = new ArrayList<>();

	private void dfs(TreeNode root, int sum) {
		if (root == null)
			return;

		if (root.val == sum && root.left == null && root.right == null) {
			ans.add(root.val);
			res.add(new ArrayList<>(ans));
			ans.remove(ans.size() - 1);
			return;
		}
		ans.add(root.val);
		dfs(root.left, sum - root.val);
		dfs(root.right, sum - root.val);
		ans.remove(ans.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return new ArrayList<>();

		dfs(root, sum);
		return res;
	}
}
