import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_78Subsets
 * Package:PACKAGE_NAME
 * Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 *  说明：解集不能包含重复的子集。
 *  示例:
 *  输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author:yellowrq
 * @date: 2020/7/28 18:45
 */
public class _78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {
        //terminator
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        //not pick the number at this index
        dfs(ans, nums, list, index + 1);

        //pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);

        list.remove(list.size() - 1);
    }

    @Test
    public void test1(){
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets.toString());
    }
}
