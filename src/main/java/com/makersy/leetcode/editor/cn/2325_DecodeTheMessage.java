/**
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * <p>
 * <p>
 * <p>
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' ->
 * 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * <p>
 * <p>
 * 返回解密后的消息。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t
 * suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk
 * vcnjrdb"
 * 输出："the five boxing wizards jump quickly"
 * 解释：对照表如上图所示。
 * 提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 44 👎 0
 */

package com.makersy.leetcode.editor.cn;

class DecodeTheMessage {
    public static void main(String[] args) {
        //Solution solution = new DecodeTheMessage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeMessage(String key, String message) {
            var m = new char[26];
            var flag = new boolean[26];
            var idx = 0;

            for (var c : key.toCharArray()) {
                if(c == ' ') continue;
                if (!flag[c - 'a']) {
                    flag[c - 'a'] = true;
                    m[c - 'a'] = (char)('a' + idx++);
                }
            }
            var sb = new StringBuilder();
            for (var c : message.toCharArray()) {
                if(c == ' ') sb.append(" ");
                else sb.append(m[c-'a']);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}