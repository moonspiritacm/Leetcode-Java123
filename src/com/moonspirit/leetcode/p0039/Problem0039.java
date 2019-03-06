package com.moonspirit.leetcode.p0039;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName      Problem0039
 * @Description    [Leetcode 0039](https://leetcode.com/problems/combination-sum/) 回溯
 * @author         moonspirit
 * @date           2019年3月6日 上午12:49:40
 * @version        1.0.0
 */
public class Problem0039 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0039/Problem0039.txt"), "UTF-8");
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
 * @ClassName      SolutionA
 * @Description    回溯，无剪枝，需要处理重复结果
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:01
 * @version        1.0.0
 */
class SolutionA {
	private Set<List<Integer>> res = new HashSet<>();
	private List<Integer> ans = new ArrayList<>();

	private void helper(int[] candidates, int target) {
		if (target == 0) {
			List<Integer> tmp = new ArrayList<>(ans);
			Collections.sort(tmp);
			res.add(tmp);
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				ans.add(candidates[i]);
				helper(candidates, target - candidates[i]);
				ans.remove(ans.size() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		helper(candidates, target);
		return new ArrayList<>(res);
	}
}

/**
 * @ClassName      SolutionB
 * @Description    回溯，完全剪枝，结果不会重复
 * @author         moonspirit
 * @date           2019年3月5日 上午1:31:20
 * @version        1.0.0
 */
class SolutionB {
	private List<List<Integer>> res = new ArrayList<>();
	private List<Integer> ans = new ArrayList<>();

	private void helper(int[] candidates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(ans));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				ans.add(candidates[i]);
				helper(candidates, target - candidates[i], i);
				ans.remove(ans.size() - 1);
			} else {
				break;
			}
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		helper(candidates, target, 0);
		return res;
	}
}
