package com.makersy.leetcode.editor.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author yanghaolin
 * @date 2023/1/31
 * @description
 */

@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
