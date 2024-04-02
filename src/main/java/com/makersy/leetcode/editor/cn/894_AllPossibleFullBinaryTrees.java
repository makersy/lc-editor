/**
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * <p>
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * <p>
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0
 * ],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3 输出：[[0,0,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * <p>
 * <p>
 * Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 388 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class AllPossibleFullBinaryTrees {

    public static void main(String[] args) {
        //Solution solution = new AllPossibleFullBinaryTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {

        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> fullBinaryTrees = new ArrayList<TreeNode>();
            if (n % 2 == 0) {
                return fullBinaryTrees;
            }
            if (n == 1) {
                fullBinaryTrees.add(new TreeNode(0));
                return fullBinaryTrees;
            }
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> leftSubtrees = allPossibleFBT(i);
                List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);
                for (TreeNode leftSubtree : leftSubtrees) {
                    for (TreeNode rightSubtree : rightSubtrees) {
                        TreeNode root = new TreeNode(0, leftSubtree, rightSubtree);
                        fullBinaryTrees.add(root);
                    }
                }
            }
            return fullBinaryTrees;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}