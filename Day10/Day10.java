package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {
    public static Bot[] botArray;
    public static int[] outputArray;

    public static void main(String[] args) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get("Day10/input.txt")));
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }

        botArray = new Bot[210];
        outputArray = new int[21];

        String regex = "value (\\d+) goes to bot (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Give starting chips to bots
        while (matcher.find()) {
            int botId = Integer.parseInt(matcher.group(2));
            if (botArray[botId] == null) {
                botArray[botId] = new Bot(botId);
            }
            botArray[botId].addChip(Integer.parseInt(matcher.group(1)));
        }

        // Initial search for the responsible one (As in the example case)
        findResponsible();

        //Create the rest of the bots
        for (int i = 0; i < botArray.length; i++) {
            if (botArray[i] == null) {
                botArray[i] = new Bot(i);
            }
        }

        regex = "bot (\\d+) gives low to (\\w+) (\\d+) and high to (\\w+) (\\d+)";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);

        // Process the instructions
        while (matcher.find()) {
            int id1 = Integer.parseInt(matcher.group(1));
            int id2 = Integer.parseInt(matcher.group(3));
            int id3 = Integer.parseInt(matcher.group(5));
            Bot givingBot = botArray[id1];
            if (givingBot.hasTwoChips()) {
                int lowestChip = givingBot.removeLowestChip();
                int highestChip = givingBot.removeHighestChip();
                botArray[id1] = givingBot;
                if (!matcher.group(2).equals("output")) {
                    Bot lowReceivingBot = botArray[id2];
                    lowReceivingBot.addChip(lowestChip);
                    botArray[id2] = lowReceivingBot;
                } else {
                    outputArray[id2] = lowestChip;
                }
                if (!matcher.group(4).equals("output")) {
                    Bot highReceivingBot = botArray[id3];
                    highReceivingBot.addChip(highestChip);
                    botArray[id3] = highReceivingBot;
                } else {
                    outputArray[id3] = lowestChip;
                }
                findResponsible();
                // Remove the processed instruction
                matcher = pattern.matcher(input.replace(matcher.group(0), ""));
            }
        }

        System.out.println(outputArray[0] * outputArray[1] * outputArray[2]);
    }

    public static void findResponsible(){
        for (int i = 0; i < botArray.length ; i++) {
            if (botArray[i] != null) {
                if (botArray[i].isResponsible(61, 17)) {
                    System.out.println("Responsible " + botArray[i].toString());
                }
            } else {
                break;
            }
        }
    }
}
