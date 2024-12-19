/**
 * 有 n 座山排成一列，每座山都有一个高度。给你一个整数数组 height ，其中 height[i] 表示第 i 座山的高度，再给你一个整数 threshold 。
 * <p>
 * 对于下标不为 0 的一座山，如果它左侧相邻的山的高度 严格大于 threshold ，那么我们称它是 稳定 的。我们定义下标为 0 的山 不是 稳定的。
 * <p>
 * 请你返回一个数组，包含所有 稳定 山的下标，你可以以 任意 顺序返回下标数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：height = [1,2,3,4,5], threshold = 2
 * <p>
 * <p>
 * 输出：[3,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * 下标为 3 的山是稳定的，因为 height[2] == 3 大于 threshold == 2 。 下标为 4 的山是稳定的，因为 height[3] == 4 大于 threshold == 2.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [10,1,10,1,10], threshold = 3
 * <p>
 * <p>
 * 输出：[1,3]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：height = [10,1,10,1,10], threshold = 10
 * <p>
 * <p>
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n == height.length <= 100 1 <= height[i] <= 100 1 <= threshold <= 100
 * <p>
 * <p>
 * Related Topics 数组 👍 16 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class FindIndicesOfStableMountains {

    public static void main(String[] args) {
        //Solution solution = new FindIndicesOfStableMountains().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> stableMountains(int[] height, int threshold) {
            int len = height.length;
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < len; i++) {
                if (height[i - 1] > threshold) {
                    res.add(i);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}