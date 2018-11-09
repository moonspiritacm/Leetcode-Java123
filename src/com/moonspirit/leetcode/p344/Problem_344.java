package com.moonspirit.leetcode.p344;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem_344 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p344/Problem_344.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.reverseString(str));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    使用类库方法
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午5:56:11
 * @version        1.0.0
 */
class Solution {
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}

/**
 * @ClassName      Solution1
 * @Description    创建新字符串，额外空间花费 n
 *                 1. 逆序遍历，尾部追加 append()/res = res + ch;
 *                 2. 正序遍历，头部插入 insert()/res = ch + res;
 *                 3. 入栈出栈
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午5:14:36
 * @version        1.0.0
 */
class Solution1 {
	public String reverseString(String s) {
		StringBuilder str = new StringBuilder(s);
		StringBuilder res = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			res.append(str.charAt(i));
		}
		return res.toString();
	}
}

/**
 * @ClassName      Solution2
 * @Description    两侧交换，左右逼近，原地逆序
 * 				   1. 借助第三变量交换  char tmp = str[left]; str[left] = str[right]; str[right] = str[left];
 * 				   2. 借助加减运算（容易溢出） A = A + B; B = A - B; A = A - B;
 *                 3. 借助异或运算（效率最高） A = A ^ B; B = A ^ B; A = A ^ B;
 *
 * @author         moonspirit
 * @date           2018年11月9日 下午5:15:34
 * @version        1.0.0
 */
class Solution2 {
	public String reverseString(String s) {
		StringBuilder str = new StringBuilder(s);
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			char tmp = str.charAt(left);
			str.setCharAt(left, str.charAt(right));
			str.setCharAt(right, tmp);
			left++;
			right--;
		}
		return str.toString();
	}
}
