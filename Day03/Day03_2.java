import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03_2 {
    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day03/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }
        String regex = "\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)\n\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)\n\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int side1, side2, side3;
        int triangles = 0;
        while (matcher.find()) {
            side1 = Integer.parseInt(matcher.group(1));
            side2 = Integer.parseInt(matcher.group(4));
            side3 = Integer.parseInt(matcher.group(7));
            if (side1 + side2 > side3 &&
                    side2 + side3 > side1 &&
                    side3 + side1 > side2) {
                triangles++;
            }
            side1 = Integer.parseInt(matcher.group(2));
            side2 = Integer.parseInt(matcher.group(5));
            side3 = Integer.parseInt(matcher.group(8));
            if (side1 + side2 > side3 &&
                    side2 + side3 > side1 &&
                    side3 + side1 > side2) {
                triangles++;
            }
            side1 = Integer.parseInt(matcher.group(3));
            side2 = Integer.parseInt(matcher.group(6));
            side3 = Integer.parseInt(matcher.group(9));
            if (side1 + side2 > side3 &&
                    side2 + side3 > side1 &&
                    side3 + side1 > side2) {
                triangles++;
            }
        }
        System.out.println(triangles + " triangles are possible");
    }
}