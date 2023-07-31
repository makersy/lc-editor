/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * <p>
 * 请将其重新排列后变为：
 * <p>
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 5 * 10⁴]
 * 1 <= node.val <= 1000
 * <p>
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 1307 👎 0
 */

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.ListNode;

import java.security.Key;

class ReorderList {
    public static void main(String[] args) {
        //Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            int len = len(head);
            if(len < 3) return;

            ListNode cur = head;
            for (int i = 0; i < (len-1) / 2; i++) {
                cur = cur.next;
            }
            ListNode temp = cur.next;
            cur.next = null;

            ListNode cur1 = reverse(temp);
            cur = head;
            temp = new ListNode();

            boolean flag = true;
            while (cur != null || cur1 != null) {
                if (flag) {
                    if (cur != null) {
                        temp.next = cur;
                        cur = cur.next;
                        temp = temp.next;
                    }
                } else {
                    if (cur1 != null) {
                        temp.next = cur1;
                        cur1 = cur1.next;
                        temp = temp.next;
                    }
                }
                flag = !flag;
            }

        }

        private Integer len(ListNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + len(node.next);
        }

        private ListNode reverse(ListNode node) {
            if(node == null || node.next == null) return node;
            ListNode res = reverse(node.next);
            node.next.next = node;
            node.next = null;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}