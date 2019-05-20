package problem.problem88;

/**
 * 合并有序队列
 *
 * 解题思路：从后先前填充
 *
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        int curr = m + n - 1;
        int tempA = 0;
        int tempB = 0;
        while (!(m == 0 && n == 0)) {
            if (m - 1 < 0) {
                nums1[curr] = tempB;
                n--;
            } else {
                tempA = nums1[m -1];
            }
            if (n - 1 < 0) {
                tempB = Integer.MIN_VALUE;
            } else {
                tempB = nums2[n -1];
            }

            if (tempB >= tempA) {
                nums1[curr] = tempB;
                n--;
            } else {
                nums1[curr] = tempA;
                m--;
            }
            curr--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
