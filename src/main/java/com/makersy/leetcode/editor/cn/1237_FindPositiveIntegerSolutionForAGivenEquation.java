/**
 * 给你一个函数 f(x, y) 和一个目标结果 z，函数公式未知，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。满足条件的结果数对可以
 * 按任意顺序返回。
 * <p>
 * 尽管函数的具体式子未知，但它是单调递增函数，也就是说：
 * <p>
 * <p>
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * <p>
 * <p>
 * 函数接口定义如下：
 * <p>
 * <p>
 * interface CustomFunction {
 * public:
 * // Returns some positive integer f(x, y) for two positive integers x and y
 * based on a formula.
 * int f(int x, int y);
 * };
 * <p>
 * 你的解决方案将按如下规则进行评判：
 * <p>
 * <p>
 * 判题程序有一个由 CustomFunction 的 9 种实现组成的列表，以及一种为特定的 z 生成所有有效数对的答案的方法。
 * 判题程序接受两个输入：function_id（决定使用哪种实现测试你的代码）以及目标结果 z 。
 * 判题程序将会调用你实现的 findSolution 并将你的结果与答案进行比较。
 * 如果你的结果与答案相符，那么解决方案将被视作正确答案，即 Accepted 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：function_id = 1, z = 5
 * 输出：[[1,4],[2,3],[3,2],[4,1]]
 * 解释：function_id = 1 暗含的函数式子为 f(x, y) = x + y
 * 以下 x 和 y 满足 f(x, y) 等于 5：
 * x=1, y=4 -> f(1, 4) = 1 + 4 = 5
 * x=2, y=3 -> f(2, 3) = 2 + 3 = 5
 * x=3, y=2 -> f(3, 2) = 3 + 2 = 5
 * x=4, y=1 -> f(4, 1) = 4 + 1 = 5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：function_id = 2, z = 5
 * 输出：[[1,5],[5,1]]
 * 解释：function_id = 2 暗含的函数式子为 f(x, y) = x * y
 * 以下 x 和 y 满足 f(x, y) 等于 5：
 * x=1, y=5 -> f(1, 5) = 1 * 5 = 5
 * x=5, y=1 -> f(5, 1) = 5 * 1 = 5
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
 * 在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。
 * <p>
 * <p>
 * Related Topics 数学 双指针 二分查找 交互 👍 95 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindPositiveIntegerSolutionForAGivenEquation {
    public static void main(String[] args) {
        //Solution solution = new FindPositiveIntegerSolutionForAGivenEquation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction cf, int z) {
            List<List<Integer>> res = new ArrayList<>();
            int l, r, mid, fres;

            for (int i = 1; i <= 1000; i++) {
                l = 1;
                r = 1000;
                while (l <= r) {
                    mid = (l + r) / 2;
                    fres = cf.f(i, mid);
                    if(fres == z){
                        res.add(Arrays.asList(i, mid));
                        break;
                    }else if(fres < z){
                        l = mid + 1;
                    }else {
                        r = mid - 1;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}