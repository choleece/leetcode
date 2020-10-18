package cn.choleece.base.leetcode;

import java.util.*;

/**
 * @author choleece
 * @Description: 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * @Date 2020-10-17 00:14
 **/
public class Solution103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean right = true;
        while (!queue.isEmpty()) {
            List<Integer> rowList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (right) {
                    rowList.add(tmp.val);
                } else {
                    rowList.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            result.add(rowList);
            right = !right;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

        System.out.println(zigzagLevelOrder(root));
    }
}
