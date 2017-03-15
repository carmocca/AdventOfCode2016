package Day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 {

    static PriorityQueue<CharTuple> pq = new PriorityQueue<CharTuple>();

    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day04/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        String regex = "([\\w-]+)-(\\d+)\\[(\\w+)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        while (matcher.find()) {
            countLetters(matcher.group(1));
            boolean isRoom = true;
            for (int i = 0; i < matcher.group(3).length() && isRoom; i++) {
                if (matcher.group(3).charAt(i) != pq.remove().getChar()) {
                    isRoom = false;
                }
            }
            if (isRoom) sum += Integer.parseInt(matcher.group(2));
            pq.clear();
        }
        System.out.println("Sum of the sector IDs of the real rooms: " + sum);
    }

    public static void countLetters(String s) {
        s = s.replace("-", "");
        // Map that contains each char with its number of appearances
        HashMap<Character, Integer> appearances = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer num = appearances.get(c);
            appearances.put(c, (num == null ? 1 : ++num));
        }
        // Add each map entry as a CharTuple to a PriorityQueue so they get ordered
        for (HashMap.Entry<Character, Integer> entry : appearances.entrySet()) {
            pq.add(new CharTuple(entry.getKey(), entry.getValue()));
        }
    }
}
