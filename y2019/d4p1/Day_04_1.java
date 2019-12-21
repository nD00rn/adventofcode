package nl.ndoorn.adventofcode.y2019.d4p1;

import java.util.List;
import nl.ndoorn.adventofcode.util.Util;

public class Day_04_1 {
    public static void main(String[] args) {
        List<String> fileInput = Util.Input.getLines(args[0]);

        String puzzleInput = fileInput.get(0);

        new Day_04_1().start(puzzleInput);
    }

    private void start(String input) {
        String[] range = input.split("-");

        int min = Integer.valueOf(range[0]);
        int max = Integer.valueOf(range[1]);

        Util.Log.i(
            "min={%d}, max={%d}",
            min, max
        );

        int count = 0;
        int number = min;

        while (number < max) {
            boolean valid = isValidPassword(number);
            if (valid) {
                count++;
            }
            number++;
        }

        Util.Log.i(
            "Found {%d} valid passwords",
            count
        );
    }

    private boolean isValidPassword(int input) {
        String value = String.valueOf(input);

        boolean containsDouble = false;
        int lastNumber = -1;

        for (int number : value.chars().toArray()) {
            if (number == lastNumber) {
                containsDouble = true;
            }

            if (number < lastNumber) {
                return false;
            }

            lastNumber = number;
        }

        return containsDouble;
    }
}
