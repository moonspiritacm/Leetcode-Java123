package com.moonspirit.leetcode.p592;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem592
 * @Description    [Leetcode 592](https://leetcode-cn.com/problems/fraction-addition-and-subtraction/description/) 字符串处理+最小公倍数
 * @author         *moonspirit*
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
	/**
	 * @MethodName       gcd
	 * @Description      求两数的最大公约数，用于约分
	 * @param            a
	 * @param            b
	 * @return           long 最大公约数
	 */
	public long gcd(long a, long b) {
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	/**
	 * @MethodName       lcm
	 * @Description      求两数的最小公倍数，用于通分
	 * @param            a
	 * @param            b
	 * @return           long 最小公倍数
	 */
	public long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	/**
	 * @MethodName       fractionAddition
	 * @Description      分式加减，时间复杂度 O(nlogn)。
	 * @param            expression 待计算分式
	 * @return           String 计算结果
	 */
	public String fractionAddition(String expression) {
		char[] array = expression.toCharArray();
		List<Integer> signList = new ArrayList<Integer>();
		List<Integer> fenziList = new ArrayList<Integer>();
		List<Integer> fenmuList = new ArrayList<Integer>();
		int num = 0;
		int sign = 1;
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
				fenmuList.add(num);
			} else {
				fenziList.add(num);
				signList.add(sign);
			}
			num = 0;
			sign = 1;
			flag = false;
		}

		long lcm = 1L;
		for (int i = 0; i < fenmuList.size(); i++) {
			if (fenziList.get(i) != 0) {
				lcm = lcm(lcm, fenmuList.get(i));
			}
		}
		long res = 0;
		for (int i = 0; i < fenziList.size(); i++) {
			if (fenziList.get(i) != 0) {
				res += signList.get(i) * fenziList.get(i) * lcm / fenmuList.get(i);
			}
		}
		long gcd = gcd(Math.abs(res), lcm);
		return res / gcd + "/" + lcm / gcd;
	}
}
