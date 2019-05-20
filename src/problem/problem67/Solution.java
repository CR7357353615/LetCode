package problem.problem67;

/**
 * 二进制相加
 * 解题思路：转为数字数组，从尾部进位相加
 *
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();

        int max = Math.max(as.length, bs.length);

        int[] ai = new int[max];
        int[] bi = new int[max];

        // 赋值
        for (int i = 0; i < max - as.length; i++) {
            ai[i] = 0;
        }
        for (int i = max - as.length; i < max; i++) {
            ai[i] = Integer.valueOf(String.valueOf(as[i - (max - as.length)]));
        }
        for (int i = 0; i < max - bs.length; i++) {
            bi[i] = 0;
        }
        for (int i = max - bs.length; i < max; i++) {
            bi[i] = Integer.valueOf(String.valueOf(bs[i - (max - bs.length)]));
        }


        int plus = 0;
        for (int i = max - 1; i >= 0; i--) {
            int sum = ai[i] + bi[i] + plus;
            plus = sum / 2;
            ai[i] = sum % 2;
        }
        StringBuilder sb = new StringBuilder();
        if (plus > 0) {
            int[] result = new int[ai.length + 1];
            result[0] = plus;
            for (int i = 0; i < ai.length; i++) {
                result[i + 1] = ai[i];
            }
            for (int i : result) {
                sb.append(i);
            }
        } else {
            for (int i : ai) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addBinary("11", "1");
    }
}
