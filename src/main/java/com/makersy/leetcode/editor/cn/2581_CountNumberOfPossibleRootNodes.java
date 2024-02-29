/**
 * Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
 * <p>
 * Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
 * <p>
 * <p>
 * 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。 Bob 猜测树中 u 是 v 的 父节点 。
 * <p>
 * <p>
 * Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
 * <p>
 * Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
 * <p>
 * 给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
 * <p>
 * 输出：3 解释： 根为节点 0 ，正确的猜测为 [1,3], [0,1], [2,4] 根为节点 1 ，正确的猜测为 [1,3], [1,0], [2,4] 根为节点 2 ，正确的猜测为 [1,3], [1,0], [2,4]
 * 根为节点 3 ，正确的猜测为 [1,0], [2,4] 根为节点 4 ，正确的猜测为 [1,3], [1,0] 节点 0 ，1 或 2 为根时，可以得到 3 个正确的猜测。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
 * <p>
 * 输出：5 解释： 根为节点 0 ，正确的猜测为 [3,4] 根为节点 1 ，正确的猜测为 [1,0], [3,4] 根为节点 2 ，正确的猜测为 [1,0], [2,1], [3,4] 根为节点 3 ，正确的猜测为 [1,0],
 * [2,1], [3,2], [3,4] 根为节点 4 ，正确的猜测为 [1,0], [2,1], [3,2] 任何节点为根，都至少有 1 个正确的猜测。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * edges.length == n - 1 2 <= n <= 10⁵ 1 <= guesses.length <= 10⁵ 0 <= ai, bi, uj, vj <= n - 1 ai != bi uj != vj edges
 * 表示一棵有效的树。 guesses[j] 是树中的一条边。 guesses 是唯一的。 0 <= k <= guesses.length
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 哈希表 动态规划 👍 79 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CountNumberOfPossibleRootNodes {

    public static void main(String[] args) {
        //Solution solution = new CountNumberOfPossibleRootNodes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int cnt = 0, res = 0;

        int k;

        List<Integer>[] g;

        Set<Long> set;

        public int rootCount(int[][] edges, int[][] guesses, int k) {
            this.k = k;
            int n = edges.length + 1;
            g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<Integer>();
            }
            set = new HashSet<Long>();
            for (int[] v : edges) {
                g[v[0]].add(v[1]);
                g[v[1]].add(v[0]);
            }
            for (int[] v : guesses) {
                set.add(h(v[0], v[1]));
            }

            dfs(0, -1);
            redfs(0, -1, cnt);
            return res;
        }

        public long h(int x, int y) {
            return (long) x << 20 | y;
        }

        public void dfs(int x, int fat) {
            for (int y : g[x]) {
                if (y == fat) {
                    continue;
                }
                cnt += set.contains(h(x, y)) ? 1 : 0;
                dfs(y, x);
            }
        }

        public void redfs(int x, int fat, int cnt) {
            if (cnt >= k) {
                res++;
            }
            for (int y : g[x]) {
                if (y == fat) {
                    continue;
                }
                redfs(y, x, cnt - (set.contains(h(x, y)) ? 1 : 0) + (set.contains(h(y, x)) ? 1 : 0));
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}