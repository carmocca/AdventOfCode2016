import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day06_2 {

    public static List<Map<Character, Integer>> log = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Day06/input.txt"));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        // Create maps
        for (int i = 0; i < 8; i++) {
            log.add(new HashMap<>());
        }

        // Process the input
        while (sc.hasNext()) {
            String input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                Integer num = log.get(i).get(input.charAt(i));
                log.get(i).put(input.charAt(i), (num == null ? 1 : ++num));
            }
        }

        // Get the message by finding the minimum for each map
        String msg = "";
        for (Map<Character, Integer> map : log) {
            int min = (int) Double.POSITIVE_INFINITY;
            char ch = 'X';
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (min >= value) {
                    min = value;
                    ch = key;
                }
            }
            msg += ch;
        }
        System.out.println("The original message is: " + msg);
    }
}