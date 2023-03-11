/**
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
 * "L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * array.length <= 100000
 * <p>
 * <p>
 * Related Topics 数组 哈希表 前缀和 👍 156 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindLongestSubarrayLcci {
    public static void main(String[] args) {
        //Solution solution = new FindLongestSubarrayLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int len = array.length;
            int letter = 0, digit = 0;
            int l = 0, r = 0;
            // 数字比字母多多少
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < len; i++) {
                if (isDigit(array[i])) {
                    digit++;
                } else {
                    letter++;
                }
                int diff = digit - letter;
                int first = map.getOrDefault(diff, -2);
                if (first > -2) {
                    if (i - first > r - l) {
                        r = i + 1;
                        l = first + 1;
                    }
                } else {
                    map.put(diff, i);
                }
            }
            if (l == r) {
                return new String[]{};
            }
            return Arrays.copyOfRange(array, l, r);
        }

        private boolean isDigit(String s) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}