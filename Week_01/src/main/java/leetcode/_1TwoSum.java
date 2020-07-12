package leetcode;

import org.junit.Test;
import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:TwoSum 两数之和
 * Package:leetcode
 * Description:
 *  给定一个整数数组 nums 和一个目标值 target，
 *  请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *  示例: 给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 * @author:YellowRQ
 * @data:2020/7/11 16:48
 */
public class _1TwoSum {

    /**
     * hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        int numsSize = nums.length;
        for (int i = 0; i < numsSize - 1; i++) {
            for (int j = i + 1; j < numsSize; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return new int[0];
    }

    @Test
    public void solution() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        PrintUtil.printArr(twoSum2(nums, target));
    }
}
