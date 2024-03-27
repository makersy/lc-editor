/**
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都 包含在第 i 个区间中。
 * <p>
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 * <p>
 * <p>
 * 每个区间只属于一个组。 两个有 交集 的区间必须在 同一个 组内。
 * <p>
 * <p>
 * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 * <p>
 * <p>
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * <p>
 * <p>
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 10⁹ + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[6,10],[5,15]] 输出：2 解释： 两个区间有交集，所以它们必须在同一个组内。 所以有两种方案： - 将两个区间都放在第 1 个组中。 - 将两个区间都放在第 2 个组中。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,3],[10,20],[2,5],[4,8]] 输出：4 解释： 区间 [1,3] 和 [2,5] 有交集，所以它们必须在同一个组中。 同理，区间 [2,5] 和 [4,8]
 * 也有交集，所以它们也必须在同一个组中。 所以总共有 4 种分组方案： - 所有区间都在第 1 组。 - 所有区间都在第 2 组。 - 区间 [1,3] ，[2,5] 和 [4,8] 在第 1 个组中，[10,20] 在第 2 个组中。
 * - 区间 [1,3] ，[2,5] 和 [4,8] 在第 2 个组中，[10,20] 在第 1 个组中。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= ranges.length <= 10⁵ ranges[i].length == 2 0 <= starti <= endi <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 53 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CountWaysToGroupOverlappingRanges {

    public static void main(String[] args) {
        //Solution solution = new CountWaysToGroupOverlappingRanges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static final int MOD = 1000000007;

        public int countWays(int[][] ranges) {
            Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
            int n = ranges.length;
            int res = 1;
            for (int i = 0; i < n; ) {
                int r = ranges[i][1];
                int j = i + 1;
                while (j < n && ranges[j][0] <= r) {
                    r = Math.max(r, ranges[j][1]);
                    j++;
                }
                res = res * 2 % MOD;
                i = j;
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}