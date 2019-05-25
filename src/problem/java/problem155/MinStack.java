package problem.java.problem155;

import java.util.Stack;

/**
 * 实现一个栈，并且能够实时返回栈中最小值
 *
 * 解题思路，min变量来保存最小值，如果新压入栈的值小于当前min，则先把min压入栈，再把新值压入栈。
 * 再pop时先判断栈顶值是不是等于最小值，如果等于，要把栈顶元素的下一个元素也出栈，并把值赋值给min。
 */

public class MinStack {

    private int min = Integer.MAX_VALUE;

    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */