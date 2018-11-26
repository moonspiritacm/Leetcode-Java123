package com.moonspirit.leetcode.p824;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem824
 * @Description    [Leetcode 824](https://leetcode-cn.com/problems/goat-latin/description/)
 * @author         moonspirit
 * @date           2018年11月19日 上午10:51:03
 * @version        1.0.0
 */
public class Problem824 {

	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p824/Problem824.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.toGoatLatin(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 824](https://leetcode-cn.com/problems/goat-latin/description/)
 * @author         moonspirit
 * @date           2018年11月19日 上午11:32:38
 * @version        1.0.0
 */
class Solution {
	/**
	 * @MethodName       toGoatLatin
	 * @Description      山羊拉丁文
	 * @param            S 原文
	 * @return           String 译文
	 */
	public String toGoatLatin(String S) {
		if (S == null & S.equals("")) {
			return "";
		}

		StringBuilder res = new StringBuilder("");
		String[] words = S.split(" ");
		int n = words.length;
		for (int i = 0; i < n; i++) {
			char ch = words[i].charAt(0);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				res.append(words[i]);
				int l = i;
				while (l-- > 0) {
					res.append("a");
				}
			} else {
				res.append(words[i].substring(1)).append(ch);
				int l = i;
				while (l-- > 0) {
					res.append("a");
				}
			}
		}
		return new String(res);
	}
}
