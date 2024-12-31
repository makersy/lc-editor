/**
给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。 

 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。 


 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。 

 

 示例 1： 

 

 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1
,3]
输出：true
解释：树中蓝色的节点构成了与链表对应的子路径。
 

 示例 2： 

 

 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
null,1,3]
输出：true
 

 示例 3： 

 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
null,1,3]
输出：false
解释：二叉树中不存在一一对应链表的路径。
 

 

 提示： 

 
 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。 
 链表包含的节点数目在 1 到 100 之间。 
 二叉树包含的节点数目在 1 到 2500 之间。 
 

 Related Topics 树 深度优先搜索 链表 二叉树 👍 212 👎 0

*/

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.ListNode;
import com.makersy.leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class LinkedListInBinaryTree{
    public static void main(String[] args) {
        //Solution solution = new LinkedListInBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<Integer> list;

    public boolean isSubPath(ListNode head, TreeNode root) {
        list = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return dfs(0, root);
    }

    private boolean dfs(int idx, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == list.get(idx)) {
            if (idx == list.size() - 1) {
                return true;
            }
            if (dfs(idx + 1, node.left) || dfs(idx + 1, node.right)) {
                return true;
            }
        }
        return dfs(0, node.left) || dfs(0, node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}