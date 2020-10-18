package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

/**
 * @author choleece
 * @Description: 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * @Date 2020-10-18 17:42
 **/
public class Nc53 {

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        head = reverseListNode(head);

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = head;
        ListNode preP = dummyHead;
        for(int i = 0; i < n - 1; i++) {
            p = p.next;
            preP = preP.next;
        }

        preP.next = p.next;

        return reverseListNode(dummyHead.next);
    }

    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = head;
        while(p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }
        return dummyHead.next;
    }

}
