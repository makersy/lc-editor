/**
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从
 * starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= flowers.length <= 5 * 10⁴
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 10⁹
 * 1 <= people.length <= 5 * 10⁴
 * 1 <= people[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 96 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class NumberOfFlowersInFullBloom {
    public static void main(String[] args) {
        // Solution solution = new NumberOfFlowersInFullBloom().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
            int n = flowers.length;
            int[] starts = new int[n];
            int[] ends = new int[n];
            for (int i = 0; i < n; i++) {
                starts[i] = flowers[i][0];
                ends[i] = flowers[i][1];
            }
            Arrays.sort(starts);
            Arrays.sort(ends);

            int m = persons.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int x = binarySearch(starts, persons[i] + 1);
                int y = binarySearch(ends, persons[i]);
                ans[i] = x - y;
            }
            return ans;
        }

        int binarySearch(int[] arr, int target) {
            int res = arr.length;
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (arr[mid] >= target) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}