package problem.problem160;


/**
 * 找出两个链表相交的节点
 *
 * 解题思路：遍历两次，第一次求两链表长度，求差，然后长的链表先遍历差值。最后两个链表一起遍历，直到节点相等，返回
 * 更优
 *
 */
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        int lenA = 1;
        int lenB = 1;

        ListNode lastA = new ListNode(0);
        lastA.next = headA;
        ListNode lastB = new ListNode(0);
        lastB.next = headB;

        while (lastA.next.next != null) {
            lastA.next = lastA.next.next;
            lenA++;
        }

        while (lastB.next.next != null) {
            lastB.next = lastB.next.next;
            lenB++;
        }

        ListNode result = null;
        if (lastA.next == lastB.next) {
            int n = lenA >= lenB ? lenA - lenB : lenB - lenA;
            lastA.next = headA;
            lastB.next = headB;
            if (lenA > lenB) {
                for (int i = 0 ; i < n; i++) {
                    lastA.next = lastA.next.next;
                }


            }
            if (lenA < lenB) {
                for (int i = 0 ; i < n; i++) {
                    lastB.next = lastB.next.next;
                }
            }
            while (lastA.next != lastB.next) {
                lastA.next = lastA.next.next;
                lastB.next = lastB.next.next;
            }
            result = lastA.next;
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

        Solution1 solution = new Solution1();
        solution.getIntersectionNode(node1, node6);
    }

}
