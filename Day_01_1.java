package nl.ndoorn.adventofcode;

public class Day_01_1 {
    /*
     * Santa has become stranded at the edge of the Solar System while
     * delivering presents to other planets! To accurately calculate his
     * position in space, safely align his warp drive, and return to Earth in
     * time to save Christmas, he needs you to bring him measurements from fifty
     * stars.
     *
     * Collect stars by solving puzzles. Two puzzles will be made available on
     * each day in the Advent calendar; the second puzzle is unlocked when you
     * complete the first. Each puzzle grants one star. Good luck!
     * The Elves quickly load you into a spacecraft and prepare to launch.
     * At the first Go / No Go poll, every Elf is Go until the Fuel
     * Counter-Upper. They haven't determined the amount of fuel required yet.
     * Fuel required to launch a given module is based on its mass.
     * Specifically, to find the fuel required for a module, take its mass,
     * divide by three, round down, and subtract 2.
     *
     * For example:
     * For a mass of 12, divide by 3 and round down to get 4,
     * then subtract 2 to get 2.
     * For a mass of 14, dividing by 3 and rounding down still yields 4, so the
     * fuel required is also 2.
     * For a mass of 1969, the fuel required is 654.
     * For a mass of 100756, the fuel required is 33583.
     *
     * The Fuel Counter-Upper needs to know the total fuel requirement. To find
     * it, individually calculate the fuel needed for the mass of each module
     * (your puzzle input), then add together all the fuel values.
     *
     * What is the sum of the fuel requirements for all of the modules on your
     * spacecraft?
     *
     * link: https://adventofcode.com/2019/day/1
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
        long sum = 0L;
        for (long mass : INPUT) {
            long fuel = calculateFuel(mass);
            sum += fuel;
        }

        System.out.println("Required fuel for all modules is " + sum);
    }

    private static long calculateFuel(long mass) {
        return mass / 3 - 2;
    }
}
