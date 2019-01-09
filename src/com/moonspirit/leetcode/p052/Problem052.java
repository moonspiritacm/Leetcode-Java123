package com.moonspirit.leetcode.p052;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem052
 * @Description    [Leetcode 052](https://leetcode.com/problems/n-queens-ii/) 递归搜索 回溯法
 * @author         moonspirit
 * @date           2019年1月9日 下午4:48:44
 * @version        1.0.0
 */
public class Problem052 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++)
			output[i] = Integer.parseInt(parts[i].trim());
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p052/Problem052.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.totalNQueens(in.nextInt()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      SolutionA
 * @Description    递归搜索，通过存储行列、双对角线记录状态
 * @author         moonspirit
 * @date           2019年1月9日 下午4:27:16
 * @version        1.0.0
 */
class SolutionA {
	private int[] _col;
	private int[] _diag1;
	private int[] _diag2;
	private int _count;
	private int _size;

	private boolean isAvaliable(int i, int j) {
		if (_col[j] == 0 && _diag1[i + j] == 0 && _diag2[i - j + _size - 1] == 0)
			return true;
		else
			return false;
	}

	private void update(int i, int j, int val) {
		_col[j] = val;
		_diag1[i + j] = val;
		_diag2[i - j + _size - 1] = val;
	}

	private void bt(int i) {
		if (i == _size) {
			_count++;
			return;
		}

		for (int j = 0; j < _size; j++) {
			if (isAvaliable(i, j)) {
				update(i, j, i + 1);
				bt(i + 1);
				update(i, j, 0);
			}
		}
	}

	public int totalNQueens(int n) {
		_col = new int[n];
		_diag1 = new int[2 * n - 1];
		_diag2 = new int[2 * n - 1];
		_count = 0;
		_size = n;
		bt(0);
		return _count;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    打表
 * @author         moonspirit
 * @date           2019年1月9日 下午4:46:27
 * @version        1.0.0
 */
class SolutionB {
	public int totalNQueens(int n) {
		int[] res = { 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184 };
		return res[n - 1];
	}
}
