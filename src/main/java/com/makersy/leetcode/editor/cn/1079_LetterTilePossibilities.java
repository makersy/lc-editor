/**
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 回溯 计数 👍 241 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LetterTilePossibilities {
    public static void main(String[] args) {
        //Solution solution = new LetterTilePossibilities().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTilePossibilities(String tiles) {
            Map<Character, Integer> count = new HashMap<>();
            for (char t : tiles.toCharArray()) {
                count.put(t, count.getOrDefault(t, 0) + 1);
            }
            Set<Character> tile = new HashSet<>(count.keySet());
            return dfs(tiles.length(), count, tile) - 1;
        }

        private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
            if (i == 0) {
                return 1;
            }
            int res = 1;
            for (char t : tile) {
                if (count.get(t) > 0) {
                    count.put(t, count.get(t) - 1);
                    res += dfs(i - 1, count, tile);
                    count.put(t, count.get(t) + 1);
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}