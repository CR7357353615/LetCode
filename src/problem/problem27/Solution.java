package problem.problem27;

/**
 * 去除数组中指定值
 *
 * 解题思路：设置哨兵指针，不等于val的放入前列
 *
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        Solution solution = new Solution();
        solution.removeElement(nums, 3);
    }
}