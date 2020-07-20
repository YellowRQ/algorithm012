package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * ClassName:ThreeSum
 * Package:leetcode
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *  注意：答案中不可以包含重复的三元组。
 *  示例： 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *  Related Topics 数组 双指针
 * @author:YellowRQ
 * @data:2020/7/12 21:50
 */
public class _15ThreeSum {

    /**
     * 暴力 三重循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        //n*logn
        Arrays.sort(nums);
        //判重
        Set<List<Integer>> result = new LinkedHashSet<>();
        //三重循环
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     *  两次循环 + hash
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 夹逼法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        //1.排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            //2.因为nums[j]>=nums[i]>=nums[k]>0,即3个数字都大于0,在此固定指针k之后不可能再找到结果了
            if(nums[k] > 0) break;
            //当k>0且nums[k]==nums[k-1]时即跳过此元素nums[k]：
            //3.去重，因为已经将nums[k-1]的所有组合加入到结果中,本次双指针搜索只会得到重复组合。
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            //i左指针，j右指针
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){ //和小于0，左指针右移
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {//和大于0，右指针左移
                    while(i < j && nums[j] == nums[--j]);
                } else {//和=0
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    /**
     * 夹逼
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]){
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo++] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi--] == nums[hi - 1]) {
                            hi--;
                        }
                    } else if (nums[lo] + nums[hi] < sum){
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum5(int[] nums) {
            List<List<Integer>> ans = new ArrayList();
            int len = nums.length;
            if(nums == null || len < 3) return ans;
            Arrays.sort(nums); // 排序
            for (int i = 0; i < len ; i++) {
                if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
                int L = i+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] + nums[L] + nums[R];
                    if(sum == 0){
                        ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[++L]) ; // 去重
                        while (L<R && nums[R] == nums[--R]) ; // 去重
                    }
                    else if (sum < 0) L++;
                    else if (sum > 0) R--;
                }
            }
            return ans;
    }

    @Test
    public void solution() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum5(nums);
        System.out.println(lists.toString());
    }
}
