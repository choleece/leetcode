package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.TreeNode;

/**
 * @author choleece
 * @Description: 给定一个仅包含数字\ 0-9 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1\to 2\to 31→2→3,那么这条路径就用\ 123 123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * @Date 2020-10-18 17:35
 **/
public class Nc5 {

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public static int sumNumbers (TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int[] sum = {0};
        backTrack(root.val, root, sum);
        return sum[0];
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void backTrack(int num, TreeNode node, int[] result) {
        if (isLeaf(node)) {
            result[0] += num;
            return;
        }

        if (node.left != null) {
            num = num * 10 + node.left.val;
            backTrack(num, node.left, result);
            num = num / 10;
        }

        if (node.right != null) {
            num = num * 10 + node.right.val;
            backTrack(num, node.right, result);
            num = num / 10;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(sumNumbers(root));
    }
}
