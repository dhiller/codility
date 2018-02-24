package tests;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

class NonEnclosedInteger {

    private static final int MAX_VALUE = 1000001;

    public int solution1Wrong(int[] A) {
        if (A.length == 1) {
            return Math.max(A[0] + 1, 1);
        }
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0 && A[i] > A[i - 1] + 1) {
                return A[i - 1] + 1;
            }
        }
        return A[A.length - 1] + 1;
    }

    public int solution2Wrong(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] <= 0) {
                continue;
            }
            if (A[i] < A[i + 1] - 1) {
                return A[i] + 1;
            }
        }
        return Math.max(A[A.length - 1] + 1, 1);
    }

    public int solution3Wrong(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0 && A[i] > min)
                return min;
            min = A[i] + 1;
        }
        return A[A.length - 1] + 1;
    }

    public int solution4Succeeds(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < MAX_VALUE; i++) {
            if (Arrays.binarySearch(A, i) < 0) {
                return i;
            }
        }
        return A[A.length - 1] + 1;
    }

    public int solution5OOfNSquare(int[] A) {
        final SortedSet<Integer> integers = new TreeSet<>();
        for (int i : A)
            integers.add(i);
        return IntStream.range(1, MAX_VALUE)
                .filter(i -> !integers.contains(i))
                .min().orElse(integers.last() + 1);
    }

    public int solution6(int[] A) {
        int smallestNonContained = 1;
        for (int current : IntStream.of(A).filter(i -> i > 0).sorted().toArray()) {
            if (smallestNonContained < current)
                return smallestNonContained;
            smallestNonContained = current + 1;
        }
        return smallestNonContained;
    }

    //    Find the smallest positive integer that does not occur in a given sequence.
    //            Task Score
    //88%
    //    Correctness
    //100%
    //    Performance
    //75%
    public int solution7(int[] A) {
        int smallestNonContained = 1;
        for (int current : IntStream.of(A).filter(i -> i > 0).sorted().toArray()) {
            if (smallestNonContained < current)
                return smallestNonContained;
            smallestNonContained = current + 1;
        }
        return smallestNonContained;
    }

    //1. MissingInteger
    //    Find the smallest positive integer that does not occur in a given sequence.
    //            Task Score
    //100%
    //    Correctness
    //100%
    //    Performance
    //100%

    public int solution8(int[] A) {
        Arrays.sort(A);
        int smallestNonContained = 1;
        for (int current : A) {
            if (current <= 0)
                continue;
            if (smallestNonContained < current)
                return smallestNonContained;
            smallestNonContained = current + 1;
        }
        return Math.max(smallestNonContained, 1);
    }

}