package com.moonspirit.leetcode.p0049;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem0049
 * @Description    [Leetcode 0049](https://leetcode.com/problems/group-anagrams/) 字母异位词
 * @author         moonspirit
 * @date           2019年3月18日 上午10:41:50
 * @version        1.0.0
 */
public class Problem0049 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p0049/Problem0049.txt"), "UTF-8");
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
 * @ClassName      SolutionA
 * @Description    字符串排序后分组
 * @author         moonspirit
 * @date           2019年3月18日 上午10:45:29
 * @version        1.0.0
 */
class SolutionA {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return res;
		if (strs.length == 1) {
			res.add(new ArrayList<>(Arrays.asList(strs[0])));
			return res;
		}

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String tmp = new String(chs);
			if (!map.containsKey(tmp)) {
				map.put(tmp, new ArrayList<>(Arrays.asList(str)));
			} else {
				map.get(tmp).add(str);
			}
		}
		for (List<String> list : map.values())
			res.add(list);
		return res;
	}
}

/**
 * @ClassName      SolutionB
 * @Description    由于只包含小写字母，字符串逐字符计数后分组
 * @author         moonspirit
 * @date           2019年3月18日 下午3:40:58
 * @version        1.0.0
 */
class SolutionB {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return res;
		if (strs.length == 1) {
			res.add(new ArrayList<>(Arrays.asList(strs[0])));
			return res;
		}

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] count = new int[26];
			char[] chs = str.toCharArray();
			for (char ch : chs)
				count[ch - 'a']++;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++)
				sb.append((char) ('a' + i)).append(count[i]);
			String tmp = sb.toString();
			if (!map.containsKey(tmp)) {
				map.put(tmp, new ArrayList<>(Arrays.asList(str)));
			} else {
				map.get(tmp).add(str);
			}
		}
		for (List<String> list : map.values())
			res.add(list);
		return res;
	}
}
