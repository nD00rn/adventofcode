package nl.ndoorn.adventofcode;

import java.util.Arrays;

public class Day_02_1 {
    /*
     * Link: https://adventofcode.com/2019/day/2
     */

    private static final int[] PROGRAM = new int[]{
        1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,19,5,23,2,10,23,27,2,27,13,31,
        1,10,31,35,1,35,9,39,2,39,13,43,1,43,5,47,1,47,6,51,2,6,51,55,1,5,55,59,
        2,9,59,63,2,6,63,67,1,13,67,71,1,9,71,75,2,13,75,79,1,79,10,83,2,83,9,
        87,1,5,87,91,2,91,6,95,2,13,95,99,1,99,5,103,1,103,2,107,1,107,10,0,99,
        2,0,14,0
    };

    public static void main(String[] args) {
        int programCounter = 0;

        PROGRAM[1] = 12;
        PROGRAM[2] = 2;

        while (true) {
            int opCode = PROGRAM[programCounter];

            switch (opCode) {
                case 1:
                    add(programCounter);
                    break;

                case 2:
                    multiply(programCounter);
                    break;

                case 99:
                    finished();

                default:
                    System.err.println("You broke the system");
                    System.err.println("Opcode = " + opCode);
                    System.exit(1);
                    break;
            }

            programCounter += 4;
        }
    }

    public static void add(int programCounter) {
        int posA = PROGRAM[programCounter + 1];
        int posB = PROGRAM[programCounter + 2];
        int posC = PROGRAM[programCounter + 3];

        int A = PROGRAM[posA];
        int B = PROGRAM[posB];
        int result = A + B;

        PROGRAM[posC] = result;
    }

    public static void multiply(int programCounter) {
        int posA = PROGRAM[programCounter + 1];
        int posB = PROGRAM[programCounter + 2];
        int posC = PROGRAM[programCounter + 3];

        int A = PROGRAM[posA];
        int B = PROGRAM[posB];
        int result = A * B;

        PROGRAM[posC] = result;
    }

    public static void finished() {
        System.out.println("Program is done");
        System.out.println("Position 0 contains: " + PROGRAM[0]);
        System.out.println("Full output is: " + Arrays.toString(PROGRAM));
        System.exit(0);
    }
}
