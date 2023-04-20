/**
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j <
 * arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 二分查找 动态规划 排序 👍 159 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        // Solution solution = new MakeArrayStrictlyIncreasing().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int INF = 0x3f3f3f3f;

        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            Arrays.sort(arr2);
            List<Integer> list = new ArrayList<Integer>();
            int prev = -1;
            for (int num : arr2) {
                if (num != prev) {
                    list.add(num);
                    prev = num;
                }
            }
            int n = arr1.length;
            int m = list.size();
            int[][] dp = new int[n + 1][Math.min(m, n) + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], INF);
            }
            dp[0][0] = -1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= Math.min(i, m); j++) {
                    /* 如果当前元素大于序列的最后一个元素 */
                    if (arr1[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = arr1[i - 1];
                    }
                    if (j > 0 && dp[i - 1][j - 1] != INF) {
                        /* 查找严格大于 dp[i - 1][j - 1] 的最小元素 */
                        int idx = binarySearch(list, j - 1, dp[i - 1][j - 1]);
                        if (idx != list.size()) {
                            dp[i][j] = Math.min(dp[i][j], list.get(idx));
                        }
                    }
                    if (i == n && dp[i][j] != INF) {
                        return j;
                    }
                }
            }
            return -1;
        }

        public int binarySearch(List<Integer> list, int low, int target) {
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) > target) {
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