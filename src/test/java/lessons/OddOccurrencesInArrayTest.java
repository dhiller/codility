package lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class OddOccurrencesInArrayTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OddOccurrencesInArrayTest.class);

    @Parameterized.Parameters(name = "{index}: solution({0}), is({1})")
    public static List<Object[]> data() {
        return Arrays.asList(
                new Object[]{new int[]{9, 3, 9, 3, 9, 7, 9}, 7},
                new Object[]{new int[]{42}, 42},
                new Object[]{new int[]{42, 42, 42}, 42},
                createRandomizedSequence(1001),
                createRandomizedSequence((long) Math.pow(10, 5) + 1),
                createRandomizedSequence((long) Math.pow(10, 6) + 1),
                createRandomizedSequence((long) Math.pow(10, 7) + 1)
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

    private static Object[] createRandomizedSequence(long size) {
        final long start = System.currentTimeMillis();
        log.info("Creating randomized sequence of size {}", size);
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive!");
        }
        if (size % 2 == 0) {
            throw new IllegalArgumentException("size must be odd!");
        }
        final Random random = new Random(42L);
        final int[] ints = IntStream.generate(() -> Math.abs(random.nextInt())).limit(size / 2).toArray();
        final int singleElementIndex = (Math.abs(random.nextInt())) % ints.length;
        final List<Integer> result = new ArrayList<>();
        int singleElement = -1;
        for (int index = 0; index < ints.length; index++) {
            result.add(ints[index]);
            if (index != singleElementIndex) {
                result.add(ints[index]);
            } else {
                singleElement = ints[index];
            }
        }
        Collections.shuffle(result);
        final int[] resultArray = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            resultArray[index] = result.get(index);
        }
        log.info("Creating randomized sequence of size {} finished in {} msecs", size, System.currentTimeMillis() - start);
        return new Object[]{resultArray, singleElement};
    }

}
