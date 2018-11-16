package com.moonspirit.leetcode.p547;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem547 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	public static int[][] stringToInt2dArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return new int[0][0];
		}

		String[] parts = input.split("],");
		int[][] output = new int[parts.length - 1][];

		for (int i = 0; i < parts.length - 1; i++) {
			output[i] = stringToIntegerArray(parts[i] + "]");
		}
		output[parts.length - 1] = stringToIntegerArray(parts[parts.length - 1]);
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p547/Problem547.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.findCircleNum(stringToInt2dArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public int findCircleNum(int[][] M) {
		int n = M.length;
		if (n == 0) {
			return 0;
		}

		int[] pre = new int[n];
		int count = 0;

		return count;
	}
}
