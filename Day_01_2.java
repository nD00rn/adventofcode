package nl.ndoorn.adventofcode;

import java.util.Arrays;

public class Day_01_2 {
    /*
     * During the second Go / No Go poll, the Elf in charge of the Rocket
     * Equation Double-Checker stops the launch sequence. Apparently, you forgot
     *  to include additional fuel for the fuel you just added.
     *
     * Fuel itself requires fuel just like a module - take its mass, divide by
     * three, round down, and subtract 2. However, that fuel also requires fuel,
     * and that fuel requires fuel, and so on. Any mass that would require
     * negative fuel should instead be treated as if it requires zero fuel; the
     * remaining mass, if any, is instead handled by wishing really hard, which
     * has no mass and is outside the scope of this calculation.
     *
     * So, for each module mass, calculate its fuel and add it to the total.
     * Then, treat the fuel amount you just calculated as the input mass and
     * repeat the process, continuing until a fuel requirement is zero or
     * negative. For example:um of the fuel requirements for all of the modules
     * on your spacecraft?
     *
     * A module of mass 14 requires 2 fuel. This fuel requires no further fuel
     * (2 divided by 3 and rounded down is 0, which would call for a negative
     * fuel), so the total fuel required is still just 2.
     * At first, a module of mass 1969 requires 654 fuel. Then, this fuel
     * requires 216 more fuel (654 / 3 - 2). 216 then requires 70 more fuel,
     * which requires 21 fuel, which requires 5 fuel, which requires no further
     * fuel. So, the total fuel required for a module of mass 1969 is
     * 654 + 216 + 70 + 21 + 5 = 966.
     * The fuel required by a module of mass 100756 and its fuel is:
     * 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.
     *
     * What is the sum of the fuel requirements for all of the modules on your
     * spacecraft when also taking into account the mass of the added fuel?
     * (Calculate the fuel requirements for each module separately, then add
     * them all up at the end.)
     *
     * link: https://adventofcode.com/2019/day/1#part2
     */

    private static final int[] INPUT = new int[]{
        54172, 58469, 92948, 143402, 57563, 54532, 68042, 89847, 70872, 54069,
        107310, 146439, 88851, 142869, 71309, 89613, 70338, 87708, 95305,
        134384, 128250, 134991, 91270, 127819, 68650, 102556, 129882, 68688,
        129939, 137344, 102624, 90828, 86487, 91712, 114866, 75697, 107599,
        99053, 87511, 128128, 57772, 69314, 90771, 145376, 100730, 142675,
        112731, 83985, 123565, 127325, 86597, 121772, 131992, 148859, 93348,
        77294, 119763, 74636, 95592, 79628, 78861, 68565, 88820, 134291, 69262,
        128678, 118216, 52799, 92731, 61600, 63477, 64016, 131872, 131412,
        146579, 104400, 99110, 63458, 144393, 54787, 148622, 91323, 61137,
        106082, 103644, 63795, 126648, 61489, 140964, 110963, 72696, 124370,
        110466, 139317, 108440, 148062, 89992, 145645, 70556, 95739
    };

    public static void main(String[] args) {
        long sum = Arrays.stream(INPUT)
            .mapToLong(Day_01_2::calculateFuel)
            .sum();

        System.out.println(String.format(
            "Required fuel for all modules (including fuel weight) is %d",
            sum
        ));
    }

    private static long calculateFuel(long mass) {
        long fuelRequired = Math.max(0, mass / 3 - 2);

        if (fuelRequired > 0) {
            fuelRequired += calculateFuel(fuelRequired);
        }

        return fuelRequired;
    }
}
