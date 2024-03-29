/**
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * <p>
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * <p>
 * <p>
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * <p>
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 3² + 4² = 25
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 1² + 8² = 65
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= commands.length <= 10⁴
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 10⁴
 * -3 * 10⁴ <= xi, yi <= 3 * 10⁴
 * 答案保证小于 2³¹
 * <p>
 * <p>
 * Related Topics 数组 模拟 👍 213 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WalkingRobotSimulation {
    public static void main(String[] args) {
        // Solution solution = new WalkingRobotSimulation().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            int px = 0, py = 0, d = 1;

            Set<List<Integer>> set = new HashSet<>();
            for (int[] obstacle : obstacles) {
                set.add(List.of(obstacle[0], obstacle[1]));
            }
            int res = 0;
            for (int c : commands) {
                if (c < 0) {
                    d += c == -1 ? 1 : -1;
                    d %= 4;
                    if (d < 0) {
                        d += 4;
                    }
                } else {
                    for (int i = 0; i < c; i++) {
                        if (set.contains(List.of(px + dirs[d][0], py + dirs[d][1]))) {
                            break;
                        }
                        px += dirs[d][0];
                        py += dirs[d][1];
                        res = Math.max(res, px * px + py * py);
                    }
                }
            }
            return res;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}