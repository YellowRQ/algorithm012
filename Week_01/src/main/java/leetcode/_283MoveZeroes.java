package leetcode;

import org.junit.Test;
import util.PrintUtil;

/**
 * ClassName:MoveZeroes
 * Package:leetcode
 * Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *  示例:
 *  输入: [0,1,0,3,12]    输出: [1,3,12,0,0]
 *  说明:
 *  必须在原数组上操作，不能拷贝额外的数组。  尽量减少操作次数。
 * @author:YellowRQ
 * @data:2020/7/12 1:31
 */
public class _283MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //j记录非0元素位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    @Test
    public void solution() {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        PrintUtil.printArr(arr);
    }
}
