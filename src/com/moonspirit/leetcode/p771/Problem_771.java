package com.moonspirit.leetcode.p771;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem_771
 * @Description    两层循环，时间复杂度 O(mn)，暂无优化方法
 * 				   1. 字符串处理方式，char[] String StringBuffer StringBuilder
 * 				   2. 遍历方式，手动遍历 or 标准库方法
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:33:10
 * @version        1.0.0
 */
public class Problem_771 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p771/Problem_771.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str1 = in.nextLine();
			String str2 = in.nextLine();
			System.out.println(solution.numJewelsInStones(str1, str2));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    手动两层循环
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:29:36
 * @version        1.0.0
 */
class Solution {
	public int numJewelsInStones(String J, String S) {
		char[] strJ = J.toCharArray();
		char[] strS = S.toCharArray();
		int sum = 0;
		for (int i = 0; i < strJ.length; i++)
			for (int j = 0; j < strS.length; j++) {
				if (strJ[i] == strS[j])
					sum++;
			}
		return sum;
	}
}

/**
 * @ClassName      Solution1
 * @Description    借助 indexOf() 方法
 *
 * @author         moonspirit
 * @date           2018年11月10日 上午1:32:20
 * @version        1.0.0
 */
class Solution1 {
	public int numJewelsInStones(String J, String S) {
		char[] strS = S.toCharArray();
		int sum = 0;
		for (int i = 0; i < strS.length; i++) {
			if (J.indexOf(strS[i]) > -1)
				sum++;
		}
		return sum;
	}
}
