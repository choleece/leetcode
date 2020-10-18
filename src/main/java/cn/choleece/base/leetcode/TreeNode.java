package cn.choleece.base.leetcode;

import java.util.Stack;

/**
 * @author choleece
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initTree() {
        TreeNode root = new TreeNode(0);

        return root;
    }

    public static void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }

            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(5, new TreeNode(6), null)), new TreeNode(4));
        dfs(root);
    }
}
