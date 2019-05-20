package problem.problem14;


/**
 * 找出字符串数组中共同的最长前缀
 *
 * 解题思路：直接前缀定位
 *
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String[] strs = new String[]{"fl323", "fl", "fld"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
