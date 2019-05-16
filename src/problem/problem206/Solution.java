package problem.problem206;

/**
 * Definition for singly-linked list. 链表逆序
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 解题思路：三个指针，保证链表不断
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode first = new ListNode(1);
        first.next = head;

        ListNode second = new ListNode(2);
        second.next = head.next;

        ListNode third = new ListNode(3);
        third.next = head.next.next;

        // 两个节点
        if (third.next == null) {
            first.next.next = null;
            second.next.next = first.next;
            return second.next;
        }

        head.next = null;
        // 三个及三个以上
        while (second.next != null) {
            second.next.next = first.next;
            first.next = second.next;
            second.next = third.next;
            if (null != third.next) {
                third.next = third.next.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        Solution solution = new Solution();
        ListNode result = solution.reverseList(n1);
        System.out.println(result);
    }
}
