/**
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * <p>
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * <p>
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌
 * 溉的区域为 [i - ranges[i], i + ranges[i]] 。
 * <p>
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, ranges = [3,4,1,1,0,0]
 * 输出：1
 * 解释：
 * 点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3, ranges = [0,0,0,0]
 * 输出：-1
 * 解释：即使打开所有水龙头，你也无法灌溉整个花园。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁴
 * ranges.length == n + 1
 * 0 <= ranges[i] <= 100
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 215 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MinimumNumberOfTapsToOpenToWaterAGarden {
    public static void main(String[] args) {
        //Solution solution = new MinimumNumberOfTapsToOpenToWaterAGarden().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTaps(int n, int[] ranges) {
            int[] rightMost = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                int r = ranges[i];
                // 这样写可以在 i>r 时少写一个 max
                if (i > r) rightMost[i - r] = i + r; // 对于 i-r 来说，i+r 必然是它目前的最大值
                else rightMost[0] = Math.max(rightMost[0], i + r);
            }

            int ans = 0;
            int curRight = 0; // 已建造的桥的右端点
            int nextRight = 0; // 下一座桥的右端点的最大值
            for (int i = 0; i < n; ++i) { // 注意这里没有遍历到 n，因为它已经是终点了
                nextRight = Math.max(nextRight, rightMost[i]);
                if (i == curRight) { // 到达已建造的桥的右端点
                    if (i == nextRight) return -1; // 无论怎么造桥，都无法从 i 到 i+1
                    curRight = nextRight; // 造一座桥
                    ++ans;
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}