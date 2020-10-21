package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

/**
 * @author choleece
 * @Description: 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么
 * @Date 2020-10-20 22:13
 **/
public class Nc3 {

    /**
     * X，Y，Z分别为链表起始位置，环开始位置和两指针相遇位置，由快指针速度的慢指针速度的2倍
     * 快指针与慢指针均从X出发，在Z相遇。此时，慢指针行使距离为a+b，快指针为a+b+n(b+c）。
     * 所以2*(a+b)=a+b+n*(b+c),推出
     * a=(n-1)*b+n*c=(n-1)(b+c)+c;
     * 得到，将此时两指针分别放在起始位置和相遇位置，并以相同速度前进，当一个指针走完距离a时，另一个指针恰好走出 绕环n-1圈加上c的距离
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode snow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            snow = snow.next;
            fast = fast.next.next;

            if (fast != null && snow.val == fast.val) {
                snow = head;
                while(snow.val != fast.val) {
                    snow = snow.next;
                    fast = fast.next;
                }
                return snow;
            }
        }

        return null;
    }
}
