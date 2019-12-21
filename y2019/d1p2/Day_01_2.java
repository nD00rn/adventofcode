package nl.ndoorn.adventofcode.y2019.d1p2;

import java.util.List;
import java.util.stream.Collectors;
import nl.ndoorn.adventofcode.util.Util;

public class Day_01_2 {
    /*
     * link: https://adventofcode.com/2019/day/1#part2
     */

    public static void main(String[] args) {
        List<String> inputStrings = Util.Input.getLines(args[0]);
        List<Integer> input = inputStrings.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        int sum = input.stream()
            .mapToInt(Day_01_2::calculateFuel)
            .sum();

        Util.Log.i(
            "Calculated fuel for all modules (including fuel weight), answer={%d}",
            sum
        );
    }

    private static int calculateFuel(int mass) {
        int fuelRequired = Math.max(0, mass / 3 - 2);

        if (fuelRequired > 0) {
            fuelRequired += calculateFuel(fuelRequired);
        }

        return fuelRequired;
    }
}
