package Day07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07_2 {

    public static void main(String[] args) {

        Scanner sc = null;
        try {
            sc = new Scanner(new File("Day07/input.txt"));
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        String regex = "\\[(\\w+)\\]";
        int res = 0;

        while (sc.hasNext()) {
            String input = sc.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            // This string contains the text inside brackets
            String bracketedText = "";
            while (matcher.find()) {
                bracketedText += matcher.group(1) + " ";
                // Input now only has the text outside brackets
                input = input.replace("[" + matcher.group(1) + "]", " ");

            }
            if (supportsSSL(input, bracketedText)) {
                res++;
            }
        }

        System.out.println(res + " IPs support TLS");
        sc.close();
    }

    public static boolean supportsSSL(String aba, String bab) {
        String check = "(\\w)(\\w)\\1";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(aba);
        boolean found = matcher.find();

        while (found) {
            String a = matcher.group(1), b = matcher.group(2);
            if (!a.equals(b)) {
                check = b + a + b;
                pattern = Pattern.compile(check);
                Matcher matcher2 = pattern.matcher(bab);
                if (matcher2.find()) {
                    return true;
                }
            }
            // Needed for overlapping
            found = matcher.find(matcher.start() + 1);
        }
        return false;
    }
}
