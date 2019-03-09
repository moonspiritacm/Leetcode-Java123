package com.moonspirit.leetcode.p145;

/**
 * @ClassName      SolutionC
 * @Description    迭代求解，引入变量记录上次访问节点，右节点为空或已被访问则访问根节点，否则遍历右子树
 * @author         moonspirit
 * @date           2019年2月23日 下午12:02:13
 * @version        1.0.0
 */
class SolutionC {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (!stack.isEmpty()) {
			root = stack.peek();
			if (root.right == null || root.right == pre) { // 没有右子树或者右子树已访问时，访问根节点并出栈
				res.add(root.val);
				pre = root;
				stack.pop();
			} else { // 否则跳过根节点，遍历右子树
				root = root.right;
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
			}
		}
		return res;
	}
}
