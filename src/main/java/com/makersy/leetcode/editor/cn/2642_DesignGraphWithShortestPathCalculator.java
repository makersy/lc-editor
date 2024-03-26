/**
 * 给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为
 * edgeCosti 的边。
 * <p>
 * 请你实现一个 Graph 类：
 * <p>
 * <p>
 * Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。 addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost]
 * 。数据保证添加这条边之前对应的两个节 点之间没有有向边。 int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1
 * 。一条路径的代价是路径中所有边代价之和。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入： ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"] [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3,
 * 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]] 输出： [null, 6, -1, null, 6]
 * <p>
 * 解释： Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]); g.shortestPath(3, 2); // 返回 6 。从 3 到 2
 * 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 + 2 + 1 = 6 。 g.shortestPath(0, 3); // 返回 -1 。没有从 0 到 3 的路径。 g.addEdge([1, 3,
 * 4]); // 添加一条节点 1 到节点 3 的边，得到第二幅图。 g.shortestPath(0, 3); // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 100 0 <= edges.length <= n * (n - 1) edges[i].length == edge.length == 3 0 <= fromi, toi, from, to, node1,
 * node2 <= n - 1 1 <= edgeCosti, edgeCost <= 10⁶ 图中任何时候都不会有重边和自环。 调用 addEdge 至多 100 次。 调用 shortestPath 至多 100 次。
 * <p>
 * <p>
 * Related Topics 图 设计 最短路 堆（优先队列） 👍 45 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class DesignGraphWithShortestPathCalculator {

    public static void main(String[] args) {
        //Solution solution = new DesignGraphWithShortestPathCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Graph {

        private List<int[]>[] graph;

        public Graph(int n, int[][] edges) {
            graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<int[]>();
            }
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                int cost = edge[2];
                graph[x].add(new int[] {y, cost});
            }
        }

        public void addEdge(int[] edge) {
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];
            graph[x].add(new int[] {y, cost});
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            int[] dist = new int[graph.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[node1] = 0;
            pq.offer(new int[] {0, node1});
            while (!pq.isEmpty()) {
                int[] arr = pq.poll();
                int cost = arr[0], cur = arr[1];
                if (cur == node2) {
                    return cost;
                }
                for (int[] nextArr : graph[cur]) {
                    int next = nextArr[0], ncost = nextArr[1];
                    if (dist[next] > cost + ncost) {
                        dist[next] = cost + ncost;
                        pq.offer(new int[] {cost + ncost, next});
                    }
                }
            }
            return -1;
        }
    }

    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}