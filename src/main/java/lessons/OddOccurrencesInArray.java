package lessons;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OddOccurrencesInArray {

    //    Find value that occurs in odd number of elements.
    //            Task Score
    //88%
    //    Correctness
    //100%
    //    Performance
    //75%
    public int solution(int[] A) {
        final Map<Integer, AtomicInteger> numbersWithCounters = new LinkedHashMap<>();
        for (int element : A) {
            final AtomicInteger counter = numbersWithCounters.getOrDefault(element, new AtomicInteger(0));
            counter.incrementAndGet();
            numbersWithCounters.put(element, counter);
        }
        return numbersWithCounters.entrySet()
                .stream()
                .filter(e -> e.getValue().get() % 2 > 0)
                .findFirst()
                .get()
                .getKey();
    }

}
