import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day12 {

    private static Parser parser;

    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day12/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        String[] instructions = input.split("\n");
        Parser parser = new Parser();
        for (int i = 0; i < instructions.length; i++) {
            i += parser.processInstruction(instructions[i]);
        }
        System.out.println(parser.toString());
    }
}
