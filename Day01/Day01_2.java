package Day01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day01_2 {
    public static void main (String[] args) {
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
        List<Line> array = new ArrayList<>();
        Point origin = new Point(0, 0);
        Point lastPoint = origin;
        boolean found = false;

        String lastDirection = "U";
        while (matcher.find() && !found) {
            String newDirection = matcher.group(1);
            int distance = Integer.parseInt(matcher.group(2));
            switch (lastDirection){
                case "R":   if (newDirection.equals("R")) {
                                y -= distance;
                                lastDirection = "D";
                            } else {
                                y += distance;
                                lastDirection = "U";
                            }
                            break;
                case "L":   if (newDirection.equals("R")) {
                                y += distance;
                                lastDirection = "U";
                            } else {
                                y -= distance;
                                lastDirection = "D";
                            }
                            break;
                case "U":   if (newDirection.equals("R")) {
                                x += distance;
                                lastDirection = "R";
                            } else {
                                x -= distance;
                                lastDirection = "L";
                            }
                            break;
                case "D":   if (newDirection.equals("R")) {
                                x -= distance;
                                lastDirection = "L";
                            } else {
                                x += distance;
                                lastDirection = "R";
                            }
                            break;
                default:    System.out.println("Error reading file");
                            break;      
            }

            Line line = new Line(lastPoint, new Point(x, y));
            for (Line l : array) {
                Point aux = line.intersects(l);
                if (aux != null) {
                    found = true;   
                    System.out.println("Shortest path to the destination: " + aux.distanceTo(origin));  
                    break;
                }
            }

            lastPoint = new Point(x, y);
            array.add(line);
        }
    }
}
