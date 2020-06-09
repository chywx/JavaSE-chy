package leetcode.editor.cn;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution21 {

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(6)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(5)));
        System.out.println(solution.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);

        while (true) {
            if (l1 == null) {
                ListNode lastNode = getLast(listNode);
                lastNode.next = l2;
                return listNode.next;
            }
            if (l2 == null) {
                ListNode lastNode = getLast(listNode);
                lastNode.next = l1;
                return listNode.next;
            }
            int val1 = l1.val;
            int val2 = l2.val;

            if (val1 < val2) {
                ListNode lastNode = getLast(listNode);
                lastNode.next = new ListNode(val1);
                l1 = l1.next;
            } else {
                ListNode lastNode = getLast(listNode);
                lastNode.next = new ListNode(val2);
                l2 = l2.next;
            }
        }

    }

    ListNode getLast(ListNode listNode) {
        ListNode nextNode = listNode.next;
        while (nextNode != null) {
            listNode = nextNode;
            nextNode = nextNode.next;
        }
        return listNode;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
