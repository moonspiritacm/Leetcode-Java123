package com.moonspirit.leetcode.p127;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.moonspirit.leetcode.utils.Arrays;

public class Problem127 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p127/Problem127.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(
					solution.ladderLength(in.nextLine(), in.nextLine(), Arrays.stringToStringList(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	private boolean isNeighbour(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	private int dijkstra(int[][] graph, int n, int end) {
		int[] distance = new int[n];
		boolean[] find = new boolean[n];

		for (int i = 0; i < n; i++) {
			distance[i] = graph[n - 1][i];
			find[i] = false;
		}
		find[n - 1] = true;

		for (int i = 0; i < n - 1; i++) {
			int min = Integer.MAX_VALUE;
			int pos = n - 1;
			for (int j = 0; j < n - 1; j++) {
				if (!find[j] && distance[j] < min) {
					min = distance[j];
					pos = j;
				}
			}
			if (pos == n - 1)
				return 0;
			if (pos == end)
				break;

			find[pos] = true;
			for (int k = 0; k < n; k++) {
				if (!find[k] && (min + graph[pos][k]) < distance[k]) {
					distance[k] = min + graph[pos][k];
				}
			}
		}
		return distance[end];
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		int n = wordList.size();
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (isNeighbour(wordList.get(i), wordList.get(j)))
					graph[i][j] = graph[j][i] = 1;
				else
					graph[i][j] = graph[j][i] = 10000;
			}
		}

		for (int i = 0; i < n - 1; i++) {
			if (endWord.equals(wordList.get(i)))
				return dijkstra(graph, n, i);
		}
		return 0;
	}
}
