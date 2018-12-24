package com.moonspirit.leetcode.p200;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem200 {
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

	public static int[][] stringToInt2dArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0][0];

		String[] parts = input.split("],");
		int[][] output = new int[parts.length][];
		for (int i = 0; i < parts.length - 1; i++)
			output[i] = stringToIntegerArray(parts[i] + "]");
		output[parts.length - 1] = stringToIntegerArray(parts[parts.length - 1]);
		return output;
	}

	public static char[][] stringToChar2dArray(String input) {
		int[][] matrix = stringToInt2dArray(input);
		if (matrix == null || matrix.length == 0)
			return new char[0][0];

		int row = matrix.length;
		int col = matrix[0].length;
		char[][] output = new char[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				output[i][j] = (char) (matrix[i][j] + 48);
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p200/Problem200.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.numIslands(stringToChar2dArray(in.next())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class SolutionA {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		Queue<List<Integer>> queue = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		while (true) {
			boolean flag = true;
			for (int i = 0; flag && i < row; i++)
				for (int j = 0; flag && j < col; j++)
					if (grid[i][j] == '1') {
						List<Integer> pos = new ArrayList<>();
						pos.add(i);
						pos.add(j);
						queue.add(pos);
						grid[i][j] = ' ';
						count++;
						flag = false;
					}

			if (flag)
				return count;

			while (!queue.isEmpty()) {
				List<Integer> pos = queue.remove();
				int x = pos.get(0);
				int y = pos.get(1);
				if (0 <= x - 1 && grid[x - 1][y] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x - 1);
					next.add(y);
					queue.add(next);
					grid[x - 1][y] = ' ';
				}
				if (0 <= y - 1 && grid[x][y - 1] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x);
					next.add(y - 1);
					queue.add(next);
					grid[x][y - 1] = ' ';
				}
				if (x + 1 < row && grid[x + 1][y] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x + 1);
					next.add(y);
					queue.add(next);
					grid[x + 1][y] = ' ';
				}
				if (y + 1 < col && grid[x][y + 1] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x);
					next.add(y + 1);
					queue.add(next);
					grid[x][y + 1] = ' ';
				}
			}
		}

	}
}

class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		Stack<List<Integer>> stk = new Stack<>();
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		while (true) {
			boolean flag = true;
			for (int i = 0; flag && i < row; i++)
				for (int j = 0; flag && j < col; j++)
					if (grid[i][j] == '1') {
						List<Integer> pos = new ArrayList<>();
						pos.add(i);
						pos.add(j);
						stk.push(pos);
						grid[i][j] = ' ';
						count++;
						flag = false;
					}

			if (flag)
				return count;

			while (!stk.isEmpty()) {
				List<Integer> pos = stk.pop();
				int x = pos.get(0);
				int y = pos.get(1);
				if (0 <= x - 1 && grid[x - 1][y] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x - 1);
					next.add(y);
					stk.push(next);
					grid[x - 1][y] = ' ';
				}
				if (0 <= y - 1 && grid[x][y - 1] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x);
					next.add(y - 1);
					stk.push(next);
					grid[x][y - 1] = ' ';
				}
				if (x + 1 < row && grid[x + 1][y] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x + 1);
					next.add(y);
					stk.push(next);
					grid[x + 1][y] = ' ';
				}
				if (y + 1 < col && grid[x][y + 1] == '1') {
					List<Integer> next = new ArrayList<>();
					next.add(x);
					next.add(y + 1);
					stk.push(next);
					grid[x][y + 1] = ' ';
				}
			}
		}

	}
}
