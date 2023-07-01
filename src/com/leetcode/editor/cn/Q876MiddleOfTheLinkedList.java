//给你单链表的头结点 head ，请你找出并返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 链表 双指针 👍 904 👎 0


package com.leetcode.editor.cn;
public class Q876MiddleOfTheLinkedList{
    public static void main(String[] args) {
        Solution solution = new Q876MiddleOfTheLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}