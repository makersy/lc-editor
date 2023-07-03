/**
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 

 

 示例1： 

 

 
输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]
 

 示例2： 

 
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]
 

 示例3： 

 
输入：l1 = [0], l2 = [0]
输出：[0]
 

 

 提示： 

 
 链表的长度范围为 [1, 100] 
 0 <= node.val <= 9 
 输入数据保证链表代表的数字无前导 0 
 

 

 进阶：如果输入链表不能翻转该如何解决？ 

 Related Topics 栈 链表 数学 👍 651 👎 0

*/

package com.makersy.leetcode.editor.cn;

import com.makersy.leetcode.editor.common.ListNode;

class AddTwoNumbersIi{
    public static void main(String[] args) {
        //Solution solution = new AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = reverse(l1), cur2 = reverse(l2);
        ListNode res = new ListNode(), cur = res;
        int base = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                base += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                base += cur2.val;
                cur2 = cur2.next;
            }

            cur.next = new ListNode(base % 10);
            cur = cur.next;
            base /= 10;
        }

        if (base > 0) {
            cur.next = new ListNode(base);
        }

        return reverse(res.next);
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode res = reverse(node.next);
        ListNode temp = node.next;
        temp.next = node;
        node.next = null;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}