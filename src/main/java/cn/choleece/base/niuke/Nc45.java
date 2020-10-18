package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.TreeNode;

/**
 * @author choleece
 * @Description: 分别按照二叉树先序，中序和后序打印所有的节点
 * @Date 2020-10-18 17:41
 **/
public class Nc45 {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    private int preIndex = 0, inIndex = 0, postIndex = 0;
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int nodeNums = count(root);
        int[][] result = new int[3][nodeNums];

        orders(root, result);

        return result;
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    public void orders(TreeNode root, int[][] result) {
        if (root == null) {
            return;
        }
        result[0][preIndex++] = root.val;
        orders(root.left, result);
        result[1][inIndex++] = root.val;
        orders(root.right, result);
        result[2][postIndex++] = root.val;
    }
}
