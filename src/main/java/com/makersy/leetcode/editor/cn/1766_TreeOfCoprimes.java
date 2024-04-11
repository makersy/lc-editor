/**
 * 给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 号点 。
 * <p>
 * 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边。
 * <p>
 * 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
 * <p>
 * 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
 * <p>
 * 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 ，如 果不存在这样的祖先节点，ans[i] 为 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]] 输出：[-1,0,0,1] 解释：上图中，每个节点的值在括号中表示。 - 节点 0 没有互质祖先。 - 节点 1 只有一个祖先节点 0
 * 。它们的值是互质的（gcd(2,3) == 1）。 - 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(2, 3) ==
 * 1)，所以节点 0 是最近的符合要求的祖先节点。 - 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]] 输出：[-1,0,-1,0,0,0,-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums.length == n 1 <= nums[i] <= 50 1 <= n <= 10⁵ edges.length == n - 1 edges[j].length == 2 0 <= uj, vj < n uj !=
 * vj
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 数组 数学 数论 👍 61 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeOfCoprimes {

    public static void main(String[] args) {
        //Solution solution = new TreeOfCoprimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer>[] gcds;

        List<Integer>[] tmp;

        List<Integer>[] g;

        int[] dep;

        int[] ans;

        public int[] getCoprimes(int[] nums, int[][] edges) {
            int n = nums.length;

            // 初始化
            gcds = new List[51];
            tmp = new List[51];
            for (int i = 0; i <= 50; i++) {
                gcds[i] = new ArrayList<Integer>();
                tmp[i] = new ArrayList<Integer>();
            }
            ans = new int[n];
            dep = new int[n];
            Arrays.fill(ans, -1);
            Arrays.fill(dep, -1);
            g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<Integer>();
            }

            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    if (gcd(i, j) == 1) {
                        gcds[i].add(j);
                    }
                }
            }

            for (int[] val : edges) {
                g[val[0]].add(val[1]);
                g[val[1]].add(val[0]);
            }

            dfs(nums, 0, 1);

            return ans;
        }

        public int gcd(int x, int y) {
            while (y != 0) {
                int temp = x;
                x = y;
                y = temp % y;
            }
            return x;
        }

        public void dfs(int[] nums, int x, int depth) {
            dep[x] = depth;
            for (int val : gcds[nums[x]]) {
                if (tmp[val].isEmpty()) {
                    continue;
                }

                int las = tmp[val].get(tmp[val].size() - 1);
                if (ans[x] == -1 || dep[las] > dep[ans[x]]) {
                    ans[x] = las;
                }
            }
            tmp[nums[x]].add(x);

            for (int val : g[x]) {
                if (dep[val] == -1) { // 被访问过的点dep不为-1
                    dfs(nums, val, depth + 1);
                }
            }

            tmp[nums[x]].remove(tmp[nums[x]].size() - 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}