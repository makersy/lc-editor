/**
 * 公司里共有 n 名员工，按从 0 到 n - 1 编号。每个员工 i 已经在公司工作了 hours[i] 小时。
 * <p>
 * 公司要求每位员工工作 至少 target 小时。
 * <p>
 * 给你一个下标从 0 开始、长度为 n 的非负整数数组 hours 和一个非负整数 target 。
 * <p>
 * 请你用整数表示并返回工作至少 target 小时的员工数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [0,1,2,3,4], target = 2 输出：3 解释：公司要求每位员工工作至少 2 小时。 - 员工 0 工作 0 小时，不满足要求。 - 员工 1 工作 1 小时，不满足要求。 - 员工 2 工作 2
 * 小时，满足要求。 - 员工 3 工作 3 小时，满足要求。 - 员工 4 工作 4 小时，满足要求。 共有 3 位满足要求的员工。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：hours = [5,1,4,2,2], target = 6 输出：0 解释：公司要求每位员工工作至少 6 小时。 共有 0 位满足要求的员工。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n == hours.length <= 50 0 <= hours[i], target <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 👍 26 👎 0
 */

package com.makersy.leetcode.editor.cn;

class NumberOfEmployeesWhoMetTheTarget {

    public static void main(String[] args) {
        //Solution solution = new NumberOfEmployeesWhoMetTheTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int ans = 0;
            for (int i = 0; i < hours.length; i++) {
                if (hours[i] >= target) {
                    ans++;
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}