package com.moonspirit.leetcode.p078;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.moonspirit.leetcode.utils.Arrays;

/**
 * @ClassName      Problem078
 * @Description    [Leetcode 078](https://leetcode.com/problems/subsets/) 回溯法
 * @author         moonspirit
 * @date           2019年2月24日 下午7:27:42
 * @version        1.0.0
 */
public class Problem078 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p078/Problem078.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.subsets(Arrays.stringToIntegerArray(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    递归深度 n，分支数 2，时间复杂度 O(2^n)，无剪枝
 * @author         moonspirit
 * @date           2019年2月24日 下午9:04:17
 * @version        1.0.0
 */
class Solution {
	private void backtrace(List<List<Integer>> res, List<Integer> seq, int[] nums, int depth) {
		if (depth == nums.length) {
			res.add(new ArrayList<>(seq));
			return;
		}

		backtrace(res, seq, nums, depth + 1);
		seq.add(nums[depth]);
		backtrace(res, seq, nums, depth + 1);
		seq.remove(seq.size() - 1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> seq = new ArrayList<>();
		backtrace(res, seq, nums, 0);
		return res;
	}
}
