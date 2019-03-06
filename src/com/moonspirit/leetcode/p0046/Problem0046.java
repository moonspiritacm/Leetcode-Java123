package com.moonspirit.leetcode.p0046;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0046
 * @Description    [Leetcode 0046](https://leetcode.com/problems/permutations/) 深度优先搜索+回溯
 * @author         moonspirit
 * @date           2019年3月6日 下午12:44:29
 * @version        1.0.0
 */
public class Problem0046 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0046/Problem0046.txt"), "UTF-8");
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

/**
 * @ClassName      Solution
 * @Description    排列数，A(m, n) = m * (m-1) * … * (m-n+1) = m!/(m-n)!，顺序不同算作不同结果，引入辅助数组记录已访问元素
 * @author         moonspirit
 * @date           2019年3月6日 下午12:45:53
 * @version        1.0.0
 */
class Solution {
	private List<List<Integer>> res = new ArrayList<>();
	private List<Integer> ans = new ArrayList<>();
	private boolean[] visited;

	private void helper(int[] nums, int d) {
		if (d == nums.length) {
			res.add(new ArrayList<>(ans));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans.add(nums[i]);
				helper(nums, d + 1);
				ans.remove(ans.size() - 1);
				visited[i] = false;
			}
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();

		visited = new boolean[nums.length];
		helper(nums, 0);
		return res;
	}
}
