package com.moonspirit.leetcode.p547;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName      Problem547
 * @Description    [Leetcode 547](https://leetcode-cn.com/problems/friend-circles/description/)
 * @author         moonspirit
 * @date           2018年11月19日 上午10:51:03
 * @version        1.0.0
 */
public class Problem547 {
	/**
	 * @MethodName       stringToIntegerArray
	 * @Description      输入处理：字符串转整型数组
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
	 * @MethodName       stringToInt2dArray
	 * @Description      输入处理：字符串转二维整型数组
	 * @param            input 传入字符串格式 [[1,1,0],[1,1,1],[0,1,1]]
	 * @return           int[] 处理后的二维整型数组
	 */
	public static int[][] stringToInt2dArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1).trim();
		if (input.length() == 0) {
			return new int[0][0];
		}

		String[] parts = input.split("],");
		int[][] output = new int[parts.length][];
		for (int i = 0; i < parts.length - 1; i++) {
			output[i] = stringToIntegerArray(parts[i] + "]");
		}
		output[parts.length - 1] = stringToIntegerArray(parts[parts.length - 1]);
		return output;
	}

	/**
	 * @MethodName       main
	 * @Description      主函数
	 * @param            args
	 * @throws           IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p547/Problem547.txt"), "UTF-8");
		Solution solution = new Solution();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.findCircleNum(stringToInt2dArray(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      UnionFind
 * @Description    并查集：路径压缩
 * @author         moonspirit
 * @date           2018年11月19日 上午11:16:08
 * @version        1.0.0
 */
class UnionFind {
	private int size;
	private int count;
	private int[] pre;

	/**
	 * @Description    构造并初始化
	 * @param          n 规模
	 */
	public UnionFind(int n) {
		size = n;
		count = n;
		pre = new int[size];
		for (int i = 0; i < size; i++) {
			pre[i] = i;
		}
	}

	/**
	 * @MethodName       find
	 * @Description      查找祖先：压缩路径（递归版）
	 *                   找到最久远的祖先时把它的子孙直接连接到它上面，可以保证树最多只有两层
	 * @param            x 子孙节点
	 * @return           int 根节点
	 */
	private int find(int x) {
		if (pre[x] == x) {
			return x;
		}
		return pre[x] = find(pre[x]);
	}

	/**
	 * @MethodName       findFather
	 * @Description      查找祖先：压缩路径（迭代版） 效率一般优于递归
	 *                   找到最久远的祖先时把它的子孙直接连接到它上面，可以保证树最多只有两层
	 * @param            x 子孙节点
	 * @return           int 根节点
	 */
	private int findFather(int x) {
		int p = x;
		while (pre[p] != p) {
			p = pre[p];
		}
		while (x != p) {
			int tmp = pre[x];
			pre[x] = p;
			x = tmp;
		}
		return x;
	}

	/**
	 * @MethodName       union
	 * @Description      合并子树
	 * @param            x 子树根节点
	 * @param            y 子树根节点
	 */
	public void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if (fx != fy) {
			pre[fy] = fx;
			count--;
		}
	}

	/**
	 * @MethodName       getCount
	 * @Description      获取连通分支数
	 * @return           int 连通分支数
	 */
	public int getCount() {
		return count;
	}
}

/**
 * @ClassName      UnionFindRank
 * @Description    并查集：路径压缩+秩优化，秩优化导致性能不升反降
 * @author         moonspirit
 * @date           2018年11月19日 上午10:32:18
 * @version        1.0.0
 */
class UnionFindRank {
	private int size;
	private int count;
	private int[] pre;
	private int[] rank;

	/**
	 * @Description    构造并初始化
	 * @param          n 规模
	 */
	public UnionFindRank(int n) {
		size = n;
		count = n;
		pre = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			pre[i] = i;
			rank[i] = 0;
		}
	}

	/**
	 * @MethodName       find
	 * @Description      查找祖先：压缩路径（递归版）
	 *                   找到最久远的祖先时把它的子孙直接连接到它上面，可以保证树最多只有两层
	 * @param            x 子孙节点
	 * @return           int 根节点
	 */
	private int find(int x) {
		if (pre[x] == x) {
			return x;
		}
		return pre[x] = find(pre[x]);
	}

	/**
	 * @MethodName       findFather
	 * @Description      查找祖先：压缩路径（迭代版） 效率优于递归
	 *                   找到最久远的祖先时把它的子孙直接连接到它上面，可以保证树最多只有两层
	 * @param            x 子孙节点
	 * @return           int 根节点
	 */
	private int findFather(int x) {
		int p = x;
		while (pre[p] != p) {
			p = pre[p];
		}
		while (x != p) {
			int tmp = pre[x];
			pre[x] = p;
			x = tmp;
		}
		return x;
	}

	/**
	 * @MethodName       union
	 * @Description      合并子树：秩优化
	 *                   合并时，总是将具有较小秩的树根指向具有较大秩的树根，减少查找祖先时递归迭代的次数，最坏只有logN次
	 *                   在实施压缩路径优化后，再采用秩优化性能不升反降：压缩路径优化足以树不被退化，不必再维护一个 n 规模的数组进行秩优化
	 * @param            x 子树根节点
	 * @param            y 子树根节点
	 */
	public void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if (fx != fy) {
			if (rank[fx] > rank[fy]) {
				pre[fy] = fx;
			} else {
				if (rank[fx] == rank[fy]) {
					rank[fy]++;
				}
				pre[fx] = fy;
			}
			count--;
		}
	}

	/**
	 * @MethodName       getCount
	 * @Description      获取连通分支数
	 * @return           int 连通分支数
	 */
	public int getCount() {
		return count;
	}
}

/**
 * @ClassName      Solution
 * @Description    [Leetcode 547](https://leetcode-cn.com/problems/friend-circles/description/)
 *                 并查集
 * @author         moonspirit
 * @date           2018年11月19日 上午10:27:41
 * @version        1.0.0
 */
class Solution {
	/**
	 * @MethodName       findCircleNum
	 * @Description      解题类
	 * @param            M 二维数组表示的无向图
	 * @return           int 连通分支数
	 */
	public int findCircleNum(int[][] M) {
		int n = M.length;
		if (n == 0) {
			return 0;
		}

		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1)
					uf.union(i, j);
			}
		}
		return uf.getCount();
	}
}

/**
 * @ClassName      SolutionDFS
 * @Description    [Leetcode 547](https://leetcode-cn.com/problems/friend-circles/description/)
 *                 DFS
 * @author         moonspirit
 * @date           2018年11月19日 上午11:22:05
 * @version        1.0.0
 */
class SolutionDFS {
	public void dfs(int[][] M, int[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] != 1) {
				visited[j] = 1;
				dfs(M, visited, j);
			}
		}
	}
	
	public void bfs(int[][] M, int[] visited, int i) {
		Deque<int> dq = new 
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] != 1) {
				visited[j] = 1;
				dfs(M, visited, j);
			}
		}
	}

	/**
	 * @MethodName       findCircleNum
	 * @Description      解题类
	 * @param            M 二维数组表示的无向图
	 * @return           int 连通分支数
	 */
	public int findCircleNum(int[][] M) {
		int n = M.length;
		if (n == 0) {
			return 0;
		}

		int[] visited = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] != 1) {
				dfs(M, visited, i);
				count++;
			}
		}
		return count;
	}
}
