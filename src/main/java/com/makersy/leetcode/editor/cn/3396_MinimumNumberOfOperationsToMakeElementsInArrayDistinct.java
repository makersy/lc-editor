/**
 * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
 * <p>
 * <p>
 * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
 * <p>
 * <p>
 * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： nums = [1,2,3,4,2,3,3,5,7]
 * <p>
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 2, 3, 3, 5, 7]。 第二次操作：再次移除前 3 个元素，数组变为 [3, 5, 7]，此时数组中的元素互不相同。
 * <p>
 * <p>
 * 因此，答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： nums = [4,5,6,4,4]
 * <p>
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * <p>
 * 第一次操作：移除前 3 个元素，数组变为 [4, 4]。 第二次操作：移除所有剩余元素，数组变为空。
 * <p>
 * <p>
 * 因此，答案是 2。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入： nums = [6,7,8,9]
 * <p>
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组中的元素已经互不相同，因此不需要进行任何操作，答案是 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100 1 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 27 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public static void main(String[] args) {
        //Solution solution = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumOperations(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i += 3, ans++) {
                if (checkUnique(nums, i)) {
                    return ans;
                }
            }
            return ans;
        }

        private boolean checkUnique(int[] nums, int start) {
            HashSet<Integer> cnt = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (cnt.contains(nums[i])) {
                    return false;
                }
                cnt.add(nums[i]);
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}