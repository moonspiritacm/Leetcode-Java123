package com.moonspirit.leetcode.p046;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName      Problem022
 * @Description    [Leetcode 022](https://leetcode.com/problems/generate-parentheses/submissions/) 回溯法
 * @author         moonspirit
 * @date           2019年2月24日 下午7:27:42
 * @version        1.0.0
 */
public class Problem022 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p022/Problem022.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			System.out.println(solution.generateParenthesis(Integer.parseInt(in.nextLine())));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Solution
 * @Description    递归深度 2n，分支数 2，粗略计算时间复杂度 O(4^n)，精确计算需要用到卡塔兰数，具体为 O(4^n/n^0.5)。剪枝：
 * 						1. 最终序列，左右括号数目相等；
 * 						2. 任意位置，左括号数目不小于右括号数目
 * @author         moonspirit
 * @date           2019年2月24日 下午7:28:39
 * @version        1.0.0
 */
class Solution {
    private void dfs(List<List<Integer>> res, List<Integer> seq, int[] nums, boolean[] visited) {
        if(seq.size() == nums.length) {
            res.add(new ArrayList<>(seq));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                seq.add(nums[i]);
                dfs(res, seq, nums, visited);
                seq.remove(seq.size()-1);
                visited[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, seq, nums, visited);
        return res;
    }
}
