package problem.java.problem169;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 找出数组中出现次数超过 n / 2（向下取整）个数的数字
 *
 * 使用map保存次数
 *
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer times = map.get(num);
            if (times == null) {
                map.put(num, 1);
            } else {
                map.put(num, times + 1);
            }
        }
        int n = nums.length / 2;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
