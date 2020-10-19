package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.TreeNode;

/**
 * @author choleece
 * @Description:
 * 给定一个二叉树和一个值\ sum sum，判断是否有从根节点到叶子节点的节点值之和等于\ sum sum 的路径
 * @Date 2020-10-19 22:39
 **/
public class Nc9 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (isLeaf(root) && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
