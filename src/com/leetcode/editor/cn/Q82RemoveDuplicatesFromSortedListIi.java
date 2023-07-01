// 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
// 
// 
// 输入：head = [1,2,3,3,4,4,5]
// 输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
// 输入：head = [1,1,1,2,3]
// 输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1140 👎 0


package com.leetcode.editor.cn;

public class Q82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Q82RemoveDuplicatesFromSortedListIi().new Solution();
        // ListNode head = ListNode.of(1, 1, 1, 2, 3);
        // ListNode head = ListNode.of(1, 1, 1);
        ListNode head = ListNode.of(1, 2, 3, 3, 4, 4, 5);
        System.out.println(solution.deleteDuplicates(head));
    }
    // leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode s = new ListNode(-101, head);
            ListNode p1 = s;
            ListNode p2, p3;
            while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
                if (p3.val == p2.val) {
                    while ((p3 = p3.next) != null && p3.val == p2.val) {
                    }
                    p1.next = p3;
                } else {
                    p1 = p1.next;
                }
            }
            return s.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}