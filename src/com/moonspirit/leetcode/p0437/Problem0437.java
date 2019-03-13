package com.moonspirit.leetcode.p0437;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem0437
 * @Description    [Leetcode 0437](https://leetcode.com/problems/path-sum-iii/) 二叉树路径和 深度优先搜索 记忆化递归
 * @author         moonspirit
 * @date           2019年3月13日 下午6:08:07
 * @version        1.0.0
 */
public class Problem0437 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0437/Problem0437.txt"), "UTF-8");
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
 * @ClassName      SolutionA
 * @Description    以每个节点作为路径根节点进行前序遍历，判断各路径之和与目标值是否相等
 * @author         moonspirit
 * @date           2019年3月13日 下午6:13:20
 * @version        1.0.0
 */
class SolutionA {
	private int dfs(TreeNode root, int sum) {
		if (root == null)
			return 0;

		if (root.val == sum)
			return 1 + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
		else
			return 0 + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
	}

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;

		return pathSum(root.left, sum) + pathSum(root.right, sum) + dfs(root, sum);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    递归计算以当前节点为路径末尾，且路径和与目标值相等的路径数，使用哈希表存储当前路径中所有可能和的频率。
 * @author         moonspirit
 * @date           2019年3月13日 下午6:38:20
 * @version        1.0.0
 */
class SolutionB {
	private int res = 0;
	private Map<Integer, Integer> map = new HashMap<>();

	private void dfs(TreeNode root, int sum, int target) {
		if (root == null)
			return;

		sum += root.val;
		res += map.getOrDefault(sum - target, 0);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		dfs(root.left, sum, target);
		dfs(root.right, sum, target);
		map.put(sum, map.get(sum) - 1);
	}

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;

		map.put(0, 1);
		dfs(root, 0, sum);
		return res;
	}
}
