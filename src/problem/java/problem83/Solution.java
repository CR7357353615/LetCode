package problem.java.problem83;

/**
 * 有序链表去重
 * 解题思路：设置指针，判断下一元素值与当前值是否相等，相等则删除下一元素
 *
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        while (sentry.next != null) {
            if (sentry.next.next == null) {
                return head;
            }
            if (sentry.next.val == sentry.next.next.val) {
                removeNode(sentry.next);
            } else {
                sentry.next = sentry.next.next;
            }
        }
        return head;
    }

    private void removeNode(ListNode n) {
        n.next = n.next.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
//        ListNode n3 = new ListNode(1);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        solution.deleteDuplicates(n1);


    }
}
