//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2479 👎 0


package com.leetcode.editor.cn;

import java.util.PriorityQueue;

public class Q23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new Q23MergeKSortedLists().new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        lists[2] = new ListNode(2, new ListNode(6, null));
    
        ListNode listNode = solution.mergeKLists(lists);
        System.out.println(listNode);
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
    PriorityQueue<Status> queue = new PriorityQueue<>();
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll(); // 多链表中最小头节点
            tail.next = f.ptr; // 尾结点指向最小节点
            tail = tail.next; // 更新尾结点
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
    
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;
        
        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }
        
        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}