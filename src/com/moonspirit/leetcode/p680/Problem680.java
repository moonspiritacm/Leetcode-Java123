package com.moonspirit.leetcode.p680;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem680
 * @Description    [Leetcode 680](https://leetcode.com/problems/valid-palindrome-ii/) 首尾指针 字符串
 * @author         moonspirit
 * @date           2019年2月25日 下午8:07:39
 * @version        1.0.0
 */
public class Problem680 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p680/Problem680.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.validPalindrome(in.nextLine()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    由外向内检查，遇到不匹配字符对时，尝试删除左侧或右侧字符，并判断剩余部分是否是回文数
 * @author         moonspirit
 * @date           2019年2月25日 下午8:31:53
 * @version        1.0.0
 */
class Solution {
	private boolean isPalindrome(char[] input, int i, int j) {
		if (i == j)
			return true;

		while (i < j) {
			if (input[i++] != input[j--])
				return false;
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		if (s.length() == 1)
			return true;

		char[] input = s.toCharArray();
		int i = 0;
		int j = input.length - 1;
		while (i < j) {
			if (input[i] == input[j]) {
				i++;
				j--;
			} else {
				return isPalindrome(input, i + 1, j) || isPalindrome(input, i, j - 1);
			}
		}
		return true;
	}
}
