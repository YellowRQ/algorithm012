import org.junit.Test;

import java.util.*;

/**
 * ClassName:_347TopKFrequent
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *  示例 1:
 *  输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *  示例 2:
 *  输入: nums = [1], k = 1
 * 输出: [1]
 *  提示：
 *  你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *  你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *  题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *  你可以按任意顺序返回答案。
 * @author:YellowRQ
 * @data:2020/7/26 15:27
 */
public class _347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> countMap = new HashMap<>();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        for (Integer key : countMap.keySet()) {
            if (maxHeap.size() < k) {
                maxHeap.add(key);
            } else if (countMap.get(key) > countMap.get(maxHeap.peek())) {
                maxHeap.remove();
                maxHeap.add(key);
            }
        }
        //取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Integer remove = maxHeap.remove();
            res[i++] = remove;
        }
        return res;
    }

    /**
     * 双端队列时间复杂度：O(n)，n 表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)；
     * 桶的数量为 n + 1，所以桶排序的时间复杂度为 O(n)；因此，总的时间复杂度是 O(n)。
     * 空间复杂度：很明显为 O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap
                = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            maxHeap.offer(m);
        }
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }

    @Test
    public void solution() {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = topKFrequent(arr, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
