import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName:Offer40GetLeastNumbers
 * Package:PACKAGE_NAME
 * Description: 最小k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *  示例 1：
 *  输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *  示例 2：
 *  输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  限制：
 *  0 <= k <= arr.length <= 10000
 *  0 <= arr[i] <= 10000
 * @author:YellowRQ
 * @data:2020/7/25 23:34
 */
public class Offer40GetLeastNumbers {

    /**
     * sort: nlogn
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }


    /**
     * 堆 nlogk
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return  heap.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void solution() {
        int[] arr = {3,2,1};
        int k = 2;
        int[] ints = getLeastNumbers3(arr, k);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
