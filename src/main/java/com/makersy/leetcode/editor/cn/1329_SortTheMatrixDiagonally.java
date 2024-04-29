/**
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][ 0] 开始的 矩阵对角线 将会经过
 * mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * <p>
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]] 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25, 68,4],[84,28,14,11,5,50]]
 * 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[ 84,28,75,33,55,68]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length n == mat[i].length 1 <= m, n <= 100 1 <= mat[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 排序 👍 124 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortTheMatrixDiagonally {

    public static void main(String[] args) {
        //Solution solution = new SortTheMatrixDiagonally().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] diagonalSort(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            List<List<Integer>> diag = new ArrayList<>(m + n);
            for (int i = 0; i < m + n; i++) {
                diag.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    diag.get(i - j + m).add(mat[i][j]);
                }
            }
            for (List<Integer> d : diag) {
                Collections.sort(d, Collections.reverseOrder());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = diag.get(i - j + m).removeLast();
                }
            }
            return mat;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}