/**
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向
 * 边。
 * <p>
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 * <p>
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 * <p>
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * 输出：3
 * 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * 输出：0
 * 解释：有 3 个三元组：
 * 1) [1,4,3]，度数为 0 。
 * 2) [2,5,6]，度数为 2 。
 * 3) [5,6,7]，度数为 2 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 图中没有重复的边。
 * <p>
 * <p>
 * Related Topics 图 👍 80 👎 0
 */

package com.makersy.leetcode.editor.cn;

class MinimumDegreeOfAConnectedTrioInAGraph {
    public static void main(String[] args) {
        // Solution solution = new MinimumDegreeOfAConnectedTrioInAGraph().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            boolean[][] g = new boolean[n][n];
            int[] deg = new int[n];
            for (var e : edges) {
                int u = e[0] - 1, v = e[1] - 1;
                g[u][v] = true;
                g[v][u] = true;
                ++deg[u];
                ++deg[v];
            }
            int ans = 1 << 30;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (g[i][j]) {
                        for (int k = j + 1; k < n; ++k) {
                            if (g[i][k] && g[j][k]) {
                                ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                            }
                        }
                    }
                }
            }
            return ans == 1 << 30 ? -1 : ans;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}