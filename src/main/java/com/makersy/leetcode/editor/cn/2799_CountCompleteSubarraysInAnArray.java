/**
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * <p>
 * <p>
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * <p>
 * <p>
 * 返回数组中 完全子数组 的数目。
 * <p>
 * 子数组 是数组中的一个连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,2,2] 输出：4 解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,5,5] 输出：10 解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000 1 <= nums[i] <= 2000
 * <p>
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 85 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class CountCompleteSubarraysInAnArray {

    public static void main(String[] args) {
        //Solution solution = new CountCompleteSubarraysInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countCompleteSubarrays(int[] nums) {
            int res = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            int n = nums.length;
            int right = 0;
            int distinct = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();

            for (int left = 0; left < n; left++) {
                if (left > 0) {
                    int remove = nums[left - 1];
                    cnt.put(remove, cnt.get(remove) - 1);
                    if (cnt.get(remove) == 0) {
                        cnt.remove(remove);
                    }
                }
                while (right < n && cnt.size() < distinct) {
                    int add = nums[right];
                    cnt.put(add, cnt.getOrDefault(add, 0) + 1);
                    right++;
                }
                if (cnt.size() == distinct) {
                    res += (n - right + 1);
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}