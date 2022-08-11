import com.source.leetcode.QuestionNo104;
import com.source.leetcode.datastructure.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionNo104Test {

    private TreeNode treeNode;

    @BeforeEach
    void setup() {
        treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
    }

    @Test
    public void testMaxDepth() {
        QuestionNo104 questionNo104 = new QuestionNo104();
        final int result = questionNo104.maxDepth(treeNode);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void testMaxDepthUsingQueue() {
        QuestionNo104 questionNo104 = new QuestionNo104();
        final int result = questionNo104.maxDepthUsingQueue(treeNode);
        Assertions.assertThat(result).isEqualTo(3);
    }
}
