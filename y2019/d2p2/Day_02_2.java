package nl.ndoorn.adventofcode.y2019.d2p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nl.ndoorn.adventofcode.util.Util;

public class Day_02_2 {
    /*
     * Link: https://adventofcode.com/2019/day/2#part2
     */

    public static final int EXPECTED_OUTPUT = 19690720;

    public static void main(String[] args) {
        String fileInput = Util.Input.getLine(args[0], "");
        List<Integer> input = Arrays.stream(fileInput.split(","))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        final int maxValue = 100;

        for (int noun = 0; noun < maxValue; noun++) {
            for (int verb = 0; verb < maxValue; verb++) {
                List<Integer> program = new ArrayList<>(input);

                int output = run(program, noun, verb);

                if (output == EXPECTED_OUTPUT) {
                    int answer = noun * 100 + verb;

                    Util.Log.i(
                        "FOUND RESULT: noun={%d}, verb={%d}, answer={%d}",
                        noun, verb, answer
                    );

                    System.exit(0);
                }
            }
        }

        Util.Log.e("No output found");
    }

    public static int run(List<Integer> program, int noun, int verb) {
        int programCounter = 0;

        program.set(1, noun);
        program.set(2, verb);

        while (true) {
            int opCode = program.get(programCounter);

            switch (opCode) {
                case 1:
                    add(program, programCounter);
                    break;

                case 2:
                    multiply(program, programCounter);
                    break;

                case 99:
                    return program.get(0);

                default:
                    Util.Log.e("You broke the system, opCode={%d}", opCode);
                    return -1;
            }

            programCounter += 4;
        }
    }

    private static void add(List<Integer> program, int programCounter) {
        int posA = program.get(programCounter + 1);
        int posB = program.get(programCounter + 2);
        int posC = program.get(programCounter + 3);

        int A = program.get(posA);
        int B = program.get(posB);
        int result = A + B;

        program.set(posC, result);
    }

    private static void multiply(List<Integer> program, int programCounter) {
        int posA = program.get(programCounter + 1);
        int posB = program.get(programCounter + 2);
        int posC = program.get(programCounter + 3);

        int A = program.get(posA);
        int B = program.get(posB);
        int result = A * B;

        program.set(posC, result);
    }
}
