package tests.atos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Correctness: 100%
public class AirplaneSeats {
    public int solution(int N, String S) {
        if (S.isEmpty()) {
            return N * 3;
        }
        final List<String>[] rows = new List[N];
        for (String seat : S.split(" ")) {
            final String column = seat.substring(seat.length() - 1);
            final int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            if (rows[row - 1] == null) {
                rows[row - 1] = new ArrayList<>();
            }
            final List<String> reservedSeats = rows[row - 1];
            reservedSeats.add(column);
        }
        int familySeats = 0;
        for (List<String> columns : rows) {
            if (columns == null) {
                familySeats += 3;
            } else {
                int maxFamilySeatsPerRow = 3;
                for (String col : Arrays.asList("A", "B", "C")) {
                    if (columns.contains(col)) {
                        maxFamilySeatsPerRow--;
                        break;
                    }
                }
                for (String col : Arrays.asList("H", "J", "K")) {
                    if (columns.contains(col)) {
                        maxFamilySeatsPerRow--;
                        break;
                    }
                }
                if (
                        columns.contains("E") ||
                                columns.contains("F") ||
                                (columns.contains("D") && columns.contains("G"))
                        ) {
                    maxFamilySeatsPerRow--;
                }
                familySeats += maxFamilySeatsPerRow;
            }
        }
        return familySeats;
    }
}
