package com.moonspirit.leetcode.p056;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem001
 * @Description    [Leetcode 001](https://leetcode.com/problems/two-sum/) 数据结构——映射/哈希表
 * @author         moonspirit
 * @date           2019年1月10日 上午1:30:13
 * @version        1.0.0
 */
public class Problem056 {
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

	public static String integerArrayToString(int[] input) {
		if (input.length == 0)
			return "[]";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++)
			sb.append(input[i]).append(", ");
		return "[" + sb.substring(0, sb.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p001/Problem001.txt"), "UTF-8");
		SolutionB solution = new SolutionB();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			int[] nums = stringToIntegerArray(in.nextLine());
			int target = Integer.parseInt(in.nextLine());
			System.out.println(integerArrayToString(solution.twoSum(nums, target)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class Solution {
	private void sort(int[] a, int i, int j) {
		if(l >= h)
			return;
		
		int key = a[l];
		while(h--) {
			while(a[j--] < key) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
	}
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start > intervals.get(i-1)) {
                res.add(new Interval())
            }
        }
        
    }
    com.moonspirit.leetcode.p001
}