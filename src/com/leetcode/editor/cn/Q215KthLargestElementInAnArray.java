//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2215 👎 0


package com.leetcode.editor.cn;
public class Q215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q215KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 堆排序
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > heap.array[0]) {
                heap.replace(nums[i]);
            }
        }
        return heap.array[0];
    }

    static class MinHeap {
        int[] array;
        int size;

        public MinHeap(int capacity) {
            this.array = new int[capacity];
        }

        /**
         * 替换堆顶元素
         *
         * @param replaced 新元素
         */
        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }

        /**
         * 堆的尾部添加元素
         *
         * @param offered 新元素
         * @return 是否添加成功
         */
        public boolean offer(int offered) {
            if (size == array.length) {
                return false;
            }
            up(offered);
            size++;
            return true;
        }

        // 将 offered 元素上浮: 直至 offered 大于父元素或到堆顶
        private void up(int offered) {
            int child = size;
            while (child > 0) {
                int parent = (child - 1) / 2;
                if (offered < array[parent]) {
                    array[child] = array[parent];
                } else {
                    break;
                }
                child = parent;
            }
            array[child] = offered;
        }

        // 将 parent 索引处的元素下潜: 与两个孩子较小者交换, 直至没孩子或孩子没它小
        private void down(int parent) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int min = parent;
            if (left < size && array[left] < array[min]) {
                min = left;
            }
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (min != parent) {
                swap(parent, min);
                down(min);
            }
        }

        // 交换两个索引处的元素
        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}