import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * ClassName:_239MaxSlidingWindow
 * Package:PACKAGE_NAME
 * Description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *  返回滑动窗口中的最大值。
 *  进阶： 你能在线性时间复杂度内解决此题吗？
 *  示例:
 *  输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  提示：
 *  1 <= nums.length <= 10^5
 *  -10^4 <= nums[i] <= 10^4
 *  1 <= k <= nums.length
 * @author:YellowRQ
 * @data:2020/7/26 0:19
 */
public class _239MaxSlidingWindow {

    /**
     * 最大堆 O(NlogN)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < nums.length; i++) {
            int start = i - k;
            if (start >= 0) {
                maxHeap.remove(nums[start]);
            }
            maxHeap.offer(nums[i]);
            if (maxHeap.size() == k) {
                result[i - k + 1] = maxHeap.peek();
            }
        }
        return result;
    }

    /**
     * 双端队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    @Test
    public void solution() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
