package com.moonspirit.leetcode.p50;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_50 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p50/Problem_50.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			double x = in.nextDouble();
			int n = in.nextInt();
			in.nextLine();
			System.out.println(solution.myPow(x, n));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	public double myPow(double x, int n) {
		boolean flag = true;
		if (n < 0) {
			n = -n;
			flag = false;
		}
		ArrayList<Double> primes = new ArrayList<Double>();
		while (n != 1) {
			if(n%)
		}

		return x;
	}
}
