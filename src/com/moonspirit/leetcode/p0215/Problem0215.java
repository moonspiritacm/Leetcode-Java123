package com.moonspirit.leetcode.p0215;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem0215
 * @Description    [Leetcode 0215](https://leetcode.com/problems/kth-largest-element-in-an-array/) 堆排序
 * @author         moonspirit
 * @date           2019年3月15日 下午4:50:49
 * @version        1.0.0
 */
public class Problem0215 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0215/Problem0215.txt"), "UTF-8");
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

/**
 * @ClassName      MaxHeap
 * @Description    大顶堆，顶部元素最大，整体维持偏序关系。
 *                 索引 0 不存储元素：i 的左右孩子分别为 2*i、2*i+1，i 的父节点为 i/2；
 *                 索引 0 存储元素：i 的左右孩子分别为 2*i+1、2*i+2，i 的父节点为 (i-1)/2。
 * @author         moonspirit
 * @date           2019年3月15日 下午5:32:48
 * @version        1.0.0
 */
class MaxHeap {
	/**
	 * @MethodName       heapify
	 * @Description      Floyd 建堆算法，自下而上下滤构建，时间复杂度 O(n)
	 * @param            nums 无序数组
	 */
	public static void heapify(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int n = nums.length;
		for (int i = (n - 2) >> 2; i >= 0; i--) {
			shftDown(nums, i);
		}
	}

	private void siftDown(int[] nums, int k) {
		int num = nums[k];
		int child = 1 + k >>> 1;
		while (child < n) {
			if (nums[child] < nums[child + 1])
				child++;
			if (nums[child] < num)
				break;
			else
				nums[k] = nums[child];
			k = child;
		}
	}
}

class Solution {
	public int findKthLargest(int[] nums, int k) {

	}
}
