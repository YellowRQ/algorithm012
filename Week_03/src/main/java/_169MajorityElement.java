import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:_169MajorityElement
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *  示例 1:
 *  输入: [3,2,3]
 * 输出: 3
 *
 *  示例 2:
 *  输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @author:yellowrq
 * @date: 2020/7/30 10:31
 */
public class _169MajorityElement {

    /**
     * 哈希表 logn
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer num : map.keySet()) {
            if (map.get(num) > nums.length / 2 && num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 直接排序 nlogn
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
           return nums[0];
        }
        ans(nums,0);
        
        //terminator
        //process split problem
        //drill down
        //merge
        //reverse status
        return 0;
    }

    private void ans(int[] nums, int i) {
    }

    public int majorityElement3(int[] nums) {
        Integer result = null;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag == 0) {
                result = nums[i];
            }
            if (nums[i] == result) {
                flag++;
            } else {
                flag--;
            }
        }
        return result;
    }
}
