/**
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的 后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1] 输出：[1,2,3,4,5,6,7]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: preorder = [1], postorder = [1] 输出: [1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= preorder.length <= 30 1 <= preorder[i] <= preorder.length preorder 中所有值都 不同 postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length postorder 中所有值都 不同 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
 * <p>
 * <p>
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 367 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String[] args) {
        //Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {

        Map<Integer, Integer> map;

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < postorder.length; ++i) {
                map.put(postorder[i], i);
            }
            return help(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode help(int[] pre, int pres, int pree, int[] post, int posts, int poste) {
            if (pres > pree || posts > poste) {
                return null;
            }
            if (pres == pree) {
                return new TreeNode(pre[pres]);
            }
            TreeNode root = new TreeNode(pre[pres]);
            int index = map.get(pre[pres + 1]);
            root.left = help(pre, pres + 1, pres + index - posts + 1, post, posts, index);
            root.right = help(pre, pres + index - posts + 2, pree, post, index + 1, poste);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}