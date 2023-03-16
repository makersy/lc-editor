/**
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * <p>
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * <p>
 * 注意：
 * <p>
 * <p>
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * <p>
 * <p>
 * <p>
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * <p>
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁵
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 * <p>
 * <p>
 * Related Topics 数组 哈希表 前缀和 👍 149 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;

class CountSubarraysWithMedianK {
    public static void main(String[] args) {
        //Solution solution = new CountSubarraysWithMedianK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubarrays(int[] nums, int k) {
            int pos = 0, n = nums.length;
            while (nums[pos] != k) ++pos;

            var cnt = new HashMap<Integer, Integer>();
            // i=pos 的时候 x 是 0，直接记到 cnt 中，这样下面不是大于 k 就是小于 k
            cnt.put(0, 1);
            for (int i = pos - 1, x = 0; i >= 0; --i) { // 从 pos-1 开始累加 x
                x += nums[i] < k ? 1 : -1;
                cnt.merge(x, 1, Integer::sum);
            }

            // i=pos 的时候 x 是 0，直接加到答案中，这样下面不是大于 k 就是小于 k
            int ans = cnt.get(0) + cnt.getOrDefault(-1, 0);
            for (int i = pos + 1, x = 0; i < n; ++i) { // 从 pos+1 开始累加 x
                x += nums[i] > k ? 1 : -1;
                ans += cnt.getOrDefault(x, 0) + cnt.getOrDefault(x - 1, 0);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}