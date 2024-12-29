/**
 * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
 * <p>
 * 排名规则如下：
 * <p>
 * <p>
 * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 * <p>
 * <p>
 * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 * <p>
 * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"] 输出："ACB" 解释： A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。 B
 * 队获得两票「排位第二」，三票「排位第三」。 C 队获得三票「排位第二」，两票「排位第三」。 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：votes = ["WXYZ","XYZW"] 输出："XWYZ" 解释： X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"] 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK" 解释：只有一个投票者，所以排名完全按照他的意愿。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= votes.length <= 1000 1 <= votes[i].length <= 26 votes[i].length == votes[j].length for 0 <= i, j < votes.length
 * votes[i][j] 是英文 大写 字母 votes[i] 中的所有字母都是唯一的 votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 计数 排序 👍 125 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RankTeamsByVotes {

    public static void main(String[] args) {
        //Solution solution = new RankTeamsByVotes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Pair{
            char c;
            int[] p;

            public Pair(char c, int[] p) {
                this.c = c;
                this.p = p;
            }
        }
        public String rankTeams(String[] votes) {
            int lenw = votes[0].length(), len = votes.length;

            Map<Character, int[]> map = new HashMap<>();
            for (String vote : votes) {
                for (int i = 0; i < lenw; i++) {
                    if (!map.containsKey(vote.charAt(i))) {
                        map.put(vote.charAt(i), new int[lenw]);
                    }
                    map.get(vote.charAt(i))[i]++;
                }
            }
            List<Pair> list = new ArrayList<>();
            for (Map.Entry<Character, int[]> e : map.entrySet()) {
                list.add(new Pair(e.getKey(), e.getValue()));
            }
            list.sort((a, b) -> {
                int res = cmp(b.p, a.p);
                if (res == 0) {
                    return a.c - b.c;
                }
                return res;
            });

            StringBuilder res = new StringBuilder();
            for (Pair pair : list) {
                res.append(pair.c);
            }
            return res.toString();
        }

        private int cmp(int[] a, int[] b) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] > b[i]) {
                    return 1;
                } else if (a[i] < b[i]) {
                    return -1;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}