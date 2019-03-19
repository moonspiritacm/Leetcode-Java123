package com.moonspirit.offer.util;

public class Partition {
	private static int partition(int[] nums, int low, int high) {
		int small = low - 1;
		for (int i = low; i < high; i++) {
			if (nums[i] < nums[high]) {
				small++;
				if (small != i)
					swap(nums, i, small);
			}
		}
		small++;
		swap(nums, small, high);
		return small;
	}

	private static void swap(int[] nums, int a, int b) {
		nums[a] = nums[a] ^ nums[b];
		nums[b] = nums[a] ^ nums[b];
		nums[a] = nums[a] ^ nums[b];
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 7, 3, 8, 9 };
		partition(nums, 0, nums.length - 1);
	}
}
