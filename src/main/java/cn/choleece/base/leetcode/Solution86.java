package cn.choleece.base.leetcode;

import java.util.Arrays;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author choleece
 *
 * 思路1： 将链表拆成小于x 和 大于等于x的两条链，然后将大链链在小链后边即可
 * 思路2：交换，如果出现过比x大的数才进行交换，否则保持原来的状态
 */
public class Solution86 {

    public static ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpNode = new ListNode(-1);
        tmpNode.next = head;

        ListNode cur = head, preCur = tmpNode, insertPoint = tmpNode;

        boolean hasX = false;
        while (cur != null) {
            if (cur.val >= x) {
                hasX = true;
            }
            boolean needSwap = cur.val < x && hasX;
            if (needSwap) {
                preCur.next = cur.next;
                cur.next = insertPoint.next;
                insertPoint.next = cur;

                insertPoint = insertPoint.next;
                cur = preCur.next;
            } else {
                cur = cur.next;
                preCur = preCur.next;
                if (insertPoint.next.val < x) {
                    insertPoint = insertPoint.next;
                }
            }
        }

        return tmpNode.next;
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessList = new ListNode(-1);
        ListNode greaterList = new ListNode(-1);

        ListNode cur = head, lessCur = lessList, greaterCur = greaterList;
        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = new ListNode(cur.val);
                lessCur = lessCur.next;
            } else {
                greaterCur.next = new ListNode(cur.val);
                greaterCur = greaterCur.next;
            }

            cur = cur.next;
        }

        lessCur.next = greaterList.next;
        return lessList.next;
    }



    public static void main(String[] args) {
        ListNode head = ListNode.initList(Arrays.asList(1, 1, 3, 2, 5, 2));

        ListNode.loopList(head);

        head = partition1(head, 3);

        ListNode.loopList(head);
    }
}
