/**
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * <p>
 * <p>
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * <p>
 * <p>
 * （注意，字母板上只存在有字母的位置。）
 * <p>
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 73 👎 0
 */

package com.makersy.leetcode.editor.cn;

class AlphabetBoardPath {
    public static void main(String[] args) {
        //Solution solution = new AlphabetBoardPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alphabetBoardPath(String target) {
            int cx = 0, cy = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int nx = (c - 'a') / 5;
                int ny = (c - 'a') % 5;
                if (nx < cx) {
                    for (int j = 0; j < cx - nx; j++) {
                        res.append('U');
                    }
                }
                if (ny < cy) {
                    for (int j = 0; j < cy - ny; j++) {
                        res.append('L');
                    }
                }
                if (nx > cx) {
                    for (int j = 0; j < nx - cx; j++) {
                        res.append('D');
                    }
                }
                if (ny > cy) {
                    for (int j = 0; j < ny - cy; j++) {
                        res.append('R');
                    }
                }
                res.append('!');
                cx = nx;
                cy = ny;
            }
            return res.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}