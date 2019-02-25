package com.moonspirit.leetcode.p090;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem090
 * @Description    [Leetcode 090](https://leetcode.com/problems/subsets-ii/) 回溯法
 * @author         moonspirit
 * @date           2019年2月24日 下午7:27:42
 * @version        1.0.0
 */
public class Problem090 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p090/Problem090.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(
					solution.subsetsWithDup(com.moonspirit.leetcode.utils.Arrays.stringToIntegerArray(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    递归深度 n，分支数 2，时间复杂度 O(2^n)，对重复元素剪枝：
 * 						1. 对集合元素排序，保证重复元素相邻
 * 						2. 对添加到序列中的重复元素可以添加，但不能跳过
 * @author         moonspirit
 * @date           2019年2月24日 下午9:04:17
 * @version        1.0.0
 */
class SolutionA {
	private void backtrace(List<List<Integer>> res, List<Integer> seq, int[] nums, int depth, int pre) {
		if (depth == nums.length) {
			res.add(new ArrayList<>(seq));
			return;
		}

		if (nums[depth] != pre)
			backtrace(res, seq, nums, depth + 1, pre);
		seq.add(nums[depth]);
		backtrace(res, seq, nums, depth + 1, nums[depth]);
		seq.remove(seq.size() - 1);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> seq = new ArrayList<>();
		Arrays.sort(nums);
		backtrace(res, seq, nums, 0, Integer.MAX_VALUE);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    对重复元素剪枝，保证在相同递归深度下，重复元素只处理一次
 * @author         moonspirit
 * @date           2019年2月25日 上午12:43:34
 * @version        1.0.0
 */
class SolutionB {
	private void dfs(List<List<Integer>> res, List<Integer> seq, int[] nums, int begin, int len) {
		if (seq.size() == len) {
			res.add(new ArrayList<>(seq));
			return;
		}

		for (int i = begin; i < nums.length; i++) {
			if (i != begin && nums[i] == nums[i - 1])
				continue;
			seq.add(nums[i]);
			dfs(res, seq, nums, i + 1, len);
			seq.remove(seq.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> seq = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length; i++)
			dfs(res, seq, nums, 0, i);
		return res;
	}
}
