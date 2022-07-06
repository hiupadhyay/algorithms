package practise.easy;

import java.util.Stack;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            if (node.val > low)
                stack.push(node.left);
            if (node.val < high)
                stack.push(node.right);
            if (node.val >= low && node.val <= high)
                sum += node.val;

        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);
        node.right = new TreeNode(15);
        node.right.right = new TreeNode(18);
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(node, 7, 15));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
