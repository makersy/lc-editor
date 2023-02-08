/**
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等
 * 于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时
 * 间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情
 * 况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime =
 * ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:0
 * 1","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"],
 * keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= keyName.length, keyTime.length <= 10⁵
 * keyName.length == keyTime.length
 * keyTime 格式为 "HH:MM" 。
 * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
 * 1 <= keyName[i].length <= 10
 * keyName[i] 只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 排序 👍 79 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.*;

class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args) {
        //Solution solution = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> alertNames(String[] keyName, String[] keyTime) {
            int len = keyName.length;

            Map<String, List<String>> map = new HashMap<>();
            List<String> rlist = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                if (!map.containsKey(keyName[i])) {
                    map.put(keyName[i], new ArrayList<>());
                }
                map.get(keyName[i]).add(keyTime[i]);
            }

            for(var e : map.entrySet()){
                List<String> times = e.getValue();
                if(times.size() < 3){
                    continue;
                }
                times.sort((a, b) -> a.compareTo(b));
                for(int i = 2; i < times.size(); i++){
                    if (cal(times.get(i-2), times.get(i)) <= 60) {
                        rlist.add(e.getKey());
                        break;
                    }
                }
            }

            rlist.sort((a, b) -> {
                return a.compareTo(b);
            });

            return rlist;
        }

        private int cal(String a, String b) {
            String[] sa = a.split(":");
            String[] sb = b.split(":");
            int res = Integer.parseInt(sb[0]) * 60 + Integer.parseInt(sb[1]);
            res -= (Integer.parseInt(sa[0]) * 60 + Integer.parseInt(sa[1]));
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}