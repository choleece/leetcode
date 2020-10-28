package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

import java.util.Arrays;

/**
 * @author choleece
 * @Description: 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0
 * @Date 2020-10-20 21:04
 **/
public class Nc40 {

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
//        head1 = reverseList(head1);
//        head2 = reverseList(head2);

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        int jin = 0;
        while (head1 != null && head2 != null) {
            int val = jin + head1.val + head2.val;
            jin = val / 10;

            p.next = new ListNode(val % 10);
            p = p.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int val = jin + head1.val;
            jin = val / 10;

            p.next = new ListNode(val % 10);
            p = p.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            int val = jin + head2.val;
            jin = val / 10;

            p.next = new ListNode(val % 10);
            p = p.next;
            head2 = head2.next;
        }

        if (jin == 1) {
            p.next = new ListNode(jin);
        }

        return dummyHead.next;
    }

    public static ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = root;
        ListNode p = root;

        while (p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode root1 = ListNode.initList(Arrays.asList(5), 1);
        ListNode root2 = ListNode.initList(Arrays.asList(5), 1);

        ListNode.loopList(reverseList(addInList(root1, root2)));
    }

}
