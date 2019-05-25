package problem.java.problem19;

/**
 * @author lihao
 * @date 2019-05-16 14:04
 */
/**
 * Definition for singly-linked list. 删除倒数第n个节点
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 解题思路：在头节点前设置哨兵节点，然后设置两个相隔n的指针，一起向尾节点移动，然后执行删除
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        if (n <= 0) {
            return null;
        }

        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode n1 = new ListNode(1);
        n1.next = sentry;
        ListNode n2 = new ListNode(2);
        n2.next = sentry;

        int i = 0;
        while (i <= n) {
            n1.next = n1.next.next;
            i++;
        }
        while (n1.next != null) {
            n1.next = n1.next.next;
            n2.next = n2.next.next;
        }
        n2.next.next = n2.next.next.next;
        return sentry.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(n1, 1));
    }
}