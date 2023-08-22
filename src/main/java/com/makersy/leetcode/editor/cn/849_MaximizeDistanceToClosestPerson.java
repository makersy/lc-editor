/**
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从
 * 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= seats.length <= 2 * 10⁴
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 * <p>
 * <p>
 * Related Topics 数组 👍 260 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        //Solution solution = new MaximizeDistanceToClosestPerson().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int res = 1, len = seats.length;
            int l1 = -1, r1 = -1, pre1 = -1;
            for (int i = 0; i < len; i++) {
                if (seats[i] == 1) {
                    if (l1 == -1) l1 = i;
                    r1 = i;
                    if (pre1 != -1) {
                        res = Math.max(res, (i - pre1) / 2);
                    }
                    pre1 = i;
                }
            }
            if (l1 != 0) res = Math.max(res, l1);
            if (r1 != len - 1) res = Math.max(res, len - r1 - 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}