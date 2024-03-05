/**
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路
 * 口之间最多有一条路。
 * <p>
 * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费
 * timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 * <p>
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10⁹ + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5
 * ,1],[0,4,5],[4,6,2]]
 * 输出：4
 * 解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
 * 四条花费 7 分钟的路径分别为：
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2, roads = [[1,0,10]]
 * 输出：1
 * 解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 10⁹
 * ui != vi
 * 任意两个路口之间至多有一条路。
 * 从任意路口出发，你能够到达其他任意路口。
 * <p>
 * <p>
 * Related Topics 图 拓扑排序 动态规划 最短路 👍 122 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        //Solution solution = new NumberOfWaysToArriveAtDestination().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPaths(int n, int[][] roads) {
            int mod = 1000000007;
            List<int[]>[] e = new List[n];
            for (int i = 0; i < n; i++) {
                e[i] = new ArrayList<int[]>();
            }
            for (int[] road : roads) {
                int x = road[0], y = road[1], t = road[2];
                e[x].add(new int[]{y, t});
                e[y].add(new int[]{x, t});
            }
            long[] dis = new long[n];
            Arrays.fill(dis, Long.MAX_VALUE);
            int[] ways = new int[n];

            PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0], b[0]));
            pq.offer(new long[]{0, 0});
            dis[0] = 0;
            ways[0] = 1;

            while (!pq.isEmpty()) {
                long[] arr = pq.poll();
                long t = arr[0];
                int u = (int) arr[1];
                if (t > dis[u]) {
                    continue;
                }
                for (int[] next : e[u]) {
                    int v = next[0], w = next[1];
                    if (t + w < dis[v]) {
                        dis[v] = t + w;
                        ways[v] = ways[u];
                        pq.offer(new long[]{t + w, v});
                    } else if (t + w == dis[v]) {
                        ways[v] = (ways[u] + ways[v]) % mod;
                    }
                }
            }
            return ways[n - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}