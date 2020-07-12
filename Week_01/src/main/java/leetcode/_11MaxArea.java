package leetcode;

import org.junit.Test;
import util.PrintUtil;

/**
 * ClassName:MaxArea
 * Package:leetcode 11
 * Description:
 * //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * //ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * //
 * // 说明：你不能倾斜容器，且 n 的值至少为 2。
 * //
 * //
 * // 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * //
 * // 示例：   输入：[1,8,6,2,5,4,8,3,7] 输出：49
 * @author:YellowRQ
 * @data:2020/7/12 17:16
 */
public class _11MaxArea {

    /**
     * O(n) 左右边界i,j向中间收敛
     * 左右夹逼
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            //谁小挪谁
            int minHight = height[i] > height[j] ? height[j--] : height[i++];
            int area = (j - i + 1) * minHight;
            max = Math.max(area, max);
        }
        return max;
    }

    /**
     * 一维数组坐标变换
     * 枚举 - left bar x, right bar y, (x-y)*hight_min
     * O(n^2)
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;
        //遍历有左右边界数组，且不重复
        for (int i = 0; i < height.length - 1 ; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    @Test
    public void solution() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height));
        System.out.println(maxArea(height));
    }
}
