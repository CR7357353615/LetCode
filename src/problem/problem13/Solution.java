package problem.problem13;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 罗马数字转数字
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * 解题思路：保存最近数字，如果当前数字大于最近数字，sum减去最近数字的两倍，再加上当前数字
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

//        Stack<Integer> stack = new Stack<>();

        int curr = 0;
        int sum = 0;
        for (Character c : s.toCharArray()) {
            Integer num = map.get(c);
            if (num != null) {
                if (num > curr) {
                    sum -= curr * 2;
                }
                sum += num;
                curr = num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
