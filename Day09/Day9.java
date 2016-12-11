import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.lang.StringBuilder;

public class Day9 {

    public static void main(String[] args) {

        StringBuilder input = null;
        try {
            input = new StringBuilder(new String(Files.readAllBytes(Paths.get("input.txt"))));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        String regex = "\\((\\d+)x(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            int amount = Integer.parseInt(matcher.group(1));
            int times = Integer.parseInt(matcher.group(2));
            int endIndex = matcher.end();

            count += (amount * times);
            // Delete the processed marker
            input = input.delete(matcher.start(), endIndex + amount);
            // Update the matcher with the new input
            matcher = pattern.matcher(input);
        }
        System.out.println("The decompressed length is " + (input.length() + count));
    }
}