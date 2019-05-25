package problem.java.problem168;

/**
 * 转换数字为Excel的columns值
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 *
 * 解题思路：不断进行末位求余。计算字符时使用ASC码
 */
public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            char ch = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(26));
    }

}
