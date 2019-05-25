package problem.java.problem160;

import java.util.Stack;

/**
 * 找出两个链表相交的节点
 *
 * 解题思路：使用两个栈，从链表尾部开始对比
 *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode result = null;
        while (!stackA.empty() && !stackB.empty()) {
            ListNode listNode1 = stackA.pop();
            ListNode listNode2 = stackB.pop();
            if (listNode1 == listNode2) {
                result = listNode1;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        Solution solution = new Solution();
        solution.getIntersectionNode(node1, node6);
    }

}
