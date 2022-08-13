import com.source.leetcode.QuestionNo189;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionNo189Test {

    @Test
    void majorityElementIsFound() {
        int [] input=new int[]{2,2,1,1,1,2,2};
        QuestionNo189 questionNo189 = new QuestionNo189();
        final int result = questionNo189.findMajorityElement(input);
        Assertions.assertThat(result).isEqualTo(2);
    }
}
