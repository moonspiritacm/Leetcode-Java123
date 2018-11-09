package com.moonspirit.leetcode.p541;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_541 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p541/Problem_541.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			int k = Integer.parseInt(in.nextLine());
			System.out.println(solution.reverseStr(str, k));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    StringBuilder 操作字符串
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午7:12:00
 * @version        1.0.0
 */
class Solution {
	public String reverseStr(String s, int k) {
		if (s == null || s.length() <= 1)
			return s;
		StringBuilder str = new StringBuilder(s);
		int len = str.length() - 1;
		int left = 0;
		int right = k - 1;
		while (len > left) {
			int l = left;
			int r = right < len ? right : len;
			while (l < r) {
				char tmp = str.charAt(l);
				str.setCharAt(l, str.charAt(r));
				str.setCharAt(r, tmp);
				l++;
				r--;
			}
			left += 2 * k;
			right += 2 * k;
		}
		return str.toString();
	}
}

/**
 * @ClassName      Solution1
 * @Description    char[] 操作字符串，效率高于 StringBuilder
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午7:12:31
 * @version        1.0.0
 */
class Solution1 {
	public String reverseStr(String s, int k) {
		if (s == null || s.length() <= 1)
			return s;
		char[] str = s.toCharArray();
		int len = str.length - 1;
		int left = 0;
		int right = k - 1;
		while (len > left) {
			int l = left;
			int r = right < len ? right : len;
			while (l < r) {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
			left += 2 * k;
			right += 2 * k;
		}
		return new String(str);
	}
}
