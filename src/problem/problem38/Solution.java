package problem.problem38;

/**
 * 外观数列
 * 从1开始，每一项是对前一项的解释
 * 1 1
 * 2 一个1  11
 * 3 两个1  21
 * 4 一个2，一个1   1211
 * 5 一个1，一个2，两个1  111221
 * 以此类推
 *
 * 解题思路：遍历，记录连续相同值个数，添加到字符串中
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String root = "1";
        for (int i = 1; i < n; i++) {
           root = cal(root);
        }
        return root;
    }

    private String cal(String nums) {
        int sum = 0;
        char[] chars = nums.toCharArray();
        char curr = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (curr == chars[i]) {
                sum++;
            } else {
                sb.append(sum);
                sb.append(curr);
                sum = 1;
            }
            curr = chars[i];
        }
        sb.append(sum);
        sb.append(curr);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
//        System.out.println(solution.cal("21"));
    }
}
