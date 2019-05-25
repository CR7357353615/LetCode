package problem.java.problem876;

/**
 * Definition for singly-linked list. 求链表中间节点。
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 解题思路： 快慢指针
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (null == head) {
            return head;
        }
        // 1个节点
        if (head.next == null) {
            return head;
        }
        // 2个节点
        if (head.next.next == null) {
            return head.next;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = sentry;
        n2.next = sentry;

        while (n2.next != null) {
            if (n2.next.next != null) {
                n2.next = n2.next.next.next;
            } else {
                n2.next = null;
            }
            n1.next = n1.next.next;
        }
        return n1.next;

    }
}