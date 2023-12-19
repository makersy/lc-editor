/**
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [
 * i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 10⁵
 * 任意两个相邻元素均不相等.
 * <p>
 * <p>
 * Related Topics 数组 二分查找 矩阵 👍 148 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FindAPeakElementIi {
    public static void main(String[] args) {
        //Solution solution = new FindAPeakElementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int left = 0, right = mat.length - 2;
            while (left <= right) {
                int i = (left + right) >>> 1;
                int j = indexOfMax(mat[i]);
                if (mat[i][j] > mat[i + 1][j]) {
                    right = i - 1; // 峰顶行号 <= i
                } else {
                    left = i + 1; // 峰顶行号 > i
                }
            }
            return new int[]{left, indexOfMax(mat[left])};
        }

        private int indexOfMax(int[] a) {
            int idx = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > a[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}