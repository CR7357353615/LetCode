package problem.java.problem9;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断数字是否回文，不用转为String
 *
 * 解题思路：从个位开始剥离，存入integer list中。然后遍历收尾对比
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            list.add(pop);
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).intValue() != list.get(list.size() - i - 1).intValue()) {
                return false;
            }
        }
        return true;
    }
}
