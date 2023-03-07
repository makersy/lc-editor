/**
 * 如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
 * <p>
 * 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
 * <p>
 * <p>
 * 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
 * <p>
 * <p>
 * <p>
 * 例如，表达式 "a" 表示字符串 "a"。
 * 而表达式 "w" 就表示字符串 "w"。
 * <p>
 * <p>
 * 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * <p>
 * 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
 * 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
 * <p>
 * <p>
 * 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, b)
 * in R(e_1) × R(e_2)}
 * <p>
 * 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
 * <p>
 * <p>
 * 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * <p>
 * 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"。
 * 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg",
 * "acdfh", "acefg", "acefh"。
 * <p>
 * <p>
 * <p>
 * <p>
 * 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
 * <p>
 * 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：expression = "{a,b}{c,{d,e}}"
 * 输出：["ac","ad","ae","bc","bd","be"]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：expression = "{{a,z},a{b,c},{ab,z}}"
 * 输出：["a","ab","ac","z"]
 * 解释：输出中 不应 出现重复的组合结果。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= expression.length <= 60
 * expression[i] 由 '{'，'}'，',' 或小写英文字母组成
 * 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 * <p>
 * <p>
 * Related Topics 栈 广度优先搜索 字符串 回溯 👍 172 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class BraceExpansionIi {
    public static void main(String[] args) {
        //Solution solution = new BraceExpansionIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String expression;
        int idx;

        public List<String> braceExpansionII(String expression) {
            this.expression = expression;
            this.idx = 0;
            Set<String> ret = expr();
            return new ArrayList<String>(ret);
        }

        // item . letter | { expr }
        private Set<String> item() {
            Set<String> ret = new TreeSet<String>();
            if (expression.charAt(idx) == '{') {
                idx++;
                ret = expr();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(expression.charAt(idx));
                ret.add(sb.toString());
            }
            idx++;
            return ret;
        }

        // term . item | item term
        private Set<String> term() {
            // 初始化空集合，与之后的求解结果求笛卡尔积
            Set<String> ret = new TreeSet<String>() {{
                add("");
            }};
            // item 的开头是 { 或小写字母，只有符合时才继续匹配
            while (idx < expression.length() && (expression.charAt(idx) == '{' || Character.isLetter(expression.charAt(idx)))) {
                Set<String> sub = item();
                Set<String> tmp = new TreeSet<String>();
                for (String left : ret) {
                    for (String right : sub) {
                        tmp.add(left + right);
                    }
                }
                ret = tmp;
            }
            return ret;
        }

        // expr . term | term, expr
        private Set<String> expr() {
            Set<String> ret = new TreeSet<String>();
            while (true) {
                // 与 term() 求解结果求并集
                ret.addAll(term());
                // 如果匹配到逗号则继续，否则结束匹配
                if (idx < expression.length() && expression.charAt(idx) == ',') {
                    idx++;
                    continue;
                } else {
                    break;
                }
            }
            return ret;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}