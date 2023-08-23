/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * <p>
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * <p>
 * 子数组 是数组中一个连续且可能为空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,2,3,1,3], k = 3
 * 输出：3
 * 解释：最优的方案是删除下标 2 和下标 4 的元素。
 * 删除后，nums 等于 [1, 3, 3, 3] 。
 * 最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
 * 可以证明无法创建更长的等值子数组。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,2,2,1,1], k = 2
 * 输出：4
 * 解释：最优的方案是删除下标 2 和下标 3 的元素。
 * 删除后，nums 等于 [1, 1, 1, 1] 。
 * 数组自身就是等值子数组，长度等于 4 。
 * 可以证明无法创建更长的等值子数组。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= nums.length
 * 0 <= k <= nums.length
 * <p>
 * <p>
 * 👍 20 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

class FindTheLongestEqualSubarray {
    public static void main(String[] args) {
        //Solution solution = new FindTheLongestEqualSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            List<Integer>[] arr = new ArrayList[nums.size() + 1];
            Arrays.setAll(arr, e -> new ArrayList<>());


            int len = nums.size();
            for (int i = 0; i < len; i++) {
                int n = nums.get(i);
                arr[n].add(i);
            }

            int res = 1;
            for (var pos : arr) {
                if (pos.size() < res) {
                    continue;
                }
                int l = 0;
                for (int i = 1; i < pos.size(); i++) {
                    while (l < i && pos.get(i) - pos.get(l) - (i - l) > k) l++;
                    res = Math.max(i - l + 1, res);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}