package com.moonspirit.leetcode;

<<<<<<< HEAD
public class Solution {
	public int JumpFloorII(int target) {
		if (target == 1)
			return 1;

		return 2 * JumpFloorII(target - 1);
=======
/**
 * @ClassName      Solution001
 * @Description    剑指 offer - 二维数组中的查找
 * @author         moonspirit
 * @date           2019年2月26日 上午11:21:42
 * @version        1.0.0
 */
public class Solution001 {
	public boolean Find(int target, int[][] array) {
		if (array == null || array.length == 0)
			return false;

		int i = 0;
		int j = array[0].length - 1;
		while (i < array.length && j >= 0) {
			if (array[i][j] < target) {
				i++;
			} else if (array[i][j] > target) {
				j--;
			} else {
				return true;
			}
		}
		return false;
>>>>>>> refs/remotes/origin/dev
	}
}