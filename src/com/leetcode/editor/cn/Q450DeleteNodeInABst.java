//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 1186 👎 0


package com.leetcode.editor.cn;
public class Q450DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new Q450DeleteNodeInABst().new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(6,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null)));
        TreeNode root2 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(2, null, null),
                        null),
                null);
        System.out.println(solution.deleteNode(root2, 5));
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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null) {
            if (key < node.val) {
                parent = node;
                node = node.left;
            } else if (key > node.val) {
                parent = node;
                node = node.right;
            } else {
                break;
            }
        }
        if (node == null) {
            return root;
        }
        if (node.left == null) {
            // 没有左孩子（或者没有孩子）
            return shift(root, parent, node, node.right);
        }
        if (node.right == null) {
            // 没有右孩子
            return shift(root, parent, node, node.left);
        }
        // 左右孩子都有
        // 找后继结点s
        TreeNode s = node.right;
        TreeNode sParent = node;
        while (s.left != null) {
            sParent = s;
            s = s.left;
        }
        if (node.right != s) {
            sParent.left = s.right;
            s.right = node.right;
        }
        root = shift(root, parent, node, s);
        s.left = node.left;
        return root;
    }
    /*
                 4
               /   \
              2     6
             / \   / \
            1   3 5   7
     */

    private TreeNode shift(TreeNode root, TreeNode parent, TreeNode deleted, TreeNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}