package com.moonspirit.leetcode.p410;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem410 {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0)
			return new int[0];

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p410/Problem410.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			int m = in.nextInt();
			System.out.println(solution.splitArray(stringToIntegerArray(str), m));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	private int[][] dp;

	private void splitSubArray(int index, int m) {
		for (int i = 0; i < index; i++) {
			dp[][]
		}
	}

	public int splitArray(int[] nums, int m) {
		dp = new int[m][nums.length];
		splitSubArray(nums.length, m);
		return 0;
	}
}
