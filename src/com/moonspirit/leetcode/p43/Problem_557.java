package com.moonspirit.leetcode.p43;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_557 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p557/Problem_557.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.reverseWords(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    char[] 操作字符串，效率高于 StringBuilder
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午7:12:31
 * @version        1.0.0
 */
class Solution {
	public void reverse(char[] str, int l, int r) {
		while (l < r) {
			char tmp = str[l];
			str[l] = str[r];
			str[r] = tmp;
			l++;
			r--;
		}
	}

	public String reverseWords(String s) {
		if (s == null || s.length() <= 1)
			return s;
		char[] str = s.toCharArray();
		int len = str.length;
		int left = 0;
		int right = s.indexOf(' ', left);
		while (right != -1) {
			reverse(str, left, right - 1);
			left = right + 1;
			right = s.indexOf(' ', left);
		}
		reverse(str, left, len - 1);
		return new String(str);
	}
}
