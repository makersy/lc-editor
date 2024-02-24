/**
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * <p>
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * <p>
 * <p>
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * <p>
 * <p>
 * 返回数组 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * <p>
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * <p>
 * <p>
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [2, 10⁵] 内
 * 1 <= Node.val <= 10⁶
 * n == queries.length
 * 1 <= n <= 10⁵
 * 1 <= queries[i] <= 10⁶
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 数组 二分查找 二叉树 👍 67 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ClosestNodesQueriesInABinarySearchTree {
    public static void main(String[] args) {
        //Solution solution = new ClosestNodesQueriesInABinarySearchTree().new Solution();
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
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<List<Integer>> res = new ArrayList<>(queries.size());
            List<Integer> list = new ArrayList<>();
            inorder(list, root);

            for (Integer query : queries) {
                int i = Collections.binarySearch(list, query);
                if (i >= 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(query);
                    temp.add(query);
                    res.add(temp);
                } else {
                    i = -i - 1;
                    List<Integer> temp = new ArrayList<>();
                    if (i == 0) {
                        temp.add(-1);
                        temp.add(list.get(i));
                    } else if (i == list.size()) {
                        temp.add(list.get(i-1));
                        temp.add(-1);
                    } else {
                        temp.add(list.get(i - 1));
                        temp.add(list.get(i));
                    }
                    res.add(temp);
                }
            }

            return res;
        }

        void inorder(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(list, node.left);
            list.add(node.val);
            inorder(list, node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}