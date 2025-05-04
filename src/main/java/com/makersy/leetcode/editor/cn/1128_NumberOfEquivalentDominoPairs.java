/**
 * 给你一组多米诺骨牌 dominoes 。
 * <p>
 * 形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 ( a == d 且 b == c) 。即一张骨牌可以通过旋转 0 度或 180
 * 度得到另一张多米诺骨牌。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]] 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]] 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= dominoes.length <= 4 * 10⁴ dominoes[i].length == 2 1 <= dominoes[i][j] <= 9
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 👍 181 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {
        //Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numEquivDominoPairs(int[][] dominoes) {
            int[] num = new int[100];
            int ret = 0;
            for (int[] domino : dominoes) {
                int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
                ret += num[val];
                num[val]++;
            }
            return ret;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}