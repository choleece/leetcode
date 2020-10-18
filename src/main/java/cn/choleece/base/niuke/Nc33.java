package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

/**
 * @author choleece
 * @Description: 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的
 * @Date 2020-10-18 17:43
 **/
public class Nc33 {

    /**
     *
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = l1;
        ListNode pre = dummyHead;

        while(l1 != null && l2 != null) {
            if (l2.val <= l1.val) {
                // neet to insert
                ListNode tmp = new ListNode(l2.val);
                pre.next = tmp;
                tmp.next = l1;

                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            pre = pre.next;
        }

        while(pre.next != null) {
            pre = pre.next;
        }

        if (l2 != null) {
            pre.next = l2;
        }

        return dummyHead.next;
    }

}
