/**
给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 
arr 的最大排列。 

 如果无法这么操作，就请返回原数组。 

 

 示例 1： 

 
输入：arr = [3,2,1]
输出：[3,1,2]
解释：交换 2 和 1
 

 示例 2： 

 
输入：arr = [1,1,5]
输出：[1,1,5]
解释：已经是最小排列
 

 示例 3： 

 
输入：arr = [1,9,4,6,7]
输出：[1,7,4,6,9]
解释：交换 9 和 7
 

 

 提示： 

 
 1 <= arr.length <= 10⁴ 
 1 <= arr[i] <= 10⁴ 
 

 Related Topics 贪心 数组 👍 110 👎 0

*/

package com.makersy.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

class PreviousPermutationWithOneSwap{
    public static void main(String[] args) {
        //Solution solution = new PreviousPermutationWithOneSwap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        map.computeIfAbsent(arr[len - 1], k -> new LinkedList<>()).add(len - 1);
        for (int i = len - 1; i >= 0; i--) {
            var low = map.lowerEntry(arr[i]);
            if (low == null) {
                map.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
            }else{
                swap(arr, i, low.getValue().peekLast());
                return arr;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}