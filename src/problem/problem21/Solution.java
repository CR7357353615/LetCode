package problem.problem21;

/**
 * Definition for singly-linked list. 合并有序链表
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 解题思路：设置哨兵节点，每次将两个链表中较小的值加入最终链表尾部。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(1);

        ListNode sentry = new ListNode(0);
        head.next = sentry;
        tail.next = sentry;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (l2 != null) {
                    tail.next.next = new ListNode(l2.val);
                    tail.next = tail.next.next;
                    l2 = l2.next;
                    continue;
                }
            }
            if (l2 == null) {
                if (l1 != null) {
                    tail.next.next = new ListNode(l1.val);
                    tail.next = tail.next.next;
                    l1 = l1.next;
                    continue;
                }
            }
            if (l1.val <= l2.val) {
                tail.next.next = new ListNode(l1.val);
                tail.next = tail.next.next;
                l1 = l1.next;
            } else {
                tail.next.next = new ListNode(l2.val);
                tail.next = tail.next.next;
                l2 = l2.next;
            }
        }
        return sentry.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        Solution solution = new Solution();
        solution.mergeTwoLists(n1, n4);
    }
}
