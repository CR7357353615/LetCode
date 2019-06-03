package problem.java.problem189;

// 将数组最后一个数放到第一位，给定k，放k次
// 解题思路：移位，前置

//Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//        Example 1:
//
//        Input: [1,2,3,4,5,6,7] and k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]
//        Example 2:
//
//        Input: [-1,-100,3,99] and k = 2
//        Output: [3,99,-1,-100]
//        Explanation:
//        rotate 1 steps to the right: [99,-1,-100,3]
//        rotate 2 steps to the right: [3,99,-1,-100]
//        Note:
//
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//        Could you do it in-place with O(1) extra space?
public class Solution {
    public void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return;
        }
        k = k % nums.length;

        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - i - 1];
        }
        for (int i = nums.length - k - 1; i >=0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = tmp.length - 1; i >= 0; i--) {
            nums[tmp.length - i - 1] = tmp[i];
        }
    }
}
