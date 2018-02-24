package lessons;

public class BinaryGap {

    //    Find longest sequence of zeros in binary representation of an integer.
    //            Task Score
    //100%
    //    Correctness
    //100%
    public int solution(int N) {
        final String binaryString = Integer.toBinaryString(N);
        int indexOfCurrentBit = binaryString.indexOf("1");
        int maxGap = 0;
        do {
            final int indexOfNextBit = binaryString.indexOf("1", indexOfCurrentBit + 1);
            if (indexOfNextBit > -1) {
                int newMaxGap = indexOfNextBit - indexOfCurrentBit - 1;
                maxGap = Math.max(newMaxGap, maxGap);
            }
            indexOfCurrentBit = indexOfNextBit;
        } while (indexOfCurrentBit > -1);
        return maxGap;
    }

}
