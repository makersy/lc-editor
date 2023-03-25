/**
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 二分查找 单调栈 👍 168 👎 0
 */

package com.makersy.leetcode.editor.cn;

class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        //Solution solution = new ShortestSubarrayToBeRemovedToMakeArraySorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;
            int i = 0, j = n - 1;
            while (i + 1 < n && arr[i] <= arr[i + 1]) {
                ++i;
            }
            while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
                --j;
            }
            if (i >= j) {
                return 0;
            }
            int ans = Math.min(n - i - 1, j);
            for (int l = 0; l <= i; ++l) {
                int r = search(arr, arr[l], j);
                ans = Math.min(ans, r - l - 1);
            }
            return ans;
        }

        private int search(int[] arr, int x, int left) {
            int right = arr.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}