package cn.choleece.base.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author choleece
 * @Description: 给定一个二叉树，返回所有从根节点到叶子节点的路径
 * 说明: 叶子节点是指没有子节点的节点
 * @Date 2020-10-18 17:30
 **/
public class Solution257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        Stack<Integer> combine = new Stack<Integer>();
        combine.push(root.val);

        backTrack(combine, root, result);

        return result;
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void backTrack(Stack<Integer> combine, TreeNode node, List<String> result) {
        if (isLeaf(node)) {
            StringBuffer trace = new StringBuffer();
            combine.forEach(item -> trace.append(item).append("->"));
            result.add(trace.substring(0, trace.length() - 2).toString());
            return;
        }

        if (node.left != null) {
            combine.push(node.left.val);
            backTrack(combine, node.left, result);
            combine.pop();
        }

        if (node.right != null) {
            combine.push(node.right.val);
            backTrack(combine, node.right, result);
            combine.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(binaryTreePaths(root));
    }
}
