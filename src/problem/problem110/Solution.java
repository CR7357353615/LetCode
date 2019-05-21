package problem.problem110;

/**
 * 判断是否是平衡二叉树
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  解题思路：与求树的高度类似，就是当不平衡时返回-1，一旦出现-1则返回false
 *
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = checkBalance(root.left);
        int right = checkBalance(root.right);
        return (left == -1 || right == -1 || Math.abs(right - left) > 1) ? -1 : Math.max(right, left) + 1;
    }
}
