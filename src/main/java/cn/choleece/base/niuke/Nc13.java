package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.TreeNode;

/**
 * @author choleece
 * @Description: 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量
 * @Date 2020-10-18 17:44
 **/
public class Nc13 {

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
