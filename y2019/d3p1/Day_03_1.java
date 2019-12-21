package nl.ndoorn.adventofcode.y2019.d3p1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import nl.ndoorn.adventofcode.util.Util;

public class Day_03_1 {
    public static void main(String[] args) {
        List<String> fileInput = Util.Input.getLines(args[0]);

        new Day_03_1().start(fileInput);
    }

    private void start(List<String> input) {
        List<Wire> wires = input.stream()
            .map(Wire::new)
            .collect(Collectors.toList());

        int closest = findClosestOverlap(wires.get(0), wires.get(1));

        Util.Log.i(
            "Found closest intersection with distance={%d}",
            closest
        );
    }

    private int findClosestOverlap(Wire one, Wire two) {
        final int[] closest = { Integer.MAX_VALUE };

        one.getPoints().stream()
            .filter(entry -> two.hasPoint(entry.getKey()))
            .forEach(entry -> {
                int pointDist = entry.getValue().distance();

                if (pointDist < closest[0]) {
                    closest[0] = pointDist;
                }
            });

        return closest[0];
    }

    private class Wire {
        private Map<String, Point> points = new HashMap<>();

        public Wire(String input) {
            String[] actions = input.split(",");

            final String regex = "^(\\w)(\\w+)$";

            int x = 0;
            int y = 0;

            for (String action : actions) {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(action);

                if (m.find()) {
                    String direction = m.group(1);
                    int length = Integer.parseInt(m.group(2));

                    while (length-- > 0) {
                        switch (direction) {
                            case "U":
                                y++;
                                break;
                            case "D":
                                y--;
                                break;
                            case "R":
                                x++;
                                break;
                            case "L":
                                x--;
                                break;
                        }

                        Point newPoint = new Point(x, y);
                        points.put(newPoint.toString(), newPoint);
                    }
                }
            }
        }

        public Set<Map.Entry<String, Point>> getPoints() {
            return points.entrySet();
        }

        public boolean hasPoint(String point) {
            return points.containsKey(point);
        }

        private class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int distance() {
                return Math.abs(x) + Math.abs(y);
            }

            @Override
            public String toString() {
                return String.format("%d_%d", this.x, this.y);
            }
        }
    }
}
