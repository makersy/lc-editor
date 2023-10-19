/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都
 * 是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10⁴
 * nums 中的所有元素 互不相同
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 84 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class TupleWithSameProduct {
    public static void main(String[] args) {
        // Solution solution = new TupleWithSameProduct().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int len = nums.length;
            Map<Integer, Integer> map = new HashMap(len * len);
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int temp = nums[i] * nums[j];
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }
            int res = 0;
            for (var e : map.entrySet()) {
                if (e.getValue() > 1) {
                    res += e.getValue() * (e.getValue() - 1) * 4;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}