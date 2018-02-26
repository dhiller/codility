package tests.atos;

import org.junit.Ignore;
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
public class MaryHasNCandiesTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MaryHasNCandiesTest.class);

    @Parameterized.Parameters(name = "{index}: solution({0}), is({1})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{new int[]{3, 4, 7, 7, 6, 6}, 3},
                new Object[]{new int[]{80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}, 3},
                new Object[]{new int[]{1, 1, 2, 2}, 2},
                new Object[]{new int[]{1, 1, 1, 1}, 1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4},
                createRandomizedSequence((long)Math.pow(10,6)),
                createRandomizedSequence((long)Math.pow(10,8))
        );
    }

    private MaryHasNCandies maryHasNCandies = new MaryHasNCandies();

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(1)
    public int result;

    @Ignore
    @Test
    public void checkSolution1() {
        final int solution = maryHasNCandies.solution1(input);
        if (result != -1)
            assertThat(solution, is(result));
    }

    @Test
    public void checkSolution2() {
        final int solution = maryHasNCandies.solution2(input);
        if (result != -1)
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
