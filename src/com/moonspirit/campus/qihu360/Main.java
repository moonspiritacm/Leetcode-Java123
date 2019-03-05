package com.moonspirit.campus.qihu360;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while(N-- > 0) {
			int n =  in.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < nums.length; i++) {
				in.nextInt();
			}
			int left = 0;
			int right = n - 1;
			while(left <= right) {
				if(nums[left] > nums[right])
			}
		}
		
		// Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		/*
		 * while (in.hasNextLine()) { int[] nums = stringToIntegerArray(in.nextLine());
		 * int target = Integer.parseInt(in.nextLine());
		 * System.out.println(integerArrayToString(solution.twoSum(nums, target))); }
		 */
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class SolutionA {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows < 2)
			return s;

		char[] chs = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < chs.length; j += 2 * (numRows - 1)) {
				sb.append(chs[j]);
				if (i != 0 && i != numRows - 1 && (j + 2 * (numRows - 1 - i)) < chs.length)
					sb.append(chs[j + 2 * (numRows - 1 - i)]);
			}
		}
		return new String(sb);
	}
}

class SolutionB {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows < 2)
			return s;

		int row = 0;
		boolean flag = false;
		char[] chs = s.toCharArray();
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(chs.length, numRows); i++)
			list.add(new StringBuilder());
		for (int i = 0; i < chs.length; i++) {
			list.get(row).append(chs[i]);
			if (row == 0 || row == numRows - 1)
				flag = !flag;
			if (flag)
				row++;
			else
				row--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.min(chs.length, numRows); i++)
			sb.append(list.get(i));
		return new String(sb);
	}
}
