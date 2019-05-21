package problem.problem101;

/**
 * 判断是否是镜像二叉树
 *
 * 解题思路：递归对比两个节点值是否相等，相等再对比1.left ?= 2.right, 1.right ?= 2.left；
 *
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode node1, TreeNode node2) {
        int sum = 0;
        sum += node1 == null ? 0 : 1;
        sum += node2 == null ? 0 : 1;
        if (sum == 0) {
            return true;
        }
        if (sum == 1) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSym(node1.left, node2.right) && isSym(node1.right, node2.left);
        } else {
            return false;
        }
    }
}
