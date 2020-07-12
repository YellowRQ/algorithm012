package leetcode;

import structrue.ListNode;

/**
 * ClassName:_24SwapPairs
 * Package:leetcode
 * Description:
 *
 * @author:YellowRQ
 * @data:2020/7/12 22:54
 */
public class _24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
}
