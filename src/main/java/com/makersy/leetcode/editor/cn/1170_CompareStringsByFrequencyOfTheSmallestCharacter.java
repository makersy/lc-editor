/**
 * 定义一个函数 f(s)，统计 s 中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[
 * i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 二分查找 排序 👍 87 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.Arrays;

class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        //Solution solution = new CompareStringsByFrequencyOfTheSmallestCharacter().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] cnt;
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int lenw = words.length, lenq = queries.length;
            int[] wcnt = new int[lenw];
            cnt = new int[26];

            for (int i = 0; i < lenw; i++) {
                wcnt[i] = getMin(words[i]);
            }

            Arrays.sort(wcnt);
            int[] res = new int[lenq];
            for (int i = 0; i < lenq; i++) {
                int v = getMin(queries[i]);
                int low = 0, high = lenw;
                int mid;
                while (low < high) {
                    mid = (low + high) / 2;
                    if (v >= wcnt[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                res[i] = lenw - low;
            }
            return res;
        }

        private int getMin(String word) {
            Arrays.fill(cnt, 0);
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
            for (int n : cnt) {
                if(n > 0) return n;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}