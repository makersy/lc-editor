/**
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 * <p>
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 * <p>
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 * <p>
 * <p>
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山脉 数组。
 * <p>
 * <p>
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 * <p>
 * <p>
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * <p>
 * <p>
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n == maxHeights <= 10⁵
 * 1 <= maxHeights[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 栈 数组 单调栈 👍 110 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class BeautifulTowersIi {
    public static void main(String[] args) {
        //Solution solution = new BeautifulTowersIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long res = 0;
            long[] prefix = new long[n];
            long[] suffix = new long[n];
            Deque<Integer> stack1 = new ArrayDeque<Integer>();
            Deque<Integer> stack2 = new ArrayDeque<Integer>();

            for (int i = 0; i < n; i++) {
                while (!stack1.isEmpty() && maxHeights.get(i) < maxHeights.get(stack1.peek())) {
                    stack1.pop();
                }
                if (stack1.isEmpty()) {
                    prefix[i] = (long) (i + 1) * maxHeights.get(i);
                } else {
                    prefix[i] = prefix[stack1.peek()] + (long) (i - stack1.peek()) * maxHeights.get(i);
                }
                stack1.push(i);
            }
            for (int i = n - 1; i >= 0; i--) {
                while (!stack2.isEmpty() && maxHeights.get(i) < maxHeights.get(stack2.peek())) {
                    stack2.pop();
                }
                if (stack2.isEmpty()) {
                    suffix[i] = (long) (n - i) * maxHeights.get(i);
                } else {
                    suffix[i] = suffix[stack2.peek()] + (long) (stack2.peek() - i) * maxHeights.get(i);
                }
                stack2.push(i);
                res = Math.max(res, prefix[i] + suffix[i] - maxHeights.get(i));
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}