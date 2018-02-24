package lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class BinaryGapTest {

    @Parameterized.Parameters(name = "{index}: binaryGap.solution({0}), is({1})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{1041, 5},
                new Object[]{0, 0},
                new Object[]{1024, 0},
                new Object[]{1025, 9}
        );
    }

    private BinaryGap binaryGap = new BinaryGap();

    @Parameterized.Parameter
    public int input;

    @Parameterized.Parameter(1)
    public int result;

    @Test
    public void checkResult() {
        assertThat(binaryGap.solution(input), is(result));
    }

}
