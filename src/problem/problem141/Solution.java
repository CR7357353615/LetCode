package problem.problem141;

/**
 * Definition for singly-linked list. 两个指针，追逐。 还可以用set，遍历，判断是否重复
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = head;
        n2.next = head;

        while (true) {
            if (n2.next == null || n2.next.next == null) {
                return false;
            }
            n2.next = n2.next.next.next;
            n1.next = n1.next.next;
            if (n1.next == n2.next) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(n1));
    }
}
