package problem.java.problem167;

/**
 * 给定排序数组和目标值，返回两个索引，这两个索引对应数组值相加等于目标值
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 解题思路：遍历对比 笨办法
 *
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
       return getResult(0, numbers, target);
    }

    private int[] getResult(int i, int[] numbers, int target) {
        if (i > numbers.length - 1) {
            return null;
        }
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            if (numbers[i] + numbers[j] > target) {
                return getResult(i + 1, numbers, target);
            }
        }
        return getResult(i + 1, numbers, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{2, 7, 11, 15}, 18);
    }
}
