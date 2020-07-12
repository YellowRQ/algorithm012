package leetcode;

import org.junit.Test;
import structrue.ListNode;

/**
 * ClassName:MergeTwoLists
 * Package:leetcode
 * Description:
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  示例：
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 * @author:YellowRQ
 * @data:2020/7/12 1:12
 */
public class _21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    @Test
    public void solution() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        System.out.println(mergeTwoLists(l1, l2).print());
    }
}
