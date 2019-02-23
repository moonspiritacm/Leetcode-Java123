package com.moonspirit.leetcode.p590;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName      Problem590
 * @Description    [Leetcode 590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/) N叉树——后序遍历
 * @author         moonspirit
 * @date           2019年2月23日 下午12:57:18
 * @version        1.0.0
 */
public class Problem590 {
	private static void createTreeNode(Element element, Node root) {
		if (element == null)
			return;
		Node node = new Node(element.getVal());
		root.children.add(node);
		for (Element ele : element.getChildren()) {
			createTreeNode(ele, node);
		}
	}

	/**
	 * @MethodName       stringToNaryTreeNode
	 * @Description      字符串转N叉树
	 * @param            input 待处理字符串 {"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
	 * @return           Node N叉树根节点
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static Node stringToNaryTreeNode(String input) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Element element = mapper.readValue(input, Element.class);
		if (element == null)
			return null;

		Node dummyRoot = new Node();
		createTreeNode(element, dummyRoot);
		return dummyRoot.children.get(0);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(Paths.get("src/com/moonspirit/leetcode/p590/Problem590.txt"), "UTF-8");
		SolutionA solution = new SolutionA();

		long begin = System.currentTimeMillis();
		while (in.hasNextLine()) {
			String str = in.nextLine();
			System.out.println(solution.postorder(stringToNaryTreeNode(str)));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) + "ms");

		in.close();
	}
}

/**
 * @ClassName      Node
 * @Description    N叉树节点类
 * @author         moonspirit
 * @date           2019年2月23日 下午12:51:43
 * @version        1.0.0
 */
class Node {
	public int val;
	public List<Node> children = new ArrayList<>();

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

/**
 * @ClassName      SolutionA
 * @Description    递归求解，时间复杂度 O(n)
 * @author         moonspirit
 * @date           2019年2月23日 下午12:52:18
 * @version        1.0.0
 */
class SolutionA {
	private void postorder(Node root, List<Integer> res) {
		if (root == null)
			return;
		for (Node node : root.children) {
			postorder(node, res);
		}
		res.add(root.val);
	}

	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		postorder(root, res);
		return res;
	}
}
