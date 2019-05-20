package problem.problem14;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出字符串数组中共同的最长前缀
 *
 * 解题思路：迭代对比
 *
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        List<Character> prefix = new ArrayList<>();
        for (char c : strs[0].toCharArray()) {
            prefix.add(c);
        }
        for (int i = 1; i < strs.length; i++) {
            List<Character> temp = new ArrayList<>();
            char[] chars = strs[i].toCharArray();
            int min = Math.min(prefix.size(), chars.length);
            int current = -1;
            for (int j = 0; j < min; j++) {
                if (prefix.get(j).equals(chars[j]) && (j == current + 1)) {
                    temp.add(prefix.get(j));
                    current++;
                }
            }
            prefix = temp;
        }
        char[] cs = new char[prefix.size()];
        for (int i = 0; i < prefix.size(); i++) {
            cs[i] = prefix.get(i);
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"fl323", "fl", "fld"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
