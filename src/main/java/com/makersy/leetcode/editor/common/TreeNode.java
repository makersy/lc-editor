package com.makersy.leetcode.editor.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author yanghaolin
 * @date 2023/1/17
 * @description
 */

@NoArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
