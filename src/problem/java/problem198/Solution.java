package problem.java.problem198;

/**
 * 抢劫房子：不能连续抢两个房子，怎么抢的最多
 * 解题思路：创建一个tmp数组，存放对应每个位置能够抢到的最多的钱，
 * 找出每个tmp[0]到tmp[i - 2]位置的最大值 加上该房子的钱作为tmp[i]的值
 * 找出tmp中最大值
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 **/


public class Solution {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        tmp[1] = nums[1];

        int max = tmp[0] > tmp[1] ? tmp[0] : tmp[1];

        for (int i = 2; i < nums.length; i++) {
            int temp = 0;
            for (int j = i - 2; j >= 0; j--) {
                if (tmp[j] > temp){
                    temp = tmp[j];
                }
            }

            tmp[i] = nums[i] + temp;
            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }
}
