package Day07;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 {
    
    public static void main (String [] args ) {
        
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
            if (hasABBA(input) && !hasABBA(bracketedText)) {
                res++;
            }
        }
        
        System.out.println(res + " IPs support TLS");
        sc.close();
    }

    public static boolean hasABBA(String s) {
        String check = "(\\w)(\\w)\\2\\1";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(s);
        return (matcher.find()) ? (!matcher.group(1).equals(matcher.group(2))) : false;
    }

}
