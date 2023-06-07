/**
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * <p>
 * <p>
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * <p>
 * <p>
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n == reward1.length == reward2.length <= 10⁵
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 * <p>
 * <p>
 * Related Topics 贪心 数组 排序 堆（优先队列） 👍 54 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MiceAndCheese {
    public static void main(String[] args) {
        //Solution solution = new MiceAndCheese().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int len = reward1.length;
            int[][] diff = new int[len][2];
            for (int i = 0; i < len; i++) {
                diff[i][0] = i;
                diff[i][1] = reward1[i] - reward2[i];
            }
            Arrays.sort(diff, (a, b) -> {
                if (a[1] == b[1]) {
                    return reward2[a[0]] - reward2[b[0]];
                } else return b[1] - a[1];
            });

            int res = 0;
            boolean[] flag = new boolean[len];
            for (int i = 0; i < k; i++) {
                res += reward1[diff[i][0]];
                flag[diff[i][0]] = true;
            }
            for (int i = 0; i < len; i++) {
                if (!flag[i]) {
                    res += reward2[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}