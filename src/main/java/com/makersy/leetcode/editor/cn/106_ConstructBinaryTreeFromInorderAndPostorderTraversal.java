/**
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回
这颗 二叉树 。 

 

 示例 1: 
 
 
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
 

 示例 2: 

 
输入：inorder = [-1], postorder = [-1]
输出：[-1]
 

 

 提示: 

 
 1 <= inorder.length <= 3000 
 postorder.length == inorder.length 
 -3000 <= inorder[i], postorder[i] <= 3000 
 inorder 和 postorder 都由 不同 的值组成 
 postorder 中每一个值都在 inorder 中 
 inorder 保证是树的中序遍历 
 postorder 保证是树的后序遍历 
 

 Related Topics 树 数组 哈希表 分治 二叉树 👍 1188 👎 0

*/

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        //Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode help(int[] inorder, int ins, int ine, int[] postorder, int pos, int poe) {
        if (ins > ine || pos > poe) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[poe]);
        int index = map.get(postorder[poe]);
        node.left = help(inorder, ins, index - 1, postorder, pos, pos + index - ins - 1);
        node.right = help(inorder, index + 1, ine, postorder, pos + index - ins, poe - 1);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}