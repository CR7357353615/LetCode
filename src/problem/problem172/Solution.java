package problem.problem172;

/**
 * 给定一正整数，求其阶乘结果尾部有多少0
 *
 * Examples:
 * input: 3
 * output: 0
 *
 * input: 5
 * output: 1
 *
 *
 */
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
