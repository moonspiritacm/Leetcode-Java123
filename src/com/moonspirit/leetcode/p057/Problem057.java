package com.moonspirit.leetcode.p057;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem057
 * @Description    [Leetcode 057](https://leetcode.com/problems/insert-interval/) 线性扫描
 * @author         moonspirit
 * @date           2019年2月25日 下午5:24:41
 * @version        1.0.0
 */
public class Problem057 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p057/Problem057.txt"), "UTF-8");
		// Solution solution = new Solution();

		/*
		 * long begin = System.currentTimeMillis(); while (in.hasNextLine()) { int[]
		 * nums = stringToIntegerArray(in.nextLine()); int target =
		 * Integer.parseInt(in.nextLine());
		 * System.out.println(integerArrayToString(solution.twoSum(nums, target))); }
		 * long end = System.currentTimeMillis(); System.out.println("耗时：" + (end -
		 * begin) + "ms");
		 */

		in.close();
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class Solution {
	public static void qSort(List<Interval> a, int low, int high) {
		int l = low;
		int h = high;
		Interval key = a.get(low);

		while (l < h) {
			while (l < h && a.get(h).start >= key.start)
				h--;
			a.set(l, a.get(h));

			while (l < h && a.get(l).start <= key.start)
				l++;
			a.set(h, a.get(l));
		}
		a.set(h, key);
		if (low < l)
			qSort(a, low, l - 1);
		if (h < high)
			qSort(a, h + 1, high);
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 2)
			return intervals;

		qSort(intervals, 0, intervals.size() - 1);
		List<Interval> res = new ArrayList<>();
		for (Interval interval : intervals) {
			if (res.isEmpty() || interval.start > res.get(res.size() - 1).end) {
				res.add(interval);
			} else {
				res.get(res.size() - 1).end = Math.max(interval.end, res.get(res.size() - 1).end);
			}
		}
		return res;
	}
}
