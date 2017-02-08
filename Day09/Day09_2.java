package Day09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Day09_2 {

    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day09/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        System.out.println("The decompressed length is " + decompressedLength(input));
    }

    public static long decompressedLength(String s) {
        String regex = "\\((\\d+)x(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        long res = 0;
        int amount, times, endIndex;

        for (int i = 0; i < s.length(); i++) {
            matcher = pattern.matcher(s).region(i, s.length());
            if (matcher.lookingAt()) {
                amount = Integer.parseInt(matcher.group(1));
                times = Integer.parseInt(matcher.group(2));
                endIndex = matcher.end();

                res += times * decompressedLength(s.substring(endIndex, endIndex + amount));
                i = endIndex - 1 + amount;
            } else {
                res++;
            }
        }
        return res;
    }
}