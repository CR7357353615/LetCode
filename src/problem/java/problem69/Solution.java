package problem.java.problem69;

/**
 * 实现开方
 *
 * 解题思路：二分法查找
 */
public class Solution {
    public int mySqrt(int x) {
        if(x == 1) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
       return sqrt(0,x-1,x);
}
    private int sqrt(int left, int right,int x){
        if (right > 46340) {
            right = 46340;
            if (right * right < x) {
                return right;
            }
        }
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                if(((mid + 1) * (mid + 1) > x)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }
}
