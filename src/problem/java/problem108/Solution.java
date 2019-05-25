package problem.java.problem108;

/**
 * 有序数组转为平衡二叉树
 *
 * 解题思路：二分法递归选取中间数为父节点
 *
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return getNode(nums);
    }

    private TreeNode getNode(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else {
            int midd = nums.length / 2;
            TreeNode node = new TreeNode(nums[midd]);
            if (midd - 1 >= 0) {
                int[] numsl = new int[midd];
                for (int i = 0; i < midd; i++) {
                    numsl[i] = nums[i];
                }
                node.left = getNode(numsl);
            }
            if (midd + 1 <= nums.length - 1) {
                int[] numsr = new int[nums.length - midd - 1];
                for (int i = midd + 1; i <= nums.length - 1; i++) {
                    numsr[i - midd - 1] = nums[i];
                }
                node.right = getNode(numsr);
            }
            return node;
        }
    }
}
