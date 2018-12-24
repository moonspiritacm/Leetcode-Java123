package com.moonspirit.leetcode.p934;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem934 {
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

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p934/Problem934.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.shortestBridge(stringToInt2dArray(in.next())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	private int[][] graph;

	private void bfs() {
		Queue<List<Integer>> queue = new LinkedList<>();
		int row = graph.length;
		int col = graph[0].length;
		boolean flag = true;

		for (int i = 0; flag && i < row; i++)
			for (int j = 0; flag && j < col; j++)
				if (graph[i][j] != 0) {
					List<Integer> pos = new ArrayList<>();
					pos.add(i);
					pos.add(j);
					queue.add(pos);
					graph[i][j] = -1;
					flag = false;
				}

		while (!queue.isEmpty()) {
			List<Integer> pos = queue.remove();
			int x = pos.get(0);
			int y = pos.get(1);
			if (0 <= x - 1 && graph[x - 1][y] == 1) {
				List<Integer> next = new ArrayList<>();
				next.add(x - 1);
				next.add(y);
				queue.add(next);
				graph[x - 1][y] = -1;
			}
			if (0 <= y - 1 && graph[x][y - 1] == 1) {
				List<Integer> next = new ArrayList<>();
				next.add(x);
				next.add(y - 1);
				queue.add(next);
				graph[x][y - 1] = -1;
			}
			if (x + 1 < row && graph[x + 1][y] == 1) {
				List<Integer> next = new ArrayList<>();
				next.add(x + 1);
				next.add(y);
				queue.add(next);
				graph[x + 1][y] = -1;
			}
			if (y + 1 < col && graph[x][y + 1] == 1) {
				List<Integer> next = new ArrayList<>();
				next.add(x);
				next.add(y + 1);
				queue.add(next);
				graph[x][y + 1] = -1;
			}
		}
	}

	public int shortestBridge(int[][] A) {
		graph = A;
		bfs();
		return 0;
	}
}
