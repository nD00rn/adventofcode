package nl.ndoorn.adventofcode;

public class Day_02_2 {
    /*
     * Link: https://adventofcode.com/2019/day/2#part2
     */

    public static final int EXPECTED_OUTPUT = 19690720;

    public static void main(String[] args) {
        final int maxValue = 100;

        for (int noun = 0; noun < maxValue; noun++) {
            for (int verb = 0; verb < maxValue; verb++) {
                int output = run(noun, verb);

                if (output == EXPECTED_OUTPUT) {
                    System.out.println(String.format(
                        "FOUND RESULT: noun={%d}, verb={%d}",
                        noun, verb
                    ));

                    System.exit(0);
                }
            }
        }

        System.err.println("No output found.");
    }

    public static int run(int noun, int verb) {
        final int[] PROGRAM = new int[]{
            1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19,
            5, 23, 2, 10, 23, 27, 2, 27, 13, 31, 1, 10, 31, 35, 1, 35, 9, 39, 2,
            39, 13, 43, 1, 43, 5, 47, 1, 47, 6, 51, 2, 6, 51, 55, 1, 5, 55, 59,
            2, 9, 59, 63, 2, 6, 63, 67, 1, 13, 67, 71, 1, 9, 71, 75, 2, 13, 75,
            79, 1, 79, 10, 83, 2, 83, 9, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 13,
            95, 99, 1, 99, 5, 103, 1, 103, 2, 107, 1, 107, 10, 0, 99,
            2, 0, 14, 0
        };

        int programCounter = 0;

        PROGRAM[1] = noun;
        PROGRAM[2] = verb;

        while (true) {
            int opCode = PROGRAM[programCounter];

            switch (opCode) {
                case 1:
                    add(PROGRAM, programCounter);
                    break;

                case 2:
                    multiply(PROGRAM, programCounter);
                    break;

                case 99:
                    return PROGRAM[0];

                default:
                    System.err.println("You broke the system");
                    System.err.println("opcode = " + opCode);
                    return -1;
            }

            programCounter += 4;
        }
    }

    public static void add(int[] PROGRAM, int programCounter) {
        int posA = PROGRAM[programCounter + 1];
        int posB = PROGRAM[programCounter + 2];
        int posC = PROGRAM[programCounter + 3];

        int A = PROGRAM[posA];
        int B = PROGRAM[posB];
        int result = A + B;

        PROGRAM[posC] = result;
    }

    public static void multiply(int[] PROGRAM, int programCounter) {
        int posA = PROGRAM[programCounter + 1];
        int posB = PROGRAM[programCounter + 2];
        int posC = PROGRAM[programCounter + 3];

        int A = PROGRAM[posA];
        int B = PROGRAM[posB];
        int result = A * B;

        PROGRAM[posC] = result;
    }
}
