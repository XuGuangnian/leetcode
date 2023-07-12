//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1723 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Q102BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
    
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode treeNode = queue.removeFirst();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    c2++;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    c2++;
                }
            }
            c1 = c2;
            result.add(level);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}