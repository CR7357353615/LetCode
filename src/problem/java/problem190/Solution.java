package problem.java.problem190;

// 将给定的Integer数字的二进制反转，返回反转后的Integer

// 解题思路： 二进制数是32位，可以把它拆成2部分看。左16位和右16位。
// 反转相当于从两头开始交换位置。(0, 31),(1, 30)...
// 在交换时，如果两数相同，则不用交换，如果不相同，则交换。
// 使用异或进行判断

//        Reverse bits of a given 32 bits unsigned integer.
//
//
//
//        Example 1:
//
//        Input: 00000010100101000001111010011100
//        Output: 00111001011110000010100101000000
//        Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//        Example 2:
//
//        Input: 11111111111111111111111111111101
//        Output: 10111111111111111111111111111111
//        Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
//
//
//        Note:
//
//        Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
//        In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
//
//
//        Follow up:
//
//        If this function is called many times, how would you optimize it?
public class Solution {
    public int reserseBits(int n) {
        for (int i = 0; i < 16; i++) {

            int maskLeft = 1 << 31 - i;
            int maskRight = 1 << i;
            // 两数相同，condition为true
            boolean condition = ((n & maskLeft) == maskLeft) ^ ((n & maskRight) == maskRight);
            // 如果不同，各自取反
            if (condition) {
                n ^= maskLeft;
                n ^= maskRight;
            }
        }

        return n;
    }
}
