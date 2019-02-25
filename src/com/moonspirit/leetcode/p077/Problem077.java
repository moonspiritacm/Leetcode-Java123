package com.moonspirit.leetcode.p077;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem077
 * @Description    [Leetcode 077](https://leetcode.com/problems/combinations/) 深度优先搜索 组合数
 * @author         moonspirit
 * @date           2019年2月24日 下午7:27:42
 * @version        1.0.0
 */
public class Problem077 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p077/Problem077.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.combine(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    组合数问题：从长度为 n 的元素集合中取出 k 个元素，不考虑顺序，一共有 C(n, k) 种取法
 * @author         moonspirit
 * @date           2019年2月25日 上午9:27:44
 * @version        1.0.0
 */
class Solution {
	private void dfs(List<List<Integer>> res, List<Integer> seq, int n, int k, int s) {
		if (seq.size() == k) {
			res.add(new ArrayList<>(seq));
			return;
		}

		for (int i = s; i <= n; i++) {
			seq.add(i);
			dfs(res, seq, n, k, i + 1);
			seq.remove(seq.size() - 1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> seq = new ArrayList<>();
		dfs(res, seq, n, k, 1);
		return res;
	}
}
