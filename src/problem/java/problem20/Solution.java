package problem.java.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 运算符是否成对
 * Example
 * Input: "([)]"
 * Output: false
 *
 * Input: "{[]}"
 * Output: true
 *
 * 解题思路：使用栈进行匹配
 */
public class Solution {
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(String.valueOf(c));
                continue;
            }
            String c1 = map.get(String.valueOf(stack.peek()));
            if (null == c1) {
                return false;
            }
            if (c1.equals(String.valueOf(c))) {
                stack.pop();
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
    }
}
