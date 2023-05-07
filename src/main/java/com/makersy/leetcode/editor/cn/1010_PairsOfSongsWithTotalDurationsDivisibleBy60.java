/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足 i < j 且有 (time[i] + time[
 * j]) % 60 == 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= time.length <= 6 * 10⁴
 * 1 <= time[i] <= 500
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 👍 263 👎 0
 */

package com.makersy.leetcode.editor.cn;

class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        //Solution solution = new PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] cnt = new int[60];
            for (int t : time) {
                cnt[t % 60]++;
            }
            long res = 0;
            for (int i = 1; i < 30; i++) {
                res += cnt[i] * cnt[60 - i];
            }
            res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
            return (int) res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}