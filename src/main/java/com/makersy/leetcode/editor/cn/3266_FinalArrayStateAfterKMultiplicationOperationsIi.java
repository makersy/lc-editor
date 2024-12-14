//给你一个整数数组 nums ，一个整数 k 和一个整数 multiplier 。 
//
// 你需要对 nums 执行 k 次操作，每次操作中： 
//
// 
// 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。 
// 将 x 替换为 x * multiplier 。 
// 
//
// k 次操作以后，你需要将 nums 中每一个数值对 10⁹ + 7 取余。 
//
// 请你返回执行完 k 次乘运算以及取余运算之后，最终的 nums 数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2 
// 
//
// 输出：[8,4,6,5,6] 
//
// 解释： 
//
// 
// 
// 
// 操作 
// 结果 
// 
// 
// 1 次操作后 
// [2, 2, 3, 5, 6] 
// 
// 
// 2 次操作后 
// [4, 2, 3, 5, 6] 
// 
// 
// 3 次操作后 
// [4, 4, 3, 5, 6] 
// 
// 
// 4 次操作后 
// [4, 4, 6, 5, 6] 
// 
// 
// 5 次操作后 
// [8, 4, 6, 5, 6] 
// 
// 
// 取余操作后 
// [8, 4, 6, 5, 6] 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [100000,2000], k = 2, multiplier = 1000000 
// 
//
// 输出：[999999307,999999993] 
//
// 解释： 
//
// 
// 
// 
// 操作 
// 结果 
// 
// 
// 1 次操作后 
// [100000, 2000000000] 
// 
// 
// 2 次操作后 
// [100000000000, 2000000000] 
// 
// 
// 取余操作后 
// [999999307, 999999993] 
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 1 <= multiplier <= 10⁶ 
// 
//
// Related Topics 数组 模拟 堆（优先队列） 👍 35 👎 0


package com.makersy.leetcode.editor.cn;

import java.util.PriorityQueue;

class FinalArrayStateAfterKMultiplicationOperationsIi {

    public static void main(String[] args) {
        //Solution solution = new FinalArrayStateAfterKMultiplicationOperationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private long quickMul(long x, long y, long m) {
            long res = 1;
            while (y > 0) {
                if ((y & 1) == 1) {
                    res = (res * x) % m;
                }
                y >>= 1;
                x = (x * x) % m;
            }
            return res;
        }

        public int[] getFinalState(int[] nums, int k, int multiplier) {
            if (multiplier == 1) {
                return nums;
            }
            int n = nums.length, mx = 0;
            long m = 1000000007L;
            PriorityQueue<long[]> v = new PriorityQueue<>((x, y) -> {
                if (x[0] != y[0]) {
                    return Long.compare(x[0], y[0]);
                } else {
                    return Long.compare(x[1], y[1]);
                }
            });
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, nums[i]);
                v.offer(new long[] {nums[i], i});
            }
            for (; v.peek()[0] < mx && k > 0; k--) {
                long[] x = v.poll();
                x[0] *= multiplier;
                v.offer(x);
            }
            for (int i = 0; i < n; i++) {
                long[] x = v.poll();
                int t = k / n + (i < k % n ? 1 : 0);
                nums[(int) x[1]] = (int) ((x[0] % m) * quickMul(multiplier, t, m) % m);
            }
            return nums;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}