/**
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到
 * "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 * <p>
 * 按下述要求实现 StreamChecker 类：
 * <p>
 * <p>
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true
 * ；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query",
 * "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], [
 * "i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false,
 * false, true]
 * <p>
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 10⁴ 次
 * <p>
 * <p>
 * Related Topics 设计 字典树 数组 字符串 数据流 👍 139 👎 0
 */

package com.makersy.leetcode.editor.cn;

class StreamOfCharacters {
    public static void main(String[] args) {
        //Solution solution = new StreamOfCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public void insert(String w) {
            Trie node = this;
            for (int i = w.length() - 1; i >= 0; --i) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean query(StringBuilder s) {
            Trie node = this;
            for (int i = s.length() - 1, j = 0; i >= 0 && j < 201; --i, ++j) {
                int idx = s.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    return true;
                }
            }
            return false;
        }
    }

    class StreamChecker {
        private StringBuilder sb = new StringBuilder();
        private Trie trie = new Trie();

        public StreamChecker(String[] words) {
            for (String w : words) {
                trie.insert(w);
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            return trie.query(sb);
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//leetcode submit region end(Prohibit modification and deletion)

}