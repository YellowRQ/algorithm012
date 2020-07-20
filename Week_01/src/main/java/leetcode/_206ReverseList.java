package leetcode;

import org.junit.Test;
import structrue.ListNode;

/**
 * ClassName:_206ReverseList
 * Package:leetcode
 * Description:
 * 反转一个单链表。
 *  示例:
 *  输入: 1->2->3->4->5->NULL
 *  输出: 5->4->3->2->1->NULL
 *  进阶:你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author:yellowrq
 * @date: 2020/7/14 15:08
 */
public class _206ReverseList {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next  = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    @Test
    public void solution() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reverseList(l1).print();
        reverseList2(l1).print();
    }
}
