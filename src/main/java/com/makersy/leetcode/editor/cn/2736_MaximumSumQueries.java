/**
 * 给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[
 * i] = [xi, yi] 。
 * <p>
 * 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[
 * j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
 * <p>
 * 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
 * 输出：[6,10,7]
 * 解释：
 * 对于第 1 个查询：xi = 4 且 yi = 1 ，可以选择下标 j = 0 ，此时 nums1[j] >= 4 且 nums2[j] >= 1 。nums1
 * [j] + nums2[j] 等于 6 ，可以证明 6 是可以获得的最大值。
 * 对于第 2 个查询：xi = 1 且 yi = 3 ，可以选择下标 j = 2 ，此时 nums1[j] >= 1 且 nums2[j] >= 3 。nums1
 * [j] + nums2[j] 等于 10 ，可以证明 10 是可以获得的最大值。
 * 对于第 3 个查询：xi = 2 且 yi = 5 ，可以选择下标 j = 3 ，此时 nums1[j] >= 2 且 nums2[j] >= 5 。nums1
 * [j] + nums2[j] 等于 7 ，可以证明 7 是可以获得的最大值。
 * 因此，我们返回 [6,10,7] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
 * 输出：[9,9,9]
 * 解释：对于这个示例，我们可以选择下标 j = 2 ，该下标可以满足每个查询的限制。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
 * 输出：[-1]
 * 解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不存在
 * 答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums1.length == nums2.length
 * n == nums1.length
 * 1 <= n <= 10⁵
 * 1 <= nums1[i], nums2[i] <= 10⁹
 * 1 <= queries.length <= 10⁵
 * queries[i].length == 2
 * xi == queries[i][1]
 * yi == queries[i][2]
 * 1 <= xi, yi <= 10⁹
 * <p>
 * <p>
 * Related Topics 栈 树状数组 线段树 数组 二分查找 排序 单调栈 👍 81 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaximumSumQueries {
    public static void main(String[] args) {
        // Solution solution = new MaximumSumQueries().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
            int n = nums1.length;
            int[][] sortedNums = new int[n][2];
            for (int i = 0; i < n; i++) {
                sortedNums[i][0] = nums1[i];
                sortedNums[i][1] = nums2[i];
            }
            Arrays.sort(sortedNums, (a, b) -> b[0] - a[0]);
            int q = queries.length;
            int[][] sortedQueries = new int[q][3];
            for (int i = 0; i < q; i++) {
                sortedQueries[i][0] = i;
                sortedQueries[i][1] = queries[i][0];
                sortedQueries[i][2] = queries[i][1];
            }
            Arrays.sort(sortedQueries, (a, b) -> b[1] - a[1]);
            List<int[]> stack = new ArrayList<int[]>();
            int[] answer = new int[q];
            Arrays.fill(answer, -1);
            int j = 0;
            for (int[] query : sortedQueries) {
                int i = query[0], x = query[1], y = query[2];
                while (j < n && sortedNums[j][0] >= x) {
                    int[] pair = sortedNums[j];
                    int num1 = pair[0], num2 = pair[1];
                    while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= num1 + num2) {
                        stack.remove(stack.size() - 1);
                    }
                    if (stack.isEmpty() || stack.get(stack.size() - 1)[0] < num2) {
                        stack.add(new int[]{num2, num1 + num2});
                    }
                    j++;
                }
                int k = binarySearch(stack, y);
                if (k < stack.size()) {
                    answer[i] = stack.get(k)[1];
                }
            }
            return answer;
        }

        public int binarySearch(List<int[]> list, int target) {
            int low = 0, high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid)[0] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}