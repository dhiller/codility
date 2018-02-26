package tests.atos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class IncorrectCodeTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IncorrectCodeTest.class);

    @Parameterized.Parameters(name = "{index}: solution({0}), is({1})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{new int[]{1, 1, 2, 3, 3}, 3, true},
                new Object[]{new int[]{1, 1, 3}, 3, false},
                new Object[]{new int[]{1, 2, 3, 4, 5}, 6, false},
                new Object[]{new int[]{2, 3, 4, 5}, 5, false}
        );
    }

    private IncorrectCode incorrectCode = new IncorrectCode();

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(1)
    public int max;

    @Parameterized.Parameter(2)
    public boolean result;

    @Test
    public void checkSolution1() {
        final boolean solution = incorrectCode.solution(input, max);
        assertThat(solution, is(result));
    }

    private static Object[] createRandomizedSequence(long size) {
        final long start = System.currentTimeMillis();
        log.info("Creating randomized sequence of size {}", size);
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive!");
        }
        if (size % 2 != 0) {
            throw new IllegalArgumentException("size must be even!");
        }
        final Random random = new Random(42L);
        final int[] ints = IntStream.generate(() -> Math.abs(random.nextInt())).limit(size).toArray();
        log.info("Creating randomized sequence of size {} finished in {} msecs", size,
                System.currentTimeMillis() - start);
        return new Object[]{ints, -1};
    }

}
