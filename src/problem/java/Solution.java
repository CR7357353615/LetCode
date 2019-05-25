package problem.java.problem66;

/**
 * 数组代表一个数，加1
 * 从最后一位进行进位计算
 *
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return null;
        }
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + plus;
            plus = sum / 10;
            digits[i] = sum % 10;
        }
        if (plus > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = plus;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{1,2,3});
    }
}
