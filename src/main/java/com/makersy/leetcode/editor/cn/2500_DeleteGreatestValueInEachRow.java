/**
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 * <p>
 * 执行下述操作，直到 grid 变为空矩阵：
 * <p>
 * <p>
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * <p>
 * <p>
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 * <p>
 * 返回执行上述操作后的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,4],[3,3,1]]
 * 输出：8
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 4 ，从第二行删除 3（注意，有两个单元格中的值为 3 ，我们可以删除任一）。在答案上加 4 。
 * - 在第二步操作中，从第一行删除 2 ，从第二行删除 3 。在答案上加 3 。
 * - 在第三步操作中，从第一行删除 1 ，从第二行删除 1 。在答案上加 1 。
 * 最终，答案 = 4 + 3 + 1 = 8 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[10]]
 * 输出：10
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 10 。在答案上加 10 。
 * 最终，答案 = 10 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 排序 👍 47 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class DeleteGreatestValueInEachRow {
    public static void main(String[] args) {
        // Solution solution = new DeleteGreatestValueInEachRow().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            for (var arr : grid) {
                Arrays.sort(arr);
            }
            int h = grid.length, w = grid[0].length;
            int res = 0, max;
            for (int j = w - 1; j >= 0; j--) {
                max = 0;
                for (int i = 0; i < h; i++) {
                    max = Math.max(max, grid[i][j]);
                }
                res += max;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}