package com.moonspirit.leetcode.p0047;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0047
 * @Description    [Leetcode 0047](https://leetcode.com/problems/permutations-ii/) 深度优先搜索+回溯
 * @author         moonspirit
 * @date           2019年3月6日 下午12:44:29
 * @version        1.0.0
 */
public class Problem0047 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0047/Problem0047.txt"), "UTF-8");
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
 * @Description    排列数，添加约束条件。如果当前的值为重复值，则只要前面的值没有被使用过，则当前值就不可以被使用。这样确保了只有第一个出现的重复值可以算进结果集，后序重复的情况不会被添加进结果集。例如，假设输入的数组为[1，1，2]。则当第一个1被添加进结果集时，可以继续使用第二个1作为元素添加进结果集从而生成112。同理，当试图将第二个1作为第一个元素添加进结果集时，只要第一个1还没有被使用过，则不可以使用第二个1。因此，112不会被重复的添加进结果集。
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
			if (visited[i])
				continue;
			if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
				continue;
			visited[i] = true;
			ans.add(nums[i]);
			helper(nums, d + 1);
			ans.remove(ans.size() - 1);
			visited[i] = false;
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		visited = new boolean[nums.length];
		Arrays.sort(nums);
		helper(nums, 0);
		return res;
	}
}
