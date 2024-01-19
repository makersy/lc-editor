/**
 * 给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[i]
 * 的值都增加 nums2[i] 。操作 完成后 ，你可以进行如下操作：
 * <p>
 * <p>
 * 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。
 * <p>
 * <p>
 * 同时给你一个整数 x 。
 * <p>
 * 请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [1,2,3], x = 4
 * 输出：3
 * 解释：
 * 第 1 秒，我们对 i = 0 进行操作，得到 nums1 = [0,2+2,3+3] = [0,4,6] 。
 * 第 2 秒，我们对 i = 1 进行操作，得到 nums1 = [0+1,0,6+3] = [1,0,9] 。
 * 第 3 秒，我们对 i = 2 进行操作，得到 nums1 = [1+1,0+2,0] = [2,2,0] 。
 * 现在 nums1 的和为 4 。不存在更少次数的操作，所以我们返回 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [3,3,3], x = 4
 * 输出：-1
 * 解释：不管如何操作，nums1 的和总是会超过 x 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length <= 10³
 * 1 <= nums1[i] <= 10³
 * 0 <= nums2[i] <= 10³
 * nums1.length == nums2.length
 * 0 <= x <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 动态规划 排序 👍 94 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MinimumTimeToMakeArraySumAtMostX {
    public static void main(String[] args) {
        //Solution solution = new MinimumTimeToMakeArraySumAtMostX().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
            int n = nums1.size(), s1 = 0, s2 = 0;
            int[][] dp = new int[n + 1][n + 1];
            List<List<Integer>> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = nums1.get(i), b = nums2.get(i);
                nums.add(Arrays.asList(b, a));
                s1 += a;
                s2 += b;
            }
            Collections.sort(nums, (o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));

            for (int j = 1; j <= n; ++j) {
                int b = nums.get(j - 1).get(0), a = nums.get(j - 1).get(1);
                for (int i = j; i > 0; --i) {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - 1] + i * b + a);
                }
            }
            for (int i = 0; i <= n; i++) {
                if (s2 * i + s1 - dp[n][i] <= x) {
                    return i;
                }
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}