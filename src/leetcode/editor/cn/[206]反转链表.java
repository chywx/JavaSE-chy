package leetcode.editor.cn;//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1667 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ListNode res = solution206.reverseList(listNode);
        System.out.println(res);

    }

    public ListNode reverseList(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode current = head;
        while (true) {
            if (current != null) {
                list.add(current.val);
                current = current.next;
                continue;
            }
            break;
        }
        System.out.println(list);

        ListNode listNode = null;
        for (Integer integer : list) {
            ListNode node = new ListNode(integer);
            node.next = listNode;
            listNode = node;
        }
        return listNode;

    }

//    public static class ListNode {
//
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
