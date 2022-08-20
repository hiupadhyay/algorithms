package leetcode;

import com.source.leetcode.QuestionNo104;
import com.source.leetcode.datastructure.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionNo104Test {

    private TreeNode getTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        return treeNode;
    }

    @Test
    public void testMaxDepth() {
        QuestionNo104 questionNo104 = new QuestionNo104();
        final int result = questionNo104.maxDepth(this.getTreeNode());
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void testMaxDepthUsingQueue() {
        QuestionNo104 questionNo104 = new QuestionNo104();
        final int result = questionNo104.maxDepthUsingQueue(this.getTreeNode());
        Assertions.assertThat(result).isEqualTo(3);
    }
}
