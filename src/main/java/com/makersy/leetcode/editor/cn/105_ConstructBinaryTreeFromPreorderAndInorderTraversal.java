/**
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回
其根节点。 

 

 示例 1: 
 
 
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
 

 示例 2: 

 
输入: preorder = [-1], inorder = [-1]
输出: [-1]
 

 

 提示: 

 
 1 <= preorder.length <= 3000 
 inorder.length == preorder.length 
 -3000 <= preorder[i], inorder[i] <= 3000 
 preorder 和 inorder 均 无重复 元素 
 inorder 均出现在 preorder 
 preorder 保证 为二叉树的前序遍历序列 
 inorder 保证 为二叉树的中序遍历序列 
 

 Related Topics 树 数组 哈希表 分治 二叉树 👍 2238 👎 0

*/

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        //Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    private Map<Integer, Integer> idxMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxMap = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            idxMap.put(inorder[i], i);
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int pres, int pree, int[] inorder, int ins, int ine) {
        if(pres > pree || ins > ine) return null;
        TreeNode node = new TreeNode(preorder[pres]);
        int idx = idxMap.get(preorder[pres]);
        int size = idx - ins;
        node.left = help(preorder, pres + 1, pres + size, inorder, ins, idx);
        node.right = help(preorder, pres + size + 1, pree, inorder, idx + 1, ine);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}