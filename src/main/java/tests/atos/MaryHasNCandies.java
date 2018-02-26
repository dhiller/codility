package tests.atos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Correctness: 100%
// Performance: 100%
public class MaryHasNCandies {

    public int solution1(int[] T) {
        int toRemove = T.length / 2;
        final Map<Integer, AtomicInteger> candiesToCounts = new HashMap<>();
        for (int candyType : T) {
            final AtomicInteger candyTypeCount = candiesToCounts.getOrDefault(candyType, new AtomicInteger());
            if (candyTypeCount.incrementAndGet() == 1) {
                candiesToCounts.put(candyType, candyTypeCount);
            }
        }
        for (Map.Entry<Integer, AtomicInteger> e : candiesToCounts.entrySet()) {
            toRemove -= e.getValue().get() - 1;
        }
        return candiesToCounts.size() - Math.max(toRemove, 0);
    }

    public int solution2(int[] T) {
        int toRemove = T.length / 2;
        final Set<Integer> candies = new HashSet<>();
        for (int candyType : T) {
            if (candies.contains(candyType))
                toRemove--;
            else
                candies.add(candyType);
        }
        return candies.size() - Math.max(toRemove, 0);
    }

}
