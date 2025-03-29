/**
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。
 * <p>
 * 图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[ i] == -1 。
 * <p>
 * 请你返回图中的 最长 环，如果没有任何环，请返回 -1 。
 * <p>
 * 一个环指的是起点和终点是 同一个 节点的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：edges = [3,3,4,2,3] 输出去：3 解释：图中的最长环是：2 -> 4 -> 3 -> 2 。 这个环的长度为 3 ，所以返回 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：edges = [2,-1,3,1] 输出：-1 解释：图中没有任何环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == edges.length 2 <= n <= 10⁵ -1 <= edges[i] < n edges[i] != i
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 69 👎 0
 */

package com.makersy.leetcode.editor.cn;

class LongestCycleInAGraph {

    public static void main(String[] args) {
        //Solution solution = new LongestCycleInAGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestCycle(int[] edges) {
            int n = edges.length;
            int ans = -1;
            int curTime = 1; // 当前时间
            int[] visTime = new int[n]; // 首次访问 x 的时间
            for (int i = 0; i < n; i++) {
                int x = i;
                int startTime = curTime; // 本轮循环的开始时间
                while (x != -1 && visTime[x] == 0) { // 没有访问过 x
                    visTime[x] = curTime++; // 记录访问 x 的时间
                    x = edges[x]; // 访问下一个节点
                }
                if (x != -1 && visTime[x] >= startTime) { // x 在本轮循环中访问了两次，说明 x 在环上
                    ans = Math.max(ans, curTime - visTime[x]); // 前后两次访问 x 的时间差，即为环长
                }
            }
            return ans; // 如果没有找到环，返回的是 ans 的初始值 -1
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}