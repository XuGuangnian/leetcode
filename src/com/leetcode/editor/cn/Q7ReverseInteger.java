//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3856 👎 0


package com.leetcode.editor.cn;
public class Q7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Q7ReverseInteger().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        // 123
        // q    r
        // 12   3   0*10+3
        // 1    2   3*10+2
        // 0    1   32*10+1
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            // intMax: 2,147,483,647
            // 2147483640 + 7
            if (res > 214748364 || res == 214748364 && tmp > 7) {
                return 0;
            }
            // intMin: -2,147,483,648
            // -2147483640 - 8
            if (res < -214748364 || res == -214748364 && tmp < -8) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}