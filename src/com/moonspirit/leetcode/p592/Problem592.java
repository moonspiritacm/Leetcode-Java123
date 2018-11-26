package com.moonspirit.leetcode.p592;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem592
 * @Description    [Leetcode 592](https://leetcode-cn.com/problems/fraction-addition-and-subtraction/description/) 字符串处理+最小公倍数
 * @author         moonspirit
 * @date           2018年11月26日 下午4:50:12
 * @version        1.0.0
 */
public class Problem592 {
	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p592/Problem592.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.fractionAddition(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 592](https://leetcode-cn.com/problems/fraction-addition-and-subtraction/description/) 字符串处理+最小公倍数
 * @author         moonspirit
 * @date           2018年11月26日 下午4:58:18
 * @version        1.0.0
 */
class Solution {
	public String fractionAddition(String expression) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		char[] array = expression.toCharArray();
		int num = 0;
		int sign = 1;
		int fenmu = 0;
		int fenzi = 0;
		boolean flag = false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == '-') {
				sign = -1;
				continue;
			}
			if (array[i] == '+') {
				sign = 1;
				continue;
			}
			if (array[i] == '/') {
				flag = !flag;
				continue;
			}
			if (Character.isDigit(array[i])) {
				while (i < array.length && Character.isDigit(array[i])) {
					num = num * 10 + (int) (array[i++] - '0');
				}
				i--;
			}

			if (flag) {
				if (map.containsKey(num)) {

				}
			} else {
				fenzi = sign * num;
			}

		}
		return "";
	}
}
