package problem.java.problem33;

/**
 * 循环排序数组，使用二分法找指定值索引
 * 解题思路：二分法，如果中间数的值与左边或右边形成有序队列，并且目标值落在范围内，则变成二分法。
 *         否则，在另一个范围内寻找
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        } else {
            return bSearch(nums, 0, nums.length - 1, target);
        }
    }

    private int bSearch(int[] array, int l, int r, int target) {
        if (l == r) {
            return target == array[l] ? l : -1;
        }
        if (l + 1 == r) {
            return target == array[l] ? l : (target == array[r] ? r : -1);
        }
        int mid = l + ((r - l) / 2);
        if (array[l] < array[mid]) {
            if (target >= array[l] && target <= array[mid]) {
                return bSearch(array, l, mid, target);
            } else {
                return bSearch(array, mid, r, target);
            }
        }
        if (array[mid] < array[r]) {
            if (target >= array[mid] && target <= array[r]) {
                return bSearch(array, mid, r, target);
            } else {
                return bSearch(array, l, mid, target);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5};
        Solution solution = new Solution();
        System.out.println(solution.search(array, 3));
    }
}
