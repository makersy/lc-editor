/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 261 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.*;

class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        //Solution solution = new DeleteNodesAndReturnForest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<TreeNode> roots;
        Set<Integer> dset;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            roots = new ArrayList<>();
            dset = new HashSet<>(to_delete.length);
            for (var n : to_delete) {
                dset.add(n);
            }
            dfs(root, true);
            return roots;
        }

        private TreeNode dfs(TreeNode node, boolean isRoot) {
            if (node == null) return null;
            boolean flag = dset.contains(node.val);
            node.left = dfs(node.left, flag);
            node.right = dfs(node.right, flag);

            if (flag) {
                return null;
            }
            if (isRoot) {
                roots.add(node);
                return null;
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}