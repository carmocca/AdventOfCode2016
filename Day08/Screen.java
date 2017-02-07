package Day08;

import java.util.Scanner;

public class Screen {

    private char[][] screen;

    public Screen(int width, int height) {
        screen = new char[height][width];
        // Fill the screen
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                screen[row][col] = '.';
            }
        }
    }

    public void processInstruction(String instruction) {
        Scanner sc = new Scanner(instruction).useDelimiter("[^0-9]+");
        int a = sc.nextInt(), b = sc.nextInt();
        if (instruction.contains("rect")) {
            addRectangle(a,b);
        } else if (instruction.contains("row")) {
            rotateRow(a, b);
        } else if (instruction.contains("column")) {
            rotateColumn(a, b);
        }
        sc.close();
    }

    public void addRectangle(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                screen[row][col] = '#';
            }
        }
    }

    public void rotateRow(int a, int b) {
        // Move b times to the right
        for (int i = 0; i < b; i++){
            char last = screen[a][screen[a].length - 1];
            for (int j = screen[a].length - 2; j >= 0; j--) {
                screen[a][j + 1] = screen[a][j];
            }
            screen[a][0] = last;    
        }
    }

    public void rotateColumn(int a, int b) {
        // Move b times down
        for (int i = 0; i < b; i++){
            char last = screen[screen.length - 1][a];
            for (int j = screen.length - 2; j >= 0; j--) {
                screen[j + 1][a] = screen[j][a];
            }
            screen[0][a] = last;    
        }
    }

    public int getOnPixels() {
        int count = 0;
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                if (screen[row][col] == '#') {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                s += screen[row][col];
            }
            s += "\n";
        }
        return s;
    }
}