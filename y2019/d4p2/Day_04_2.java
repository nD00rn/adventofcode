package nl.ndoorn.adventofcode.y2019.d4p2;

import java.util.List;
import nl.ndoorn.adventofcode.util.Util;

public class Day_04_2 {
    public static void main(String[] args) {
        List<String> fileInput = Util.Input.getLines(args[0]);

        String puzzleInput = fileInput.get(0);

        new Day_04_2().start(puzzleInput);
    }

    private void start(String input) {
        String[] range = input.split("-");

        int min = Integer.valueOf(range[0]);
        int max = Integer.valueOf(range[1]);

        int count = 0;
        int number = min;

        while (number < max) {
            boolean isValid = isValidPassword(number);

            number++;
            if (isValid) {
                count++;
            }
        }

        Util.Log.i(
            "Found {%d} valid passwords in range {%d-%d}",
            count, min, max
        );
    }

    private boolean isValidPassword(int input) {
        String value = String.valueOf(input);

        boolean containsDouble = false;

        int lastNumber = -1;
        int streak = 0;
        boolean changedValue = true;

        for (int number : value.chars().toArray()) {
            if (number == lastNumber) {
                streak = changedValue
                    ? 2
                    : streak + 1
                    ;

                changedValue = false;
            } else {
                if (streak == 2) {
                    containsDouble = true;
                }
                streak = 1;
                changedValue = true;
            }

            if (number < lastNumber) {
                return false;
            }

            lastNumber = number;
        }

        return containsDouble || streak == 2;
    }

    // 215 is too low
    // 476 is too low
    // 564 is too low
    // 1186 is incorrect
}
