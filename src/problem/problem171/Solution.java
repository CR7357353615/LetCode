package problem.problem171;

/**
 *
 * 将Excel的column编号转为数字编号
 *
 * 解题思路：每位乘26的n-1次方
 *
 */
public class Solution {
    public int titleToNumber(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int num = chars.length;
        int sum = 0;
        for (char c : chars) {
            sum += (c - 'A' + 1) * Math.pow(26, --num);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.titleToNumber("AAA");
    }
}
