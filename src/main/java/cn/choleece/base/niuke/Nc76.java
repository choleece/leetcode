package cn.choleece.base.niuke;

import java.util.Stack;

/**
 * @author choleece
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * @Date 2020-10-20 20:49
 **/
public class Nc76 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        transfer(stack1, stack2);
        return stack2.pop();
    }

    public void transfer(Stack<Integer> stack1, Stack<Integer> stack2) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
