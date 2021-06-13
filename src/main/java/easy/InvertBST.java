package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBST {

    public static void main(String[] args) {
        BST root = new BST(4);
        root.left = new BST(2);
        root.right = new BST(7);
        root.left.left = new BST(1);
        root.left.right = new BST(3);
        root.right.left = new BST(6);
        root.right.right = new BST(9);
        InvertBST bst = new InvertBST();
        BST output = bst.invert(root);
        bst.print(output);

    }

    private void print(BST output) {
        Queue<BST> bsts = new LinkedList<>();
        bsts.add(output);
        while (!bsts.isEmpty()) {
            int size = bsts.size();
            for (int i = 0; i < size; i++) {
                BST current = bsts.poll();
                System.out.print(current.val + "\t");
                if (current.left != null)
                    bsts.add(current.left);
                if (current.right != null)
                    bsts.add(current.right);
            }

        }
    }

    private BST invert(BST root) {
        BST output = root;
        Stack<BST> stack = new Stack<>();
        stack.push(output);
        while (!stack.isEmpty()) {
            BST cu = stack.pop();
            BST temp = cu.left;
            cu.left = cu.right;
            cu.right = temp;
            if (cu.left != null)
                stack.push(cu.left);
            if (cu.right != null)
                stack.push(cu.right);
        }
        return output;
    }

}

class BST {
    BST left;
    BST right;
    int val;

    BST(int val) {
        this.val = val;
    }
}