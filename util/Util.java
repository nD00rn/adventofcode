package nl.ndoorn.adventofcode.util;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {
    public static class Log {
        public static void i(String format, Object... arguments) {
            System.out.println(generate(format, arguments));
        }

        public static void e(String format, Object... arguments) {
            System.err.println(generate(format, arguments));
        }

        private static String generate(String format, Object... arguments) {
            return String.format(format, arguments);
        }
    }

    public static class Input {
        public static List<String> getLines(String file) {
            try {
                return Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            } catch (FileNotFoundException e) {
                Log.e("File not found, filename={%s}", file);
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            return null;
        }

        public static String getLine(String file, String joiner) {
            List<String> lines = getLines(file);

            return String.join(joiner, lines);
        }
    }
}
