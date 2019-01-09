package com.moonspirit.leetcode.p051;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem051
 * @Description    [Leetcode 051](https://leetcode.com/problems/n-queens/) 递归搜索 回溯法
 * @author         moonspirit
 * @date           2019年1月9日 下午4:38:42
 * @version        1.0.0
 */
public class Problem051 {
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
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p051/Problem051.txt"), "UTF-8");
		SolutionA1 solution = new SolutionA1();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.solveNQueens(in.nextInt()));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    递归搜索，通过存储棋盘记录当前状态
 * @author         moonspirit
 * @date           2019年1月9日 上午11:20:45
 * @version        1.0.0
 */
class SolutionA {
	private List<List<String>> result;
	private int[][] search;
	private int size;

	private void add(int a, int b, int n) {
		int i, j;
		search[a][b] = -1;
		for (i = 0; i < size; i++) {
			if (search[i][b] == 0) {
				search[i][b] = n;
			}
		}
		for (j = 0; j < size; j++) {
			if (search[a][j] == 0) {
				search[a][j] = n;
			}
		}
		i = a - 1;
		j = b - 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == 0) {
				search[i][j] = n;
			}
			i--;
			j--;
		}
		i = a + 1;
		j = b + 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == 0) {
				search[i][j] = n;
			}
			i++;
			j++;
		}
		i = a + 1;
		j = b - 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == 0) {
				search[i][j] = n;
			}
			i++;
			j--;
		}
		i = a - 1;
		j = b + 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == 0) {
				search[i][j] = n;
			}
			i--;
			j++;
		}
	}

	private void remove(int a, int b, int n) {
		search[a][b] = 0;
		int i, j;
		for (i = 0; i < size; i++) {
			if (search[i][b] == n) {
				search[i][b] = 0;
			}
		}
		for (j = 0; j < size; j++) {
			if (search[a][j] == n) {
				search[a][j] = 0;
			}
		}
		i = a - 1;
		j = b - 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == n) {
				search[i][j] = 0;
			}
			i--;
			j--;
		}
		i = a + 1;
		j = b + 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == n) {
				search[i][j] = 0;
			}
			i++;
			j++;
		}
		i = a + 1;
		j = b - 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == n) {
				search[i][j] = 0;
			}
			i++;
			j--;
		}
		i = a - 1;
		j = b + 1;
		while (0 <= i && i < size && 0 <= j && j < size) {
			if (search[i][j] == n) {
				search[i][j] = 0;
			}
			i--;
			j++;
		}
	}

	private void addSolution() {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; j++) {
				if (search[i][j] == -1) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			res.add(new String(sb));
		}
		result.add(res);
	}

	private void bt(int n) {
		if (n == 0) {
			addSolution();
			return;
		}

		for (int i = size - n; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (search[i][j] == 0) {
					add(i, j, n);
					bt(n - 1);
					remove(i, j, n);
				}
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		result = new ArrayList<>();
		search = new int[n][n];
		size = n;
		bt(n);
		return result;
	}
}

/**
 * @ClassName      SolutionA1
 * @Description    递归搜索，通过存储行列、双对角线记录状态
 * @author         moonspirit
 * @date           2019年1月9日 下午4:27:16
 * @version        1.0.0
 */
class SolutionA1 {
	private List<List<String>> _result;
	private int[] _col;
	private int[] _diag1;
	private int[] _diag2;
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

	private void addSolution() {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < _size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < _size; j++) {
				if (_col[j] == i + 1) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			res.add(new String(sb));
		}
		_result.add(res);
	}

	private void bt(int i) {
		if (i == _size) {
			addSolution();
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

	public List<List<String>> solveNQueens(int n) {
		_result = new ArrayList<>();
		_col = new int[n];
		_diag1 = new int[2 * n - 1];
		_diag2 = new int[2 * n - 1];
		_size = n;
		bt(0);
		return _result;
	}
}
