package com.moonspirit.leetcode.p557;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_43 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p43/Problem_43.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String n1 = in.next();
			String n2 = in.next();
			in.nextLine();
			System.out.println(solution.multiply(n1, n2));
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
	public String multiply(String num1, String num2) {
		StringBuilder n1 = new StringBuilder(num1).reverse();
		StringBuilder n2 = new StringBuilder(num2).reverse();
		StringBuilder res = new StringBuilder();
		int len1 = n1.length();
		int len2 = n2.length();
		int len = len1 < len2 ? len1 : len2;
		int s = 0;
		int i = 0;
		while (i < len) {
			int sum = (n1.charAt(i) - '0') * (n2.charAt(i) - '0') + s;
			s = sum / 10;
			sum = sum % 10;
			res.append((char) sum + '0');
			i++;
		}
		res.append((char) s + '0');
		if (len1 < len2) {
			res.append(n1.substring());
		}

	}
}
