import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Day3 {
	public static void main (String[] args) {
		String input = null;
		try {
			input = new String(Files.readAllBytes(Paths.get("input.txt")));
		} catch (IOException e) {
			System.out.println("Error reading file");
			System.exit(0);
		}
		String regex = "\\s*(\\d+)\\s+(\\d+)\\s+(\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		int triangles = 0;
		while (matcher.find()) {
			int side1 = Integer.parseInt(matcher.group(1));
			int side2 = Integer.parseInt(matcher.group(2));
			int side3 = Integer.parseInt(matcher.group(3));
			if (side1 + side2 > side3 &&
				side2 + side3 > side1 &&
				side3 + side1 > side2) {
				triangles++;
			}
		}
		System.out.println(triangles + " triangles are possible");
	}
}