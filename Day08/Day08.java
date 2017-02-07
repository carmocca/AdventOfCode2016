package Day08;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day08 {

    public static Screen screen = new Screen(50, 6);

    public static void main (String [] args) {

        Scanner sc = null;
        try {
            sc = new Scanner(new File("Day08/input.txt"));
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        while (sc.hasNext()) {
            String input = sc.nextLine();
            screen.processInstruction(input);
        }
        
        System.out.println(screen.toString());
        System.out.println(screen.getOnPixels() + " pixels are lit");
    }
}