package problem.problem104;

/**
 * 求树的高度
 *
 * 递归求左右子树深度高的值
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(dp(root.left, 1), dp(root.right, 1));
        }
    }

    private int dp(TreeNode n, int sum) {
        if (n == null) {
            return sum;
        } else {
            return 1 + Math.max(dp(n.left, sum), dp(n.right, sum));
        }
    }
}
