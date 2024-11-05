/**
 * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
 * <p>
 * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名玩家 无法执行此操作，那么这名玩家 输掉 游戏。
 * <p>
 * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 2, y = 7
 * <p>
 * <p>
 * 输出："Alice"
 * <p>
 * 解释：
 * <p>
 * 游戏一次操作后结束：
 * <p>
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = 4, y = 11
 * <p>
 * <p>
 * 输出："Bob"
 * <p>
 * 解释：
 * <p>
 * 游戏 2 次操作后结束：
 * <p>
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= x, y <= 100
 * <p>
 * <p>
 * Related Topics 数学 博弈 模拟 👍 23 👎 0
 */

package com.makersy.leetcode.editor.cn;

class FindTheWinningPlayerInCoinGame {

    public static void main(String[] args) {
        //Solution solution = new FindTheWinningPlayerInCoinGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String losingPlayer(int x, int y) {
            return (Math.min(x, y / 4) & 1) == 0 ? "Bob" : "Alice";
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}