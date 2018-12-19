package com.moonspirit.leetcode.p241;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem241
 * @Description    [Leetcode 241](https://leetcode.com/problems/different-ways-to-add-parentheses/)
 * @author         moonspirit
 * @date           2018年12月8日 下午11:50:15
 * @version        1.0.0
 */
public class Problem241 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p241/Problem241.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.diffWaysToCompute(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public List<Integer> compute(List<Integer> nums, List<Integer> signs, List<Integer> res) {
		if (signs == null || signs.size() == 0)
			return res;

		for (int i = 0; i < signs.size(); i++) {
			case

		}
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		if (input.length() == 0)
			return res;

		List<Integer> nums = new ArrayList<>();
		List<Character> signs = new ArrayList<>();
		char[] words = input.toCharArray();
		for (int i = 0; i < words.length; i++) {
			if (Character.isDigit(words[i])) {
				int num = 0;
				while (i < words.length && Character.isDigit(words[i])) {
					num = num * 10 + (int) (words[i++] - '0');
				}
				i--;
				nums.add(num);
			} else {
				signs.add(words[i]);
			}
		}

		return res;
	}
}
