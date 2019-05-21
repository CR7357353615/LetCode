package problem.problem108;

/**
 * 有序数组转为平衡二叉树
 *
 * 解题思路：二分法递归选取中间数为父节点
 * 改进：使用start，end索引，而不是每次创建新的数组
 *
 */
public class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int median = (end + start + 1) / 2;
        TreeNode root = new TreeNode(nums[median]);
        root.left = helper(nums, start, median - 1);
        root.right = helper(nums, median + 1, end);
        return root;
    }
}
