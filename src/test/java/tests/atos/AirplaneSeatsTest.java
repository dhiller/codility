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
public class AirplaneSeatsTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AirplaneSeatsTest.class);

    @Parameterized.Parameters(name = "{index}: solution(rows: {0}, reservedSeats: {1}), is({2})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{2, "1A 2F 1C", 4},
                new Object[]{1, " ", 3},
                new Object[]{1, "1D", 3},
                new Object[]{1, "1G", 3},
                new Object[]{1, "1E", 2},
                new Object[]{1, "1D 1G", 2},
                new Object[]{1, "1A 1D 1G 1H", 0},
                new Object[]{1, "", 3},
                new Object[]{0, "", 0}
        );
    }

    private AirplaneSeats airplaneSeats = new AirplaneSeats();

    @Parameterized.Parameter
    public int rows;

    @Parameterized.Parameter(1)
    public String reservedSeats;

    @Parameterized.Parameter(2)
    public int result;

    @Test
    public void checkSolution() {
        final int solution = airplaneSeats.solution(rows, reservedSeats);
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
