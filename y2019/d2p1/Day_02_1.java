package nl.ndoorn.adventofcode.y2019.d2p1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nl.ndoorn.adventofcode.util.Util;

public class Day_02_1 {
    /*
     * Link: https://adventofcode.com/2019/day/2
     */

    public static void main(String[] args) {
        String fileInput = Util.Input.getLine(args[0], "");
        List<Integer> input = Arrays.stream(fileInput.split(","))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        int programCounter = 0;

        input.set(1, 12);
        input.set(2, 2);

        boolean notFinished = true;

        while (notFinished) {
            int opCode = input.get(programCounter);

            switch (opCode) {
                case 1:
                    add(input, programCounter);
                    break;

                case 2:
                    multiply(input, programCounter);
                    break;

                case 99:
                    notFinished = false;
                    break;

                default:
                    Util.Log.e("You broke the system, opcode={%d}", opCode);
                    break;
            }

            programCounter += 4;
        }

        finished(input);
    }

    public static void add(List<Integer> input, int programCounter) {
        int posA = input.get(programCounter + 1);
        int posB = input.get(programCounter + 2);
        int posC = input.get(programCounter + 3);

        int A = input.get(posA);
        int B = input.get(posB);
        int result = A + B;

        input.set(posC, result);
    }

    public static void multiply(List<Integer> input, int programCounter) {
        int posA = input.get(programCounter + 1);
        int posB = input.get(programCounter + 2);
        int posC = input.get(programCounter + 3);

        int A = input.get(posA);
        int B = input.get(posB);
        int result = A * B;

        input.set(posC, result);
    }

    public static void finished(List<Integer> input) {
        Util.Log.i(
            "Program has finished, answer={%d}", input.get(0)
        );

        System.exit(0);
    }
}
