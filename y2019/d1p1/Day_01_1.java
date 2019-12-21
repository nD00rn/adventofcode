package nl.ndoorn.adventofcode.y2019.d1p1;

import java.util.List;
import java.util.stream.Collectors;
import nl.ndoorn.adventofcode.util.Util;

public class Day_01_1 {
    /*
     * link: https://adventofcode.com/2019/day/1
     */

    public static void main(String[] args) {
        List<String> inputStrings = Util.Input.getLines(args[0]);
        List<Integer> input = inputStrings.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        long sum = 0L;
        for (long mass : input) {
            long fuel = calculateFuel(mass);
            sum += fuel;
        }

        Util.Log.i("Required fuel for all modules is %d", sum);
    }

    private static long calculateFuel(long mass) {
        return mass / 3 - 2;
    }
}
