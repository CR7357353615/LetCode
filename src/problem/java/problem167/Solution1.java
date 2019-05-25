package problem.java.problem167;

/**
 * 给定排序数组和目标值，返回两个索引，这两个索引对应数组值相加等于目标值
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 解题思路：头尾向中间逼近对比
 *
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
       int[] result = new int[2];
       int start = 0;
       int end = numbers.length - 1;
       while (start < end) {
           if (numbers[start] + numbers[end] == target) {
               result[0] = start + 1;
               result[1] = end + 1;
               return result;
           }
           if (numbers[start] + numbers[end] < target) {
               start++;
           } else {
               end--;
           }
       }
       return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 18);
        System.out.println(result);
    }
}
