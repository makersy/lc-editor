/**
 * 设计一个数据结构，有效地找到给定子数组的 多数元素 。
 * <p>
 * 子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。
 * <p>
 * 实现 MajorityChecker 类:
 * <p>
 * <p>
 * MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。
 * int query(int left, int right, int threshold) 返回子数组中的元素 arr[left...right] 至少出现
 * threshold 次数，如果不存在这样的元素则返回 -1。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入:
 * ["MajorityChecker", "query", "query", "query"]
 * [[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
 * 输出：
 * [null, 1, -1, 2]
 * <p>
 * 解释：
 * MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
 * majorityChecker.query(0,5,4); // 返回 1
 * majorityChecker.query(0,3,3); // 返回 -1
 * majorityChecker.query(2,3,2); // 返回 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 2 * 10⁴
 * 1 <= arr[i] <= 2 * 10⁴
 * 0 <= left <= right < arr.length
 * threshold <= right - left + 1
 * 2 * threshold > right - left + 1
 * 调用 query 的次数最多为 10⁴
 * <p>
 * <p>
 * Related Topics 设计 树状数组 线段树 数组 二分查找 👍 145 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

class OnlineMajorityElementInSubarray {
    public static void main(String[] args) {
        //Solution solution = new OnlineMajorityElementInSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MajorityChecker {
        public static final int K = 20;
        private int[] arr;
        private Map<Integer, List<Integer>> loc;
        private Random random;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
            this.loc = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < arr.length; ++i) {
                loc.putIfAbsent(arr[i], new ArrayList<Integer>());
                loc.get(arr[i]).add(i);
            }
            this.random = new Random();
        }

        public int query(int left, int right, int threshold) {
            int length = right - left + 1;

            for (int i = 0; i < K; ++i) {
                int x = arr[left + random.nextInt(length)];
                List<Integer> pos = loc.get(x);
                int occ = searchEnd(pos, right) - searchStart(pos, left);
                if (occ >= threshold) {
                    return x;
                } else if (occ * 2 >= length) {
                    return -1;
                }
            }

            return -1;
        }

        private int searchStart(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private int searchEnd(List<Integer> pos, int target) {
            int low = 0, high = pos.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }


/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
//leetcode submit region end(Prohibit modification and deletion)

}