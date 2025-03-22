/**
 * 给你一个大小为 m x n 的二进制矩阵 mat ，请你找出包含最多 1 的行的下标（从 0 开始）以及这一行中 1 的数目。
 * <p>
 * 如果有多行包含最多的 1 ，只需要选择 行下标最小 的那一行。
 * <p>
 * 返回一个由行下标和该行中 1 的数量组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,0]] 输出：[0,1] 解释：两行中 1 的数量相同。所以返回下标最小的行，下标为 0 。该行 1 的数量为 1 。所以，答案为 [0,1] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,1]] 输出：[1,2] 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：mat = [[0,0],[1,1],[0,0]] 输出：[1,2] 解释：下标为 1 的行中 1 的数量最多。该行 1 的数量为 2 。所以，答案为 [1,2] 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length n == mat[i].length 1 <= m, n <= 100 mat[i][j] 为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 23 👎 0
 */

package com.makersy.leetcode.editor.cn;

class RowWithMaximumOnes {

    public static void main(String[] args) {
        //Solution solution = new RowWithMaximumOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] rowAndMaximumOnes(int[][] mat) {
            int maxOnes = 0;
            int rowIndex = 0;
            for (int i = 0; i < mat.length; i++) {
                int tot = 0;
                for (int j = 0; j < mat[i].length; j++) {
                    tot += mat[i][j];
                }
                if (tot > maxOnes) {
                    maxOnes = tot;
                    rowIndex = i;
                }
            }
            return new int[] {rowIndex, maxOnes};
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}