/**
 * 在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
 * <p>
 * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
 * <p>
 * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该
 * 石子都仍然会是端点石子。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_
 * moves] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[7,4,9]
 * 输出：[1,2]
 * 解释：
 * 我们可以移动一次，4 -> 8，游戏结束。
 * 或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[6,5,4,3,10]
 * 输出：[2,3]
 * 解释：
 * 我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
 * 或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
 * 注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：[100,101,104,102,103]
 * 输出：[0,0]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= stones.length <= 10^4
 * 1 <= stones[i] <= 10^9
 * stones[i] 的值各不相同。
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 数学 双指针 排序 👍 182 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class MovingStonesUntilConsecutiveIi {
    public static void main(String[] args) {
        //Solution solution = new MovingStonesUntilConsecutiveIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            int n = stones.length;
            Arrays.sort(stones);
            if (stones[n - 1] - stones[0] + 1 == n) {
                return new int[]{0, 0};
            }
            int ma = Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
            int mi = n;
            for (int i = 0, j = 0; i < n && j + 1 < n; ++i) {
                while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                    ++j;
                }
                if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                    mi = Math.min(mi, 2);
                } else {
                    mi = Math.min(mi, n - (j - i + 1));
                }
            }
            return new int[]{mi, ma};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}