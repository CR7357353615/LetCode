package problem.problem107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树从底向上从左到右返回节点
 *
 * 解题思路：逐层遍历，使用LinkedList从头部添加
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) {
            return result;
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
            List<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(root);
            add(treeNodes, result);
            return result;
        }
    }

    private void add(List<TreeNode> n, List<List<Integer>> result) {
        if (n == null || n.size() == 0) {
            return;
        }
        List<TreeNode> n1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (TreeNode node : n) {
            if (node.left != null) {
                n1.add(node.left);
                list.add(node.left.val);
            }
            if (node.right != null) {
                n1.add(node.right);
                list.add(node.right.val);
            }
        }
        if (list.size() > 0) {
            result.add(0, list);
        }
        if (n1.size() > 0) {
            add(n1, result);
        }
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(n3));

    }
}
