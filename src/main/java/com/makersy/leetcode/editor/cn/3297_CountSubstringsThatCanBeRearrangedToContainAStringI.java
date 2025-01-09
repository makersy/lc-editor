/**
 * 给你两个字符串 word1 和 word2 。
 * <p>
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。
 * <p>
 * 请你返回 word1 中 合法 子字符串 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = "bcca", word2 = "abc"
 * <p>
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = "abcabc", word2 = "abc"
 * <p>
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 除了长度为 1 和 2 的所有子字符串都是合法的。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word1 = "abcabc", word2 = "aaabc"
 * <p>
 * <p>
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 解释：
 * <p>
 * <p>
 * 1 <= word1.length <= 10⁵ 1 <= word2.length <= 10⁴ word1 和 word2 都只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 29 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountSubstringsThatCanBeRearrangedToContainAStringI {

    public static void main(String[] args) {
        //Solution solution = new CountSubstringsThatCanBeRearrangedToContainAStringI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long validSubstringCount(String word1, String word2) {
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            char[] c1 = word1.toCharArray();
            int len1 = word1.length();
            for (char c : word2.toCharArray()) {
                cnt2[c - 'a']++;
            }
            int l = 0, r = 0;
            cnt1[c1[0] - 'a']++;
            long res = 0;
            while (l <= r && r < len1) {
                if (arrHe(cnt1, cnt2)) {
                    res += (len1 - r);
                    cnt1[c1[l] - 'a']--;
                    l++;
                    if (l > r) {
                        r++;
                        if (r < len1) {
                            cnt1[c1[r] - 'a']++;
                        }
                    }
                } else {
                    r++;
                    if (r < len1) {
                        cnt1[c1[r] - 'a']++;
                    }
                }
            }
            return res;
        }

        private boolean arrHe(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] < arr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}