package com.moonspirit.leetcode.p14;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_14 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p14/Problem_14.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.longestCommonPrefix(str.split(" ")));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public int binSearch(String[] strs, int l, int r) {
		if (l > r)
			return l - 1;
		int mid = (l + r) >>> 1;
		boolean flag = true;
		for (int i = 0; i < strs.length - 1; i++) {
			if (!strs[i].substring(0, mid).equals(strs[i + 1].substring(0, mid))) {
				flag = false;
				break;
			}
		}
		if (flag)
			return binSearch(strs, mid + 1, r);
		else
			return binSearch(strs, l, mid - 1);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		int minLen = 0x7fffffff;
		for (int i = 0; i < strs.length; i++) {
			minLen = minLen < strs[i].length() ? minLen : strs[i].length();
		}
		if (minLen == 0)
			return "";
		return strs[0].substring(0, binSearch(strs, 0, minLen));
	}
}
