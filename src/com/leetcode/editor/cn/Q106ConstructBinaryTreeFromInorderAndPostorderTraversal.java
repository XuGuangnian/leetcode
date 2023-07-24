//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1057 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        // 3
        // 9    15,20,7
        // 9    15,7,20
        if (inorder.length == 0) {
            return null;
        }
        int length = postorder.length;
        int rootValue = postorder[length - 1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < length; i++) {
            if (rootValue == inorder[i]) {
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, length);

                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}