package problem.problem28;

/**
 * 返回子串首位置
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
