package problem.problem35;

/**
 * 获取指定值在有序数组中的位置，如果没有，返回应该插入的位置
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * 解题思路：设置哨兵值，进行遍历
 *
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int i = 0;
        boolean flag = false;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                flag = true;
                i = j;
                break;
            } else if (nums[j] < target) {
                i++;
            }
        }
        return i;
    }
}
