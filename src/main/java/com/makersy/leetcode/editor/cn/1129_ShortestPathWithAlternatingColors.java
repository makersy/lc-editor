/**
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点
 * i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么
 * answer[x] = -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * <p>
 * <p>
 * Related Topics 广度优先搜索 图 👍 184 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

/*
r 0
b 1
r 2
b 3
r 1
b 2
 */
class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        //Solution solution = new ShortestPathWithAlternatingColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] res, rMin, bMin;
        Map<Integer, Set<Integer>> rMap, bMap;

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            res = new int[n];
            rMin = new int[n];
            bMin = new int[n];

            rMap = new HashMap<>(redEdges.length);
            bMap = new HashMap<>(blueEdges.length);

            Arrays.fill(rMin, Integer.MAX_VALUE);
            Arrays.fill(bMin, Integer.MAX_VALUE);

            for (var e : redEdges) {
                if(!rMap.containsKey(e[0])) rMap.put(e[0], new HashSet<>());
                rMap.get(e[0]).add(e[1]);
            }
            for (var e : blueEdges) {
                if(!bMap.containsKey(e[0])) bMap.put(e[0], new HashSet<>());
                bMap.get(e[0]).add(e[1]);
            }

            bfs(false, 0, 0);
            bfs(true, 0, 0);

            for (int i = 0; i < n; i++) {
                res[i] = rMin[i] == Integer.MAX_VALUE && bMin[i] == Integer.MAX_VALUE ? -1 : Math.min(rMin[i], bMin[i]);
            }

            return res;
        }

        private void bfs(boolean fromRed, int node, int idx) {
            if (fromRed) {
                if (idx >= rMin[node]) return;
                rMin[node] = idx;

                if(!rMap.containsKey(node)) return;

                for (int next : rMap.get(node)) {
                    bfs(false, next, idx + 1);
                }
            } else {
                if (idx >= bMin[node]) return;
                bMin[node] = idx;

                if(!bMap.containsKey(node)) return;
                for (int next : bMap.get(node)) {
                    bfs(true, next, idx + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}