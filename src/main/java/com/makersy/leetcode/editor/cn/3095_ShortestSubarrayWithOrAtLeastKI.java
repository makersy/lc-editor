/**
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * <p>
 * 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3], k = 2
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * <p>
 * 注意，[2] 也是一个特别子数组。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,1,8], k = 10
 * <p>
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2], k = 0
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 50 0 <= nums[i] <= 50 0 <= k < 64
 * <p>
 * <p>
 * Related Topics 位运算 数组 滑动窗口 👍 32 👎 0
 */

package com.makersy.leetcode.editor.cn;

class ShortestSubarrayWithOrAtLeastKI {

    public static void main(String[] args) {
        //Solution solution = new ShortestSubarrayWithOrAtLeastKI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumSubarrayLength(int[] nums, int k) {
            int[] cnt = new int[32];
            int[] kcnt = new int[32];
            mod(kcnt, k, true);
            int l = 0, r = 0;
            int res = -1;
            mod(cnt, nums[r], true);
            while (l <= r && r < nums.length) {
                if (gte(cnt, kcnt)) {
                    if (res == -1) {
                        res = r - l + 1;
                    } else {
                        res = Math.min(res, r - l + 1);
                    }
                    mod(cnt, nums[l], false);
                    l++;
                } else {
                    r++;
                    if (r < nums.length) {
                        mod(cnt, nums[r], true);
                    }
                }
            }
            return res;
        }

        private boolean gte(int[] cnt, int[] kcnt) {
            for (int i = 31; i >= 0; i--) {
                if (kcnt[i] == 1 && cnt[i] < kcnt[i]) {
                    return false;
                }
                if (kcnt[i] == 0 && cnt[i] > kcnt[i]) {
                    return true;
                }
            }
            return true;
        }

        private void mod(int[] cnt, int n, boolean add) {
            int idx = 0, bit = 0;
            while (n > 0) {
                bit = (n & 1);
                if (bit == 1) {
                    if (add) {
                        cnt[idx]++;
                    } else {
                        cnt[idx]--;
                    }
                }
                idx++;
                n >>= 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}