package problem.java.problem224;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 基础计算器
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * 解题思路：使用两个栈，一个存符号，一个存数字。但要注意数字不都是一位，要考虑合并数字
 * 所以先进行数字和符号的拆分，再进行入栈。
 */
public class Solution {
    public int calculate(String s) {
        List<String> strs = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return 0;
        }
        boolean addNum = false;
        int number = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (String.valueOf(c).equals(" ")) {
                continue;
            }
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
                addNum = true;
            } else {
                if (addNum) {
                    strs.add(String.valueOf(number));
                    number = 0;
                }
                strs.add(String.valueOf(c));
                addNum = false;
            }
        }
        if (addNum) {
            strs.add(String.valueOf(number));
        }
        return calculate1(strs);
    }

    private int calculate1(List<String> strs) {
        if (null == strs || strs.size() == 0) {
            return 0;
        }

        Stack<String> calStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (String s1 : strs) {
            if (s1.equals(" ")) {
                continue;
            }
            if (s1.equals(")")){
                calStack.pop();
                if (calStack.empty()) {
                    continue;
                }
                String cal = calStack.pop();
                if (cal.equals("+")) {
                    int sum = numStack.pop() + numStack.pop();
                    numStack.push(sum);
                }
                if (cal.equals("-")) {
                    int temp = numStack.pop();
                    int sum = numStack.pop() - temp;
                    numStack.push(sum);
                }
            } else if (s1.equals("+")) {
                calStack.push(s1);
            } else if (s1.equals("-")) {
                calStack.push(s1);
            } else if (s1.equals("(")) {
                calStack.push(s1);
                continue;
            } else {
                if (calStack.empty()) {
                    numStack.push(Integer.valueOf(s1));
                } else {
                    String cal = calStack.peek();
                    if (cal.equals("+")) {
                        int sum = numStack.pop() + Integer.valueOf(s1);
                        numStack.push(sum);
                        calStack.pop();
                    } else if (cal.equals("-")) {
                        int sum = numStack.pop() - Integer.valueOf(s1);
                        numStack.push(sum);
                        calStack.pop();
                    } else {
                        numStack.push(Integer.valueOf(s1));
                    }
                }
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1-(5)"));
    }
}
