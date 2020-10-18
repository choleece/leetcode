package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.TreeNode;

/**
 * @author choleece
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像
 * @Date 2020-10-18 18:03
 **/
public class Nc72 {

    public static void mirror(TreeNode root) {
        changeLeftAndRight(root);
    }

    public static void changeLeftAndRight(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        changeLeftAndRight(root.left);
        changeLeftAndRight(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8, new TreeNode(6, new TreeNode(5), new TreeNode(7)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));

        mirror(root);

        TreeNode.dfs(root);
    }
}
