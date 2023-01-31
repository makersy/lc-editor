/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,10000
 * 03,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= list1.length <= 10⁴
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 10⁴
 * <p>
 * <p>
 * Related Topics 链表 👍 78 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.ListNode;

class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        //Solution solution = new MergeInBetweenLinkedLists().new Solution();
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
    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            int idx = 0;
            ListNode cur = list1, nodea = null, nodeb = null, tail2 = getTail(list2);
            while (cur != null) {
                idx++;
                if (idx == a) {
                    nodea = cur;
                }
                if (idx == b) {
                    nodeb = cur.next;
                    break;
                }
                cur = cur.next;
            }
            if (nodeb != null) nodeb = nodeb.next;
            nodea.next = list2;
            tail2.next = nodeb;
            return list1;
        }

        private ListNode getTail(ListNode node) {
            while (node != null && node.next != null) node = node.next;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}