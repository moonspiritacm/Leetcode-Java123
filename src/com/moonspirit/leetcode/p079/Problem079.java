package com.moonspirit.leetcode.p079;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import com.moonspirit.leetcode.utils.Arrays;

/**
 * @ClassName      Problem079
 * @Description    [Leetcode 079](https://leetcode.com/problems/word-search/) 深度优先搜索 回溯法
 * @author         moonspirit
 * @date           2019年2月23日 下午7:48:26
 * @version        1.0.0
 */
public class Problem079 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p079/Problem079.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str1 = in.nextLine();
			String str2 = in.nextLine();
			System.out.println(solution.exist(Arrays.stringToChar2dArray(str1), str2));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    二维深度优先搜索，递归深度为单词长度 l，已知搜索起点的时间复杂度为 O(4^l)，总的时间复杂度为 O(m*n*4^l)
 * @author         moonspirit
 * @date           2019年2月23日 下午8:36:27
 * @version        1.0.0
 */
class Solution {
	private boolean dfs(char[][] board, char[] chars, int d, int i, int j) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != chars[d])
			return false;
		if (d == chars.length - 1)
			return true;
		char keep = board[i][j];
		board[i][j] = '#';
		boolean res = dfs(board, chars, d + 1, i - 1, j) || dfs(board, chars, d + 1, i + 1, j)
				|| dfs(board, chars, d + 1, i, j - 1) || dfs(board, chars, d + 1, i, j + 1);
		board[i][j] = keep;
		return res;
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return true;
		if (board.length == 0)
			return false;

		int row = board.length;
		int col = board[0].length;
		char[] chars = word.toCharArray();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, chars, 0, i, j))
					return true;
			}
		}
		return false;
	}
}
