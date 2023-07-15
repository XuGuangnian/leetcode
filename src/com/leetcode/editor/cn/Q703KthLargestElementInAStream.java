//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
//
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 438 👎 0


package com.leetcode.editor.cn;
public class Q703KthLargestElementInAStream {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    MinHeap heap;
    public KthLargest(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.array[0]) {
            heap.replace(val);
        }
        return heap.array[0];
    }

    static class MinHeap {
        int[] array;
        int size;

        public MinHeap(int capacity) {
            this.array = new int[capacity];
        }

        public boolean isFull() {
            return size == array.length;
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

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}