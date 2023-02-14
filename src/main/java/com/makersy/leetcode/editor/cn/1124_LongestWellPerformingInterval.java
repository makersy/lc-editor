/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= hours.length <= 10⁴
 * 0 <= hours[i] <= 16
 * <p>
 * <p>
 * Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 382 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class LongestWellPerformingInterval {
    public static void main(String[] args) {
        //Solution solution = new LongestWellPerformingInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();
            int len = hours.length;
            // diff: high - low
            int diff = 0, res = 0;
            for (int i = 0; i < len; i++) {
                diff = hours[i] > 8 ? diff + 1 : diff - 1;
                if(diff > 0){
                    res = i + 1;
                }else if (map.containsKey(diff - 1)) {
                    res = Math.max(res, i - map.get(diff - 1));
                }
                map.putIfAbsent(diff, i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}