/**
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * <p>
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * <p>
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= price.length <= 10⁵
 * 1 <= price[i] <= 10⁹
 * 2 <= k <= price.length
 * <p>
 * <p>
 * Related Topics 数组 二分查找 排序 👍 120 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MaximumTastinessOfCandyBasket {
    public static void main(String[] args) {
        //Solution solution = new MaximumTastinessOfCandyBasket().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int left = 0, right = price[price.length - 1] - price[0];
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (check(price, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public boolean check(int[] price, int k, int tastiness) {
            int prev = Integer.MIN_VALUE / 2;
            int cnt = 0;
            for (int p : price) {
                if (p - prev >= tastiness) {
                    cnt++;
                    prev = p;
                }
            }
            return cnt >= k;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}