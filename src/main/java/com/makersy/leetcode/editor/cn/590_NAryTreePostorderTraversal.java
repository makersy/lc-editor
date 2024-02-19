/**
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6] 输出：[5,6,3,2,4,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12, null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点总数在范围 [0, 10⁴] 内 0 <= Node.val <= 10⁴ n 叉树的高度小于或等于 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * Related Topics 栈 树 深度优先搜索 👍 318 👎 0
 */

package com.makersy.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class NAryTreePostorderTraversal {

    public static void main(String[] args) {
        //Solution solution = new NAryTreePostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {

        public List<Integer> postorder(Node root) {
            LinkedList<Integer> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Deque<Node> stk = new ArrayDeque<>();
            stk.offer(root);
            while (!stk.isEmpty()) {
                root = stk.pollLast();
                ans.addFirst(root.val);
                for (Node child : root.children) {
                    stk.offer(child);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}