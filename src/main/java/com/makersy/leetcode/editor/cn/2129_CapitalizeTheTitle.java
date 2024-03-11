/**
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。 否则，将单词首字母大写，剩余字母变成小写。
 * <p>
 * <p>
 * 请你返回 大写后 的 title 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：title = "capiTalIze tHe titLe" 输出："Capitalize The Title" 解释： 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word" 输出："First Letter of Each Word" 解释： 单词 "of" 长度为 2 ，所以它保持完全小写。 其他单词长度都至少为 3
 * ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode" 输出："i Love Leetcode" 解释： 单词 "i" 长度为 1 ，所以它保留小写。 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= title.length <= 100 title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。 每个单词由大写和小写英文字母组成，且都是 非空 的。
 * <p>
 * <p>
 * Related Topics 字符串 👍 46 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CapitalizeTheTitle {

    public static void main(String[] args) {
        //Solution solution = new CapitalizeTheTitle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String capitalizeTitle(String title) {
            String[] arr = title.split(" ");
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String s : arr) {
                if (!first) {
                    sb.append(" ");
                } else {
                    first = false;
                }
                if (s.length() <= 2) {
                    for (char c : s.toCharArray()) {
                        if (c < 'a') {
                            sb.append((char) (c + 32));
                        } else {
                            sb.append(c);
                        }
                    }
                } else {
                    if (s.charAt(0) < 'a') {
                        sb.append(s.charAt(0));
                    } else {
                        sb.append((char) (s.charAt(0) - 32));
                    }
                    for (int i = 1; i < s.length(); i++) {
                        if (s.charAt(i) < 'a') {
                            sb.append((char) (s.charAt(i) + 32));
                        } else {
                            sb.append(s.charAt(i));
                        }
                    }
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}