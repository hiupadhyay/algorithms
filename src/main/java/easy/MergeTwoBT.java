package easy;

import java.util.Stack;

public class MergeTwoBT {
    public TreeNode mergeTreesUsingStack(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            //Pop next when t2 is null
            if (t[0] == null || t[1] == null) {
                continue;
            }

            t[0].val += t[1].val;

            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }

        }
        return t1;


    }

    public TreeNode mergeTreesRecursive(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTreesRecursive(t1.left, t2.left);
        t1.right = mergeTreesRecursive(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        MergeTwoBT mergeTwoBT = new MergeTwoBT();
        mergeTwoBT.mergeTreesRecursive(t1, t2);
    }
}
