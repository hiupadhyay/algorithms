package com.source.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.source.leetcode.datastructure.TreeNode;

public class QuestionNo104 {

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));

    }

    public int maxDepthUsingQueue(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();

            count++;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);

                }

            }
        }
        return count;

    }
}
