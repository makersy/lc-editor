/**
给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。



 示例 1：


输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]


 示例 2：


输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

 示例 3：


输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]


 示例 4：


输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]


 示例 5：


输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]




 提示：


 0 <= intervals.length <= 10⁴
 intervals[i].length == 2
 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵
 intervals 根据 intervals[i][0] 按 升序 排列
 newInterval.length == 2
 0 <= newInterval[0] <= newInterval[1] <= 10⁵


 Related Topics 数组 👍 787 👎 0

*/

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class InsertInterval{
    public static void main(String[] args) {
        //Solution solution = new InsertInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i;
        boolean added = false;

        for (i = 0; i < len; i++) {
            var arr = intervals[i];
            if (newInterval[0] <= arr[1]) {
                if (newInterval[1] < arr[0]) {
                    list.add(newInterval);
                    list.add(arr);
                    added = true;
                    i++;
                    break;
                } else {
                    int l = Math.min(arr[0], newInterval[0]), r = Math.max(arr[1], newInterval[1]);
                    while (++i < len && r >= intervals[i][0]) {
                        r = Math.max(intervals[i][1], r);
                    }
                    list.add(new int[]{l, r});
                    added = true;
                    break;
                }
            } else {
                list.add(arr);
            }
        }

        while (i < len) {
            list.add(intervals[i++]);
        }

        if (!added) {
            list.add(newInterval);
        }

        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}