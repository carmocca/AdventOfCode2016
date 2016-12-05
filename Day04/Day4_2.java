import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Day4_2 { 

    public static void main (String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }
        
        String regex = "([\\w-]+)-(\\d+)\\[(\\w+)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String roomName = "";
        while (matcher.find()) {
            roomName = shiftDecipher(matcher.group(1), Integer.parseInt(matcher.group(2)));
            if (roomName.contains("north") || roomName.contains("pole")) {
                System.out.println("Sector ID of " + roomName + ": " +
                                    Integer.parseInt(matcher.group(2)));
                break;
            }
        }
    }

    public static String shiftDecipher(String s, int n) {
        String msg = "";
        for (int i = 0; i < s.length(); i++) {
            int aux = s.charAt(i);
            if (aux == 45){ // If its a '-'
                aux = 32;
            } else {
                for (int j = 0; j < n; j++) {
                    aux = (aux > 121) ? 97 : aux + 1;
                }
            }
            msg += (char) aux;
        }
        return msg;
    }
}
