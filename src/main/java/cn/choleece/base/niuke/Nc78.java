package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

/**
 * @author choleece
 * @Description: 输入一个链表，反转链表后，输出新链表的表头
 * @Date 2020-10-18 17:40
 **/
public class Nc78 {

    public ListNode ReverseList(ListNode head) {
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
