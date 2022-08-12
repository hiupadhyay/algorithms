import com.source.leetcode.QuestionNo226;
import com.source.leetcode.datastructure.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionNo226Test {

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
    public void invertedTreeShouldHaveCorrectResult() {
        final QuestionNo226 questionNo226 = new QuestionNo226();
        final TreeNode result = questionNo226.invertBinaryTree(treeNode);
        Assertions.assertThat(result.left.getVal()).isEqualTo(20);
        Assertions.assertThat(result.right.getVal()).isEqualTo(9);
        Assertions.assertThat(result.left.right.getVal()).isEqualTo(15);
        Assertions.assertThat(result.left.left.getVal()).isEqualTo(7);

    }
}
