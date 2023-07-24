/**
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想
 * 知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 776 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class JewelsAndStones {
    public static void main(String[] args) {
        // Solution solution = new JewelsAndStones().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            boolean[] flag = new boolean[128];
            for (char c : jewels.toCharArray()) {
                flag[c] = true;
            }
            int res = 0;
            for (char c : stones.toCharArray()) {
                if (flag[c]) {
                    res++;
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}