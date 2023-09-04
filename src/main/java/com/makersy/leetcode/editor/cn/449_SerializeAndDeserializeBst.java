/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化
 * 为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数范围是 [0, 10⁴]
 * 0 <= Node.val <= 10⁴
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 495 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        // Solution solution = new SerializeAndDeserializeBst().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder("");
            traveTree(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            // TODO
            // System.out.println(data);
            List<Integer> nums = new ArrayList<>();
            for (String s : data.split(",")) nums.add(Integer.valueOf(s));
            // System.out.println(nums);
            return buildTree(nums, 0, nums.size() - 1);
        }

        private void traveTree(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            int val = root.val;

            if (sb.length() != 0) sb.append(",");
            sb.append(Integer.toString(val));

            traveTree(root.left, sb);
            traveTree(root.right, sb);
        }

        private TreeNode buildTree(List<Integer> nums, int start, int end) {
            if (start > end) return null;

            int val = nums.get(start);
            int mid = start + 1;
            while (mid <= end && nums.get(mid) < val) mid++;

            TreeNode node = new TreeNode(val);
            node.left = buildTree(nums, start + 1, mid - 1);
            node.right = buildTree(nums, mid, end);

            return node;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;


    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
    // leetcode submit region end(Prohibit modification and deletion)

}