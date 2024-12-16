//一个酒店里有 n 个房间，这些房间用二维整数数组 rooms 表示，其中 rooms[i] = [roomIdi, sizei] 表示有一个房间号为 
//roomIdi 的房间且它的面积为 sizei 。每一个房间号 roomIdi 保证是 独一无二 的。 
//
// 同时给你 k 个查询，用二维数组 queries 表示，其中 queries[j] = [preferredj, minSizej] 。第 j 个查询的答
//案是满足如下条件的房间 id ： 
//
// 
// 房间的面积 至少 为 minSizej ，且 
// abs(id - preferredj) 的值 最小 ，其中 abs(x) 是 x 的绝对值。 
// 
//
// 如果差的绝对值有 相等 的，选择 最小 的 id 。如果 没有满足条件的房间 ，答案为 -1 。 
//
// 请你返回长度为 k 的数组 answer ，其中 answer[j] 为第 j 个查询的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
//输出：[3,-1,3]
//解释：查询的答案如下：
//查询 [3,1] ：房间 3 的面积为 2 ，大于等于 1 ，且号码是最接近 3 的，为 abs(3 - 3) = 0 ，所以答案为 3 。
//查询 [3,3] ：没有房间的面积至少为 3 ，所以答案为 -1 。
//查询 [5,2] ：房间 3 的面积为 2 ，大于等于 2 ，且号码是最接近 5 的，为 abs(3 - 5) = 2 ，所以答案为 3 。 
//
// 示例 2： 
//
// 
//输入：rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]
//输出：[2,1,3]
//解释：查询的答案如下：
//查询 [2,3] ：房间 2 的面积为 3 ，大于等于 3 ，且号码是最接近的，为 abs(2 - 2) = 0 ，所以答案为 2 。
//查询 [2,4] ：房间 1 和 3 的面积都至少为 4 ，答案为 1 因为它房间编号更小。
//查询 [2,5] ：房间 3 是唯一面积大于等于 5 的，所以答案为 3 。 
//
// 
//
// 提示： 
//
// 
// n == rooms.length 
// 1 <= n <= 10⁵ 
// k == queries.length 
// 1 <= k <= 10⁴ 
// 1 <= roomIdi, preferredj <= 10⁷ 
// 1 <= sizei, minSizej <= 10⁷ 
// 
//
// Related Topics 数组 二分查找 有序集合 排序 👍 75 👎 0


package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

class ClosestRoom {

    public static void main(String[] args) {
        //Solution solution = new ClosestRoom().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] closestRoom(int[][] rooms, int[][] queries) {
            // 按照 size 从大到小排序
            Arrays.sort(rooms, (a, b) -> (b[1] - a[1]));

            int q = queries.length;
            Integer[] queryIds = new Integer[q];
            Arrays.setAll(queryIds, i -> i);
            // 按照 minSize 从大到小排序
            Arrays.sort(queryIds, (i, j) -> queries[j][1] - queries[i][1]);

            int[] ans = new int[q];
            Arrays.fill(ans, -1);
            TreeSet<Integer> roomIds = new TreeSet<>();
            int j = 0;
            for (int i : queryIds) {
                int preferredId = queries[i][0];
                int minSize = queries[i][1];
                while (j < rooms.length && rooms[j][1] >= minSize) {
                    roomIds.add(rooms[j][0]);
                    j++;
                }

                int diff = Integer.MAX_VALUE;
                Integer floor = roomIds.floor(preferredId);
                if (floor != null) {
                    diff = preferredId - floor; // 左边的差
                    ans[i] = floor;
                }
                Integer ceiling = roomIds.ceiling(preferredId);
                if (ceiling != null && ceiling - preferredId < diff) { // 右边的差更小
                    ans[i] = ceiling;
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}