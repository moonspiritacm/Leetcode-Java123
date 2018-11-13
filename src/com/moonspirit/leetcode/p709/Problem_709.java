package com.moonspirit.leetcode.p709;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem_709
 * @Description    一层循环，时间复杂度 O(n)，暂无优化方法
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:50:45
 * @version        1.0.0
 */
public class Problem_709 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p709/Problem_709.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.toLowerCase(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    借助标准库方法
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:51:05
 * @version        1.0.0
 */
class Solution {
	public String toLowerCase(String str) {
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (!Character.isLowerCase(s[i])) {
				s[i] = Character.toLowerCase(s[i]);
			}
		}
		return new String(s);
	}
}

/**
 * @ClassName      Solution1
 * @Description    Java char 采用 UTF-16 编码，低位兼容 ASCII，小写 = 大写 + 32
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:56:38
 * @version        1.0.0
 */
class Solution1 {
	public String toLowerCase(String str) {
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			// 65~90 97~122
			if (65 <= s[i] && s[i] <= 90) {
				s[i] = (char) (s[i] + 32);
			}
		}
		return new String(s);
	}
}
