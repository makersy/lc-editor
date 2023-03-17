/**
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度 。
 * <p>
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 贪心 数组 二分查找 前缀和 排序 👍 82 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        //Solution solution = new LongestSubsequenceWithLimitedSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int len = nums.length;
            int[] arr = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                arr[i] = arr[i - 1] + nums[i - 1];
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i];
                int l = 1, r = len;
                int mid;
                while (l <= r) {
                    mid = (l + r + 1) / 2;
                    if (arr[mid] > q) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                res[i] = l-1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}