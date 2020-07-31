/**
 * ClassName:_50MyPow
 * Package:PACKAGE_NAME
 * Description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *  示例 1:
 *  输入: 2.00000, 10    输出: 1024.00000
 *  示例 2:
 *  输入: 2.10000, 3     输出: 9.26100
 *  示例 3:
 *  输入: 2.00000, -2    输出: 0.25000   解释: 2-2 = 1/22 = 1/4 = 0.25
 *  说明:
 *  -100.0 < x < 100.0
 *  n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @author:YellowRQ
 * @data:2020/7/27 1:24
 */
public class _50MyPow {

    /**
     * 递归 + 快速幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double sub = quickMul(x, N / 2);
        return N % 2 == 0 ? sub * sub : sub * sub * x;
    }

    public double myPow2(double x, int n) {
        if (x == 0.0) {
            return 1.0;
        }
        long N = n;
        double res = 1.0;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            if (N % 2 == 0) {
                res = res * x;
            }
            x = x * x;
            N  = N / 2;
        }
        return res;
    }
}
