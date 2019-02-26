package com.moonspirit.leetcode.p677;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName      Problem677
 * @Description    [Leetcode 677](https://leetcode.com/problems/map-sum-pairs/) 映射
 * @author         moonspirit
 * @date           2019年2月25日 下午8:07:39
 * @version        1.0.0
 */
public class Problem677 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p677/Problem677.txt"), "UTF-8");
		MapSum obj = new MapSum();

		long begin = System.currentTimeMillis();
		obj.insert("apple", 3);
		obj.insert("app", 2);
		System.out.println(obj.sum("ap"));
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

class MapSum {
	Map<String, Integer> map;

	public MapSum() {
		map = new HashMap<>();
	}

	public void insert(String key, int val) {
		map.put(key, val);
	}

	public int sum(String prefix) {
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		int sum = 0;

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getKey().startsWith(prefix)) {
				sum += entry.getValue();
			}
		}
		return sum;
	}
}
