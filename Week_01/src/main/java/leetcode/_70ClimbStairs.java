package leetcode;

/**
 * ClassName:_70ClimbStairs
 * Package:leetcode
 * Description:
 *
 * @author:YellowRQ
 * @data:2020/7/12 22:48
 */
public class _70ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
