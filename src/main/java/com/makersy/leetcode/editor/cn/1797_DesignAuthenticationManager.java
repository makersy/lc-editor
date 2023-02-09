/**
 * 你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如果验
 * 证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。
 * <p>
 * 请你实现 AuthenticationManager 类：
 * <p>
 * <p>
 * AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参
 * 数。
 * generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验
 * 证码。
 * renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新
 * 。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
 * countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
 * <p>
 * <p>
 * 如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其他操
 * 作。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens",
 * "generate", "renew", "renew", "countUnexpiredTokens"]
 * [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
 * 输出：
 * [null, null, null, 1, null, null, null, 0]
 * <p>
 * <p>
 * 解释：
 * AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构
 * 造 AuthenticationManager ，设置 timeToLive = 5 秒。
 * authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更
 * 新。
 * authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
 * authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码
 * 未过期，所以返回 1 。
 * authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
 * authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7
 * ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
 * authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以
 * renew 操作会执行，该 token 将在时刻 15 过期。
 * authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期
 * ，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= timeToLive <= 10⁸
 * 1 <= currentTime <= 10⁸
 * 1 <= tokenId.length <= 5
 * tokenId 只包含小写英文字母。
 * 所有 generate 函数的调用都会包含独一无二的 tokenId 值。
 * 所有函数调用中，currentTime 的值 严格递增 。
 * 所有函数的调用次数总共不超过 2000 次。
 * <p>
 * <p>
 * Related Topics 设计 哈希表 👍 77 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DesignAuthenticationManager {
    public static void main(String[] args) {
        //Solution solution = new DesignAuthenticationManager().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AuthenticationManager {

        private int timeToLive;
        // 存储id的最后一次更新的时间
        private final HashMap<String, Integer> map = new HashMap<>();
        // 使用两个列表分别储存所有记录的id和time
        List<String> idList = new ArrayList<>();
        List<Integer> timeList = new ArrayList<>();
        // 表示上一次查询未过时验证码时，第一个未过时的验证码在列表中的索引
        int start = 0;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime);
            idList.add(tokenId);
            timeList.add(currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.containsKey(tokenId)) {
                // 若该id存在且未过时，则更新map并给列表添加记录
                if (map.get(tokenId) > currentTime - timeToLive) {
                    map.put(tokenId, currentTime);
                    idList.add(tokenId);
                    timeList.add(currentTime);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int n = idList.size();
            int i = start;
            for (; i < n; i++) {
                String id = idList.get(i);
                Integer time = timeList.get(i);
                // 遇到没超时的记录就停止遍历
                if (time > currentTime - timeToLive) break;
                // 如果这一id的最后一次更新时间和该次记录的时间相同，则说明这一id已经过时
                if (map.get(id).equals(time)) {
                    map.remove(id);
                }
            }
            // 因为下一次时间肯定不早于这次的时间，所以下一次查询从start开始即可
            start = i;
            return map.size();
        }
    }


/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
//leetcode submit region end(Prohibit modification and deletion)

}