/**
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * <p>
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID]
 * = -1。题目保证从属关系可以用树结构显示。
 * <p>
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * <p>
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一
 * 消息）。
 * <p>
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * 0 <= headID < n
 * manager.length == n
 * 0 <= manager[i] < n
 * manager[headID] == -1
 * informTime.length == n
 * 0 <= informTime[i] <= 1000
 * 如果员工 i 没有下属，informTime[i] == 0 。
 * 题目 保证 所有员工都可以收到通知。
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 👍 155 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        //Solution solution = new TimeNeededToInformAllEmployees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] manager, informTime;

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            this.manager = manager;
            this.informTime = informTime;
            Map<Integer, List<Integer>> map = new HashMap<>();
            int len = manager.length;
            for (int i = 0; i < len; i++) {
                if (!map.containsKey(manager[i])) {
                    map.put(manager[i], new ArrayList<>());
                }
                map.get(manager[i]).add(i);
            }
            return func(map, headID);
        }

        private int func(Map<Integer, List<Integer>> map, int head) {
            if (informTime[head] == 0) {
                return 0;
            }
            var list = map.get(head);
            int max = 0;
            for (var n : list) {
                max = Math.max(max, func(map, n));
            }
            return informTime[head] + max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}