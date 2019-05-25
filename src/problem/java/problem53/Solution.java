package problem.java.problem53;

/**
 * 找出int数组中子数组和最大的和
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 解题思路：一个变量保存当前最大和，一个变量做遍历累计。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int sum = Integer.MIN_VALUE;
        for (int i : nums) {
            max += i;
            if (max < i) {
                max = i;
            }
            if (max > sum) {
                sum = max;
            }
        }
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
