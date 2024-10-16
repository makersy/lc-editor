/**
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * <p>
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * <p>
 * 返回可以实现的三角形的 最大 高度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： red = 2, blue = 4
 * <p>
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： red = 2, blue = 1
 * <p>
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入： red = 1, blue = 1
 * <p>
 * <p>
 * 输出： 1
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入： red = 10, blue = 1
 * <p>
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= red, blue <= 100
 * <p>
 * <p>
 * Related Topics 数组 枚举 👍 23 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximumHeightOfATriangle {

    public static void main(String[] args) {
        //Solution solution = new MaximumHeightOfATriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeightOfTriangle(int red, int blue) {
            return Math.max(maxHeight(red, blue), maxHeight(blue, red));
        }

        public int maxHeight(int x, int y) {
            int odd = 2 * (int)(Math.sqrt(x)) - 1;
            int even = 2 * (int)((-1 + Math.sqrt(1 + 4 * y)) / 2);
            return Math.min(odd, even) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}