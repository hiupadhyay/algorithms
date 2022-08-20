package leetcode;

import com.source.leetcode.QuestionNo215;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class QuestionNo215Test {

    private static QuestionNo215 questionNo215;

    @BeforeAll
    static void setup() {
        questionNo215 = new QuestionNo215();
    }

    @Test
    void test_findKthLargestElementUsingDivideAndConquerWhenPivotNotPresentInBetweenStartEnd() {
        int[] elements = new int[]{33, 2, 1, 5, 6, 4, 20};
        int elementToFind = 3;
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(elements, elementToFind)).isEqualTo(6);
    }

    @Test
    void test_findKthLargestElementUsingDivideAndConquerWhenPivotPresentInBetweenStartEnd() {
        int[] elements = new int[]{33, 2, 1, 5, 6, 4, 20};
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(elements, 2)).isEqualTo(20);
    }

    @Test
    void test_findKthLargestElementUsingDivideAndConquerWhenInputIsInvalid() {
        int[] elements = new int[]{33, 2, 1, 5, 6, 4, 20};
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(null, 2)).isEqualTo(-1);
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(elements, 25)).isEqualTo(-1);
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(new int[]{}, 25)).isEqualTo(-1);
    }

    @Test
    void test_test_findKthLargestElementUsingDivideAndConquerForVeryLargeInput() {
        Assertions.assertThat(questionNo215.findKthLargestElementUsingDivideAndConquer(IntStream.range(1, 45000).unordered().toArray(), 10)).isEqualTo(45000 - 10);
        //TODO large input to emit heap-size related Failures can be asserted as well.
    }

}
