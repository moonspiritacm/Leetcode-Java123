package com.moonspirit.leetcode.p300;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem300
 * @Description    [Leetcode 300](https://leetcode.com/problems/longest-increasing-subsequence/) 最长递增子序列
 * @author         ***moonspirit***
 * @date           2018年11月29日 下午4:28:10
 * @version        1.0.0
 */
public class Problem300 {
	/**
	 * @MethodName       stringToIntegerArray
	 * @Description      (预处理)字符串转整型数组
	 * @param            input 传入字符串格式 [1,1,0]
	 * @return           int[] 处理后的整型数组
	 */
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

	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p300/Problem300.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.lengthOfLIS(stringToIntegerArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      SolutionDP
 * @Description    [Leetcode 300](https://leetcode.com/problems/longest-increasing-subsequence/) 最长递增子序列——动态规划 O(n^2)
 * @author         moonspirit
 * @date           2018年11月29日 下午4:48:00
 * @version        1.0.0
 */
class Solution {
	/**
	 * @MethodName       lengthOfLIS
	 * @Description      动态规划，时间复杂度 O(n^2)。lt[i]为以第i个元素结尾的最长递增子序列长度，其结果与前i项都有关。
	 *                   if (nums[i] > nums[j])
	 *                   	lt[i] = MAX (lt[i], lt[j] + 1);
	 * @param            nums 无序整型数组
	 * @return           int 最长递增子序列长度
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
//			System.out.println("");
			return 0;
		}

		int[] lt = new int[nums.length];
//		int[] pre = new int[nums.length]; // 记录前驱，便于最后输出结果序列
		for (int i = 0; i < nums.length; i++) {
			lt[i] = 1;
//			pre[i] = -1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && lt[i] < lt[j] + 1) {
					lt[i] = lt[j] + 1;
//					pre[i] = j;
				}
			}
		}

		int res = 0;
//		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (res < lt[i]) {
				res = lt[i];
//				pos = i;
			}
		}

//		Stack<Integer> stk = new Stack<Integer>();
//		List<Integer> list = new ArrayList<Integer>();
//		while (pos != -1) {
//			stk.push(pos);
//			pos = pre[pos];
//		}
//		while (!stk.isEmpty()) {
//			list.add(nums[stk.pop()]);
//		}
//		System.out.println(list);
		return res;
	}
}

/**
 * @ClassName      SolutionGreedy
 * @Description    [Leetcode 300](https://leetcode.com/problems/longest-increasing-subsequence/) 最长递增子序列——贪心 O(nlogn)
 * @author         moonspirit
 * @date           2018年11月29日 下午4:48:00
 * @version        1.0.0
 */
class SolutionGreedy {
	/**
	 * @MethodName       binSearch
	 * @Description      二分查找
	 * @param            a 待查找的有序数组
	 * @param            len 数组长度
	 * @param            x 查找的目标元素
	 * @return           int 不小于x的最小位置
	 */
	public int binSearch(int[] a, int len, int x) {
		int left = 0, right = len - 1;
		int mid;
		while (left <= right) {
			mid = (right + left) / 2;
			if (a[mid] > x)
				right = mid - 1;
			else if (a[mid] < x)
				left = mid + 1;
			else
				return mid;
		}
		return left;
	}

	/**
	 * @MethodName       lengthOfLIS
	 * @Description      贪心，时间复杂度 O(nlogn)。数组tail[]存储对应长度LIS的最小末尾，tail[i]仅与tail[i-1]有关：
	 *                   if (nums[i] > tail[len - 1])	数组尾部追加，lts++；
	 *                   else	数组内部更新，二分查找，时间复杂度 O(logn)。
	 * @param            nums 无序整型数组
	 * @return           int 最长递增子序列长度
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
//			System.out.println("");
			return 0;
		}

		int[] tail = new int[nums.length];
		int len = 1;
		tail[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > tail[len - 1]) {
				tail[len++] = nums[i];
			} else {
				int pos = binSearch(tail, len, nums[i]);
				tail[pos] = nums[i];
			}
		}

//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = len - 1; i >= 0; i--) {
//			list.add(tail[i]);
//		}
//		System.out.println(list);
		return len;
	}
}
