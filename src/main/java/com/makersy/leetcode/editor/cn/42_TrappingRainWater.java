/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= height[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4498 👎 0
 */

package com.makersy.leetcode.editor.cn;

class TrappingRainWater {
    public static void main(String[] args) {
        //Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            int[] lm = new int[len], rm = new int[len];

            for (int i = 1; i < len; i++) {
                lm[i] = Math.max(lm[i - 1], height[i - 1]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rm[i] = Math.max(rm[i + 1], height[i + 1]);
            }

            int res = 0;
            for (int i = 1; i < len - 1; i++) {
                int limit = Math.min(rm[i], lm[i]);
                if (height[i] < limit) {
                    res += limit - height[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}