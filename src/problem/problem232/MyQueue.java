package problem.problem232;

import java.util.Stack;

/**
 * 使用栈实现队列
 * 解题思路： 一个栈做倒序作用
 *
 */
public class MyQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;


    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.empty()) {
            return 0;
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (stack1.empty()) {
            return 0;
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            int result = stack2.peek();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
//        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
