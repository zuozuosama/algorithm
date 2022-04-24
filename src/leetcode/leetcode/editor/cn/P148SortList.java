package leetcode.leetcode.editor.cn;
//排序链表
////给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序

import dataStructure.linkedNode.ListNode;

public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST

    }


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
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) return null;
            ListNode slow = head, fast = head, pre = null;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (pre == null) return head;
            pre.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slow);
            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else if (left.val < right.val) {
                left.next = merge(left.next, right);
                return left;
            } else {
                right.next = merge(left, right.next);
                return right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}