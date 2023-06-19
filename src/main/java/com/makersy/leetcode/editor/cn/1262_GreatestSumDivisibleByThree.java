/**
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 

 
 

 

 示例 1： 

 输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 

 示例 2： 

 输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 

 示例 3： 

 输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 

 

 提示： 

 
 1 <= nums.length <= 4 * 10^4 
 1 <= nums[i] <= 10^4 
 

 Related Topics 贪心 数组 动态规划 排序 👍 295 👎 0

*/

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class GreatestSumDivisibleByThree{
    public static void main(String[] args) {
        //Solution solution = new GreatestSumDivisibleByThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int temp = 0;
        for (int n : nums) {
            sum += n;
            temp = n % 3;
            if (temp == 0 && list0.size() < 2) {
                list0.add(n);
            } else if (temp == 1 && list1.size() < 2) {
                list1.add(n);
            } else if(temp == 2 && list2.size() < 2){
                list2.add(n);
            }
        }
        temp = sum % 3;
        if (temp == 0) {
            return sum;
        } else if (temp == 1) {
            int min = Integer.MAX_VALUE;
            if (!list1.isEmpty()) {
                min = list1.peekFirst();
            }
            if (list2.size() >= 2) {
                min = Math.min(min, list2.pollFirst() + list2.pollFirst());
            }
            return min == Integer.MAX_VALUE ? sum : sum - min;
        } else {
            int min = Integer.MAX_VALUE;
            if (!list2.isEmpty()) {
                min = list2.peekFirst();
            }
            if (list1.size() >= 2) {
                min = Math.min(min, list1.pollFirst() + list1.pollFirst());
            }
            return min == Integer.MAX_VALUE ? sum : sum - min;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}