/**
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * <p>
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * <p>
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * <p>
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * <p>
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * <p>
 * 返回小偷的 最小 窃取能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * 1 <= k <= (nums.length + 1)/2
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 84 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class HouseRobberIv {
    public static void main(String[] args) {
        // Solution solution = new HouseRobberIv().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCapability(int[] nums, int k) {
            int lower = Arrays.stream(nums).min().getAsInt();
            int upper = Arrays.stream(nums).max().getAsInt();
            while (lower <= upper) {
                int middle = (lower + upper) / 2;
                int count = 0;
                boolean visited = false;
                for (int x : nums) {
                    if (x <= middle && !visited) {
                        count++;
                        visited = true;
                    } else {
                        visited = false;
                    }
                }
                if (count >= k) {
                    upper = middle - 1;
                } else {
                    lower = middle + 1;
                }
            }
            return lower;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}