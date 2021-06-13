package medium;

import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.nashorn.internal.ir.BinaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        BinaryTree binaryTree = new BinaryTree(3);
        binaryTree.left = new BinaryTree(9);
        binaryTree.right = new BinaryTree(20);
        binaryTree.right.left = new BinaryTree(15);
        binaryTree.right.right = new BinaryTree(7);
        List<List<Integer>> allNodes = binaryTreeLevelOrderTraversal.levelOrder(binaryTree);
        System.out.println(allNodes);
    }

    private List<List<Integer>> levelOrder(BinaryTree binaryTree) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        if (binaryTree == null) return result;
        queue.add(binaryTree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTree t = queue.poll();
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
                l.add(t.val);

            }
            result.add(l);
        }
        return result;
    }

}

class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int val;

    BinaryTree(int val) {
        this.val = val;
    }
}
