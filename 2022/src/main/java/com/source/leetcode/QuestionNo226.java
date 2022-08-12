package com.source.leetcode;

import java.util.Stack;

import com.source.leetcode.datastructure.TreeNode;

public class QuestionNo226 {

    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            final TreeNode currentNode = stack.pop();
            //swap node logic
            final TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        return root;
    }
}
