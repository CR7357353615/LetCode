package problem.java.problem496;

import java.util.Arrays;
import java.util.Stack;

/**
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * 数组1是数组2的子集
 * 找到数组1的数在数组2中右边第一个比它大的数。
 *
 * 解题思路：使用两个栈。栈1保存数组2的数，栈2做中转栈
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int num2 : nums2) {
            stack1.push(num2);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            while (stack1.peek() != nums1[i]) {
                stack2.push(stack1.pop());
            }
            if (stack2.empty()) {
                result[i] = -1;
            } else {
                boolean flag = false;
                boolean find = false;
                while (!stack2.empty()) {
                    if (find) {
                        stack1.push(stack2.pop());
                    } else {
                        int temp = stack2.pop();
                        if (temp > nums1[i]) {
                            flag = true;
                        }
                        stack1.push(temp);
                        if (flag) {
                            result[i] = temp;
                            find = true;
                        } else {
                            result[i] = -1;
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(a -> System.out.println(a));
    }
}
