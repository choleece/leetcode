package cn.choleece.base.niuke;

import cn.choleece.base.leetcode.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author choleece
 * @Description: 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0
 * @Date 2020-10-28 21:06
 **/
public class Nc40V1 {

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        pushData(head1, stack1);
        pushData(head2, stack2);

        ListNode head = null;
        int jin = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || jin > 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = val1 + val2 + jin;

            ListNode temp = new ListNode(sum % 10);
            // 采用头插入法，避免链表倒转
            temp.next = head;
            head = temp;

            jin = sum / 10;
        }

        return head;
    }

    public static void pushData(ListNode node, Stack<Integer> stack) {
        ListNode p = node;
        while(p != null) {
            stack.push(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode.loopList(addInList(ListNode.initList(Arrays.asList(9, 3, 7)), ListNode.initList(Arrays.asList(6, 3))));
    }
}
