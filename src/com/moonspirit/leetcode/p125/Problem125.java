package com.moonspirit.leetcode.p125;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem125
 * @Description    [Leetcode 125](https://leetcode.com/problems/valid-palindrome/) 首尾指针 字符串
 * @author         moonspirit
 * @date           2019年2月25日 下午8:07:39
 * @version        1.0.0
 */
public class Problem125 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p125/Problem125.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.isPalindrome(in.nextLine()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    首尾指针逐一比对，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月25日 下午8:07:05
 * @version        1.0.0
 */
class Solution {
	public boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;

		char[] input = s.toCharArray();
		int i = 0;
		int j = input.length - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(input[i]))
				i++;
			while (i < j && !Character.isLetterOrDigit(input[j]))
				j--;
			if (Character.toLowerCase(input[i]) == Character.toLowerCase(input[j])) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
