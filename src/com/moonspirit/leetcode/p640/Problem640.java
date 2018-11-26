package com.moonspirit.leetcode.p640;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem640
 * @Description    [Leetcode 640](https://leetcode-cn.com/problems/solve-the-equation/description/) 字符串处理
 * @author         moonspirit*
 * @date           2018年11月25日 下午4:21:32
 * @version        1.0.0
 */
public class Problem640 {
	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p640/Problem640.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.solveEquation(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 640](https://leetcode-cn.com/problems/solve-the-equation/description/) 字符串处理——朴素遍历
 * @author         moonspirit
 * @date           2018年11月25日 下午4:17:17
 * @version        1.0.0
 */
class Solution {
	/**
	 * @MethodName       solveEquation
	 * @Description      字符串处理，遍历提取并计算系数，一趟扫描，复杂度 O(n)。
	 * 					 1. (+/-)num(x) 为一个计算单元，检测到 x 或者不与 x 紧邻的数字即结束此单元
	 *                   2. 多位数字的处理
	 *                   3. 等号两边需要变号
	 * @param 	         equation 待求解方程
	 * @return           String 计算结果
	 */
	public String solveEquation(String equation) {
		char[] array = equation.toCharArray();
		int preX = 0; // x系数
		int preNum = 0; // 常系数
		int flag = 1; // 左右等式
		int sign = 1; // 正负号
		int num = 1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == '-') {
				sign = -1;
				continue;
			}
			if (array[i] == '+') {
				sign = 1;
				continue;
			}
			if (array[i] == '=') {
				flag = -1;
				continue;
			}
			if (Character.isDigit(array[i])) {
				num = 0;
				while (i < array.length && Character.isDigit(array[i])) {
					num = num * 10 + (int) (array[i++] - '0');
				}
				i--;
			}

			// 判断结束
			if (i + 1 < array.length && array[i + 1] == 'x') {
				continue;
			}

			if (array[i] == 'x') {
				preX += sign * num * flag;
			} else {
				preNum += sign * num * flag;
			}
			sign = 1;
			num = 1;
		}

		if (preX == 0) {
			if (preNum == 0) {
				return "Infinite solutions";
			}
			if (preNum != 0) {
				return "No solution";
			}
		}
		return "x=" + (-preNum / preX);
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 640](https://leetcode-cn.com/problems/solve-the-equation/description/) 字符串处理——正则表达式
 * @author         moonspirit
 * @date           2018年11月25日 下午4:17:17
 * @version        1.0.0
 */
class SolutionExp {
	/**
	 * @MethodName       solveEquation
	 * @Description      字符串处理，正则表达式提取系数，效率较低。
	 * @param 	         equation 待求解方程
	 * @return           String 计算结果
	 */
	public String solveEquation(String equation) {
		int[] res = evaluateExpression(equation.split("=")[0]);
		int[] res2 = evaluateExpression(equation.split("=")[1]);
		res[0] -= res2[0];
		res[1] = res2[1] - res[1];
		if (res[0] == 0 && res[1] == 0)
			return "Infinite solutions";
		if (res[0] == 0)
			return "No solution";
		return "x=" + res[1] / res[0];
	}

	/**
	 * @MethodName       evaluateExpression
	 * @Description      正则表达式提取系数
	 * @param            exp 左/右等式
	 * @return           int[] 0:x系数  1:常系数
	 */
	public int[] evaluateExpression(String exp) {
		String[] tokens = exp.split("(?=[-+])");
		int[] res = new int[2];
		for (String token : tokens) {
			if (token.equals("+x") || token.equals("x"))
				res[0] += 1;
			else if (token.equals("-x"))
				res[0] -= 1;
			else if (token.contains("x"))
				res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
			else
				res[1] += Integer.parseInt(token);
		}
		return res;
	}
}
