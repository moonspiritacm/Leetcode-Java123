package com.moonspirit.leetcode.p022;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem022
 * @Description    [Leetcode 022](https://leetcode.com/problems/generate-parentheses/submissions/) 回溯法
 * @author         moonspirit
 * @date           2019年2月24日 下午7:27:42
 * @version        1.0.0
 */
public class Problem022 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p022/Problem022.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.generateParenthesis(Integer.parseInt(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    递归深度 2n，分支数 2，粗略计算时间复杂度 O(4^n)，精确计算需要用到卡塔兰数，具体为 O(4^n/n^0.5)。剪枝：
 * 						1. 最终序列，左右括号数目相等；
 * 						2. 任意位置，左括号数目不小于右括号数目
 * @author         moonspirit
 * @date           2019年2月24日 下午7:28:39
 * @version        1.0.0
 */
class Solution {
	private void backtrace(List<String> res, StringBuilder sb, int l, int r) {
		if (l == 0 && r == 0) {
			res.add(new String(sb));
			return;
		}

		if (l > 0) {
			sb.append("(");
			backtrace(res, sb, l - 1, r);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (r > l) {
			sb.append(")");
			backtrace(res, sb, l, r - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		backtrace(res, sb, n, n);
		return res;
	}
}
