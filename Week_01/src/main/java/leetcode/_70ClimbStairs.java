package leetcode;

import org.junit.Test;

/**
 * ClassName:_70ClimbStairs
 * Package:leetcode
 * Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *  注意：给定 n 是一个正整数。
 *  示例 1：
 *  输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *  示例 2：
 *  输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 斐波那契
 * @author:YellowRQ
 * @data:2020/7/12 22:48
 */
public class _70ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n < 0 ? 1 : n;
        }
        int f1 = 1,f2 = 2,f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n < 0 ? 1 : n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public int climbStairs4(int n) {
        if (n <= 2) {
            return n < 0 ? 1 : n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * O(logn)
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }


    @Test
    public void solution() {
        int n = 4;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs4(n));
    }
}
