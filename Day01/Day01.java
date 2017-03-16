import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 {
    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day01/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }
        String regex = "([L|R])(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int x = 0;
        int y = 0;
        String lastDirection = "U";
        String newDirection;
        while (matcher.find()) {
            newDirection = matcher.group(1);
            int distance = Integer.parseInt(matcher.group(2));
            switch (lastDirection) {
                case "R":
                    if (newDirection.equals("R")) {
                        y -= distance;
                        lastDirection = "D";
                    } else {
                        y += distance;
                        lastDirection = "U";
                    }
                    break;
                case "L":
                    if (newDirection.equals("R")) {
                        y += distance;
                        lastDirection = "U";
                    } else {
                        y -= distance;
                        lastDirection = "D";
                    }
                    break;
                case "U":
                    if (newDirection.equals("R")) {
                        x += distance;
                        lastDirection = "R";
                    } else {
                        x -= distance;
                        lastDirection = "L";
                    }
                    break;
                case "D":
                    if (newDirection.equals("R")) {
                        x -= distance;
                        lastDirection = "L";
                    } else {
                        x += distance;
                        lastDirection = "R";
                    }
                    break;
                default:
                    System.out.println("Error reading file");
                    break;
            }
        }
        System.out.println("Shortest path to the destination: " + distance(x, 0, y, 0));
    }

    public static int distance(int x1, int x0, int y1, int y0) {
        return Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }
}