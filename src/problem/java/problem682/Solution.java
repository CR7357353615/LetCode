package problem.java.problem682;

import java.util.Stack;

/**
 * @author lihao
 * @date 2019-05-19 21:58
 *
 * 数字：直接加分
 * +：将前两次有效积分之和作为本次积分
 * C：减掉上一次有效积分
 * D：将上一次有效积分的2倍作为本次积分
 *
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 *
 * 解题思路：使用栈
 * 数字：直接入栈
 * +：将栈顶2各元素相加得到本次积分，入栈
 * C：移除栈顶元素
 * D：将栈顶元素乘2得到本次积分，入栈
 */
public class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                if (!stack.empty()) {
                    int temp = stack.pop();
                    sum -= temp;
                }
            } else if (op.equals("D")) {
                int temp = stack.peek() * 2;
                stack.push(temp);
                sum += temp;
            } else if (op.equals("+")) {
                int temp = stack.pop();
                int temp1 = stack.peek();
                int temp2 = temp + temp1;
                stack.push(temp);
                stack.push(temp2);
                sum += temp2;
            } else {
                int temp = Integer.valueOf(op);
                stack.push(temp);
                sum += temp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = new String[]{"5","2","C","D","+"};
        Solution solution = new Solution();
        System.out.println(solution.calPoints(ops));
    }
}
