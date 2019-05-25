package problem.java.problem844;

import java.util.Stack;

/**
 * @author lihao
 * @date 2019-05-19 22:18
 *
 * 给两个字符串S，T，#代表删除上一字符操作。求一波操作后字符串是否相等
 *
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * 解题思路：使用栈
 *
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (c.equals('#')) {
                if (!ss.empty()) {
                    ss.pop();
                }
            } else {
                ss.push(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c.equals('#')) {
                if (!ts.empty()) {
                    ts.pop();
                }
            } else {
                ts.push(c);
            }
        }


        while (!ss.empty() && !ts.empty()) {
            if (!ss.pop().equals(ts.pop())) {
                return false;
            }
        }
        if (ss.empty() && ts.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
