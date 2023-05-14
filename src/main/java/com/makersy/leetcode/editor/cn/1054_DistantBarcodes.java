/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * <p>
 * <p>
 * Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 130 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class DistantBarcodes {
    public static void main(String[] args) {
        //Solution solution = new DistantBarcodes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int b : barcodes) {
                if (!count.containsKey(b)) {
                    count.put(b, 0);
                }
                count.put(b, count.get(b) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                pq.offer(new int[]{entry.getValue(), entry.getKey()});
            }
            int n = barcodes.length;
            int[] res = new int[n];
            for (int i = 0; i < n; ++i) {
                int[] p = pq.poll();
                int cx = p[0], x = p[1];
                if (i == 0 || res[i - 1] != x) {
                    res[i] = x;
                    if (cx > 1) {
                        pq.offer(new int[]{cx - 1, x});
                    }
                } else {
                    int[] p2 = pq.poll();
                    int cy = p2[0], y = p2[1];
                    res[i] = y;
                    if (cy > 1) {
                        pq.offer(new int[]{cy - 1, y});
                    }
                    pq.offer(new int[]{cx, x});
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}