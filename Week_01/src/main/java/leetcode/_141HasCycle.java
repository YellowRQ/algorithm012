package leetcode;

import structrue.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:_141HasCycle
 * Package:leetcode
 * Description:
 *  给定一个链表，判断链表中是否有环。
 *  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *  如果 pos 是 -1，则在该链表中没有环。
 *  示例 1：
 *  输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *  示例 2：
 *  输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *  示例 3：
 *  输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  进阶：
 *  你能用 O(1)（即，常量）内存解决此问题吗？
 *  Related Topics 链表 双指针
 * @author:YellowRQ
 * @data:2020/7/12 22:57
 */
public class _141HasCycle {

    /**
     * 暴力
     * 时间复杂度：O(n)对于含有n个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费O(1)的时间。
     * 空间复杂度：O(n) 空间取决于添加到哈希表中的元素数目，最多可以添加 n个元素。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
