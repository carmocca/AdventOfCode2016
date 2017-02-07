package Day02;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Day02_2 {
	public static void main (String[] args) {
		String input = null;
		try {
			input = new String(Files.readAllBytes(Paths.get("Day02/input.txt")));
		} catch (IOException e) {
			System.out.println("Error reading file");
			System.exit(0);
		}

		Keypad_2 keypad = new Keypad_2('5');
		String code = "";
		for (int i = 0; i < input.length(); i++) {
			char move = input.charAt(i);
			if (move == '\n') {
				code += keypad.getCurrentButton();
			} else {
				keypad.move(move);
			}
		}
		System.out.println("The bathroom code is " + code);
	}
}
