/**
 * 给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。
 * <p>
 * 好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。换句话说，如果我们将 pos1v 记为值 v 在 nums1 中出现的位置，pos2v 为值 v 在 nums2
 * 中的位置，那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x < pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。
 * <p>
 * 请你返回好三元组的 总数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,0,1,3], nums2 = [0,1,2,3] 输出：1 解释： 总共有 4 个三元组 (x,y,z) 满足 pos1x < pos1y < pos1z ，分别是 (2,0,1) ，(2,0,3)
 * ，(2,1,3) 和 (0, 1,3) 。 这些三元组中，只有 (0,1,3) 满足 pos2x < pos2y < pos2z 。所以只有 1 个好三元组。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3] 输出：4 解释：总共有 4 个好三元组 (4,0,3) ，(4,0,2) ，(4,1,3) 和 (4,1,2) 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums1.length == nums2.length 3 <= n <= 10⁵ 0 <= nums1[i], nums2[i] <= n - 1 nums1 和 nums2 是 [0, 1, ..., n - 1]
 * 的排列。
 * <p>
 * <p>
 * Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 91 👎 0
 */

package com.makersy.leetcode.editor.cn;

class CountGoodTripletsInAnArray {

    public static void main(String[] args) {
        //Solution solution = new CountGoodTripletsInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FenwickTree {

        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }

    class Solution {

        public long goodTriplets(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] pos2 = new int[n], reversedIndexMapping = new int[n];
            for (int i = 0; i < n; i++) {
                pos2[nums2[i]] = i;
            }
            for (int i = 0; i < n; i++) {
                reversedIndexMapping[pos2[nums1[i]]] = i;
            }
            FenwickTree tree = new FenwickTree(n);
            long res = 0;
            for (int value = 0; value < n; value++) {
                int pos = reversedIndexMapping[value];
                int left = tree.query(pos);
                tree.update(pos, 1);
                int right = (n - 1 - pos) - (value - left);
                res += (long) left * right;
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}