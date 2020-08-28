package cn.choleece.base.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * @author choleece
 */
public class Solution94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }

        return inOrder(list, root);
    }

    public static List<Integer> inOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return list;
        }

        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);

        return list;
    }

    public static void main(String[] args) {

    }
}
