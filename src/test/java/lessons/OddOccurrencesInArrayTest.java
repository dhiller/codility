package lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class OddOccurrencesInArrayTest {

    @Parameterized.Parameters(name = "{index}: solution({0}), is({1})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{new int[]{9, 3, 9, 3, 9, 7, 9}, 7},
                new Object[]{new int[]{42}, 42},
                new Object[]{new int[]{42, 42, 42}, 42}
        );
    }

    private OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(1)
    public int result;

    @Test
    public void checkResult() {
        assertThat(oddOccurrencesInArray.solution(input), is(result));
    }

}
