package problem.java.problem172;

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
 * 解题思路：乘数中只有2和5遇到才会出现0，所以要计算所有乘数中有多少2，5对。但是往往2比5多，所以只要计算5的个数就可以了。
 * 具体解题思路可见：https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC172%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E9%98%B6%E4%B9%98%E5%90%8E%E7%9A%84%E9%9B%B6.md
 *
 */
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
