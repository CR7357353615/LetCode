package problem.problem26;

/**
 * 排序数组去重
 *
 * 解题思路：因为是排序的，所以设置哨兵值，大于哨兵的数放在数组前列。
 *
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int curr = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                continue;
            } else {
                nums[curr++] = nums[i];
                temp = nums[i];
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        int len = solution.removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
