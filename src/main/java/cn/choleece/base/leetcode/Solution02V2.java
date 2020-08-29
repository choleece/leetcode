package cn.choleece.base.leetcode;

import java.util.Arrays;

/**
 * @author choleece
 * @Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @Date 2020-08-29 10:12
 **/
public class Solution02V2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;

        int jin = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jin;
            jin = sum / 10;

            result.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        while(l1 != null) {
            int sum = l1.val + jin;
            jin = sum / 10;

            result.next = new ListNode(sum % 10);
            l1 = l1.next;
            result = result.next;
        }

        while(l2 != null) {
            int sum = l2.val + jin;
            jin = sum / 10;

            result.next = new ListNode(sum % 10);
            l2 = l2.next;
            result = result.next;
        }

        if (jin > 0) {
            result.next = new ListNode(jin);
        }

        return dummyHead.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = head;
        ListNode pCur;
        while((pCur = prev.next) != null) {
            prev.next = pCur.next;
            pCur.next = dummyHead.next;
            dummyHead.next = pCur;
        }

        return dummyHead.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);

        ListNode p = head;
        while(p != null) {
            ListNode q = p.next;
            p.next = dummyHead.next;
            dummyHead.next = p;
            p = q;
        }

        return dummyHead.next;
    }

    public static void changeNum(int a) {
        a = 10;
    }

    public static void main(String[] args) {

        int a = 1;
        changeNum(a);
        System.out.println(a);
        ListNode.loopList(addTwoNumbers(ListNode.initList(Arrays.asList(5, 9)), ListNode.initList(Arrays.asList(5))));
    }

}
