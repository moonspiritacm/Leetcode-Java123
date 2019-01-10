package com.moonspirit.leetcode.p003;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName      Problem003
 * @Description    [Leetcode 003](https://leetcode.com/problems/longest-substring-without-repeating-characters/) 数据结构——映射/哈希表
 * @author         moonspirit
 * @date           2019年1月10日 上午11:51:32
 * @version        1.0.0
 */
public class Problem003 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p003/Problem003.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String s = in.nextLine();
			System.out.println(solution.lengthOfLongestSubstring(s));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    暴力枚举，时间复杂度 O(n^3)
 * @author         moonspirit
 * @date           2019年1月10日 上午11:49:21
 * @version        1.0.0
 */
class Solution {
	public int lengthOfLongestSubstring(String s) {
		char[] strs = s.toCharArray();
		int res = 0;
		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j <= strs.length; j++) {
				Set<Character> set = new HashSet<>();
				boolean flag = true;
				for (int k = i; k < j && flag; k++) {
					if (set.contains(strs[k]))
						flag = false;
					else
						set.add(strs[k]);
				}
				if (flag)
					res = Math.max(res, j - i);
			}
		}
		return res;
	}
}
