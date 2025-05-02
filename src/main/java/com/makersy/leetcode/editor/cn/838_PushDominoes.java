/**
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * <p>
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * <p>
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 * <p>
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * <p>
 * <p>
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧， dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧， dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * <p>
 * <p>
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：dominoes = "RR.L" 输出："RR.L" 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：dominoes = ".L.R...LR..L.." 输出："LL.RR.LLRRLL.."
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == dominoes.length 1 <= n <= 10⁵ dominoes[i] 为 'L'、'R' 或 '.'
 * <p>
 * <p>
 * Related Topics 双指针 字符串 动态规划 👍 345 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class PushDominoes {

    public static void main(String[] args) {
        //Solution solution = new PushDominoes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String pushDominoes(String dominoes) {
            int n = dominoes.length();
            Deque<Integer> queue = new ArrayDeque<Integer>();
            int[] time = new int[n];
            Arrays.fill(time, -1);
            List<Character>[] force = new List[n];
            for (int i = 0; i < n; i++) {
                force[i] = new ArrayList<Character>();
            }
            for (int i = 0; i < n; i++) {
                char f = dominoes.charAt(i);
                if (f != '.') {
                    queue.offer(i);
                    time[i] = 0;
                    force[i].add(f);
                }
            }

            char[] res = new char[n];
            Arrays.fill(res, '.');
            while (!queue.isEmpty()) {
                int i = queue.poll();
                if (force[i].size() == 1) {
                    char f = force[i].get(0);
                    res[i] = f;
                    int ni = f == 'L' ? i - 1 : i + 1;
                    if (ni >= 0 && ni < n) {
                        int t = time[i];
                        if (time[ni] == -1) {
                            queue.offer(ni);
                            time[ni] = t + 1;
                            force[ni].add(f);
                        } else if (time[ni] == t + 1) {
                            force[ni].add(f);
                        }
                    }
                }
            }
            return new String(res);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}