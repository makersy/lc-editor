/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连
 * 接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * 示例：
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * <p>
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 134 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PondSizesLcci {
    public static void main(String[] args) {
        //Solution solution = new PondSizesLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pondSizes(int[][] land) {
            int m = land.length, n = land[0].length;
            List<Integer> resList = new ArrayList<Integer>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] == 0) {
                        resList.add(dfs(land, i, j));
                    }
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            Arrays.sort(res);
            return res;
        }

        public int dfs(int[][] land, int x, int y) {
            int m = land.length, n = land[0].length;
            if (x < 0 || x >= m || y < 0 || y >= n || land[x][y] != 0) {
                return 0;
            }
            land[x][y] = -1;
            int res = 1;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    res += dfs(land, x + dx, y + dy);
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}