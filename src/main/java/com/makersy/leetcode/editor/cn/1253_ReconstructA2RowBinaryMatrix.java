/**
 * 给你一个 2 行 n 列的二进制数组：
 * <p>
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * <p>
 * <p>
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 * <p>
 * <p>
 * Related Topics 贪心 数组 矩阵 👍 64 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ReconstructA2RowBinaryMatrix {
    public static void main(String[] args) {
        // Solution solution = new ReconstructA2RowBinaryMatrix().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> res = new ArrayList<>();
            int len = colsum.length, sum = 0, col2cnt = 0;
            for(var n : colsum) {
                sum += n;
                if(n == 2) col2cnt++;
            }
            if(sum != upper + lower || col2cnt > upper || col2cnt > lower) return res;

            List<Integer> uList = new ArrayList<>(len);
            List<Integer> lList = new ArrayList<>(len);
            upper -= col2cnt;

            for (int n : colsum) {
                if(n == 0){
                    uList.add(0);
                    lList.add(0);
                } else if (n == 1) {
                    if (upper-- > 0) {
                        uList.add(1);
                        lList.add(0);
                    } else {
                        uList.add(0);
                        lList.add(1);
                    }
                } else {
                    uList.add(1);
                    lList.add(1);
                }
            }
            res.add(uList);
            res.add(lList);

            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}