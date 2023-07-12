/**
给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号： 

 
 最高有效位 上的数字分配到 正 号。 
 剩余每位上数字的符号都与其相邻数字相反。 
 

 返回所有数字及其对应符号的和。 

 

 示例 1： 

 
输入：n = 521
输出：4
解释：(+5) + (-2) + (+1) = 4 

 示例 2： 

 
输入：n = 111
输出：1
解释：(+1) + (-1) + (+1) = 1
 

 示例 3： 

 
输入：n = 886996
输出：0
解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 

 

 提示： 

 
 1 <= n <= 10⁹ 
 

 

 Related Topics 数学 👍 44 👎 0

*/

package com.makersy.leetcode.editor.cn;

class AlternatingDigitSum{
    public static void main(String[] args) {
        //Solution solution = new AlternatingDigitSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int alternateDigitSum(int n) {
        int sum0 = 0, sum1 = 0;
        int cnt = 0;
        boolean flag = true;
        while (n > 0) {
            if (flag) {
                sum0 += n % 10;
            } else {
                sum1 += n % 10;
            }
            n /= 10;
            flag = !flag;
            cnt++;
        }
        if (cnt % 2 == 0) {
            return sum1 - sum0;
        } else {
            return sum0 - sum1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}