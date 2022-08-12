package com.source.leetcode.datastructure;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    private int val;

    public TreeNode(int val) {
        this.left = this.right = null;
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
