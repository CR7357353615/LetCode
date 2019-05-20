package problem.problem100;

/**
 * 相同的树
 *
 * 解题思路：左右递归调用
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) {
            if (null == p && null == q) {
                return true;
            } else {
                return false;
            }
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
