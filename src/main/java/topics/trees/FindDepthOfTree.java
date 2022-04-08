package topics.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindDepthOfTree {

    private static int heightUsingRecursion(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(heightUsingRecursion(node.left), heightUsingRecursion(node.right));
    }

    private static int heightUsingQueue(Node node) {
        //base case
        if (node == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(node);
        while(true)
        {
            int size=queue.size();
            if(size==0)
                return count;
            count++;
            while(size>0)
            {
                Node tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                size--;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        System.out.println(FindDepthOfTree.heightUsingRecursion(root));
        System.out.println(FindDepthOfTree.heightUsingQueue(root));

    }
}

class Node {
    Node left;
    Node right;
    int val;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
