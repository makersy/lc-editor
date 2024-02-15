/**
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 

 

 示例 1： 
 
 
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
 

 示例 2： 

 
输入：root = [1]
输出：[[1]]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目在范围 [0, 2000] 内 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 广度优先搜索 二叉树 👍 779 👎 0

*/

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        //Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int h = getH(root);
        res = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            res.add(new ArrayList<>());
        }
        dfs(0, root);
        Collections.reverse(res);
        return res;
    }

    private void dfs(int level, TreeNode node) {
        if (node == null) {
            return;
        }
        res.get(level).add(node.val);
        dfs(level + 1, node.left);
        dfs(level + 1, node.right);
    }

    private int getH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getH(root.left), getH(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}