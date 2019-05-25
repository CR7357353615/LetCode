package problem.java.problem58;

/**
 * 找出字符串中最后一个不含空格的子串长度
 *
 * 解题思路：用长度减去最后一个空格所在位置，需要trim一下字符串，否则最后一个空格可能会受到影响
 *
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
         return 0;
        }
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}