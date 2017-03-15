package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day13 {

    private static final int INPUT = 1362;
    private static final int ROWS = 75 + 2;  // Height + 2
    private static final int COLUMNS = 75 + 2;   // Width + 2
    private static char[][] office = new char[ROWS][COLUMNS];
    private static List<Adjacent>[] array;  // Each position of array has a list of adjacent locations
    private static Vertex[] minDist;    // Array with the minimum distance yet calculated to each location

    public static void main(String[] args) {
        // Office matrix creation, using 2 extra rows and columns as edges
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (isWall(j - 1, i - 1)) {
                    office[i][j] = '#';
                } else {
                    office[i][j] = '.';
                }
                if (i == 0 || i == ROWS - 1) {
                    office[i][j] = '-';
                }
                if (j == 0 || j == COLUMNS - 1) {
                    office[i][j] = '|';
                }
            }
        }

        // Number of vertexes in the graph
        int numV = (ROWS - 2) * (COLUMNS - 2);
        array = new ArrayList[numV];

        // Initialize the array
        for (int i = 0; i < numV; i++) {
            array[i] = new ArrayList<Adjacent>();
        }

        // Fill it with the adjacent locations
        for (int i = 1; i < ROWS - 1; i++) {
            for (int j = 1; j < COLUMNS - 1; j++) {
                if (office[i][j] == '#') {
                    continue;
                }
                int origin = (i - 1) * (COLUMNS - 2) + (j - 1);
                int dest;
                if (office[i][j - 1] == '.') {  // LEFT
                    dest = origin - 1;
                    array[origin].add(new Adjacent(dest, 1));
                    array[dest].add(new Adjacent(origin, 1));
                }
                if (office[i][j + 1] == '.') {  // RIGHT
                    dest = origin + 1;
                    array[origin].add(new Adjacent(dest, 1));
                    array[dest].add(new Adjacent(origin, 1));
                }
                if (office[i - 1][j] == '.') {  // UP
                    dest = origin - (COLUMNS - 2);
                    array[origin].add(new Adjacent(dest, 1));
                    array[dest].add(new Adjacent(origin, 1));
                }
                if (office[i + 1][j] == '.') {  // DOWN
                    dest = origin + (COLUMNS - 2);
                    array[origin].add(new Adjacent(dest, 1));
                    array[dest].add(new Adjacent(origin, 1));
                }
            }
        }

        // The search's starting position
        int initialPosition = 1 * (COLUMNS - 2) + 1;

        Queue<Vertex> q = new LinkedList<Vertex>();
        minDist = new Vertex[numV];
        boolean[] visited = new boolean[numV];

        // BFS
        minDist[initialPosition] = new Vertex(0, -1, initialPosition);
        visited[initialPosition] = true;
        q.add(minDist[initialPosition]);
        for (int pos = 0; pos < numV && !q.isEmpty(); pos++) {
            Vertex vtx = q.remove();
            for (Adjacent e : array[vtx.getPos()]) {
                if (!visited[e.getDest()]) {
                    minDist[e.getDest()] = new Vertex(vtx.getWeight() + 1, vtx.getPos(), e.getDest());
                    visited[e.getDest()] = true;
                    q.add(minDist[e.getDest()]);
                }
            }
        }

        //visualizeOffice();
        //visualizeBFS();

        // PART 1
        System.out.printf("Fewest number of steps required: %d\n", minDist[39 * (COLUMNS - 2) + 31].getWeight());

        // PART 2
        int count = 0;
        for (int i = 1; i < ROWS - 1; i++) {
            for (int j = 1; j < COLUMNS - 1; j++) {
                int position = (i - 1) * (COLUMNS - 2) + (j - 1);
                if (minDist[position] != null && minDist[position].getWeight() <= 50) {
                    count++;
                }
            }
        }
        System.out.printf("%d locations can be reached within 50 steps.\n", count);
    }

    public static boolean isWall(int x, int y) {
        int res = x * x + 3 * x + 2 * x * y + y + y * y;
        res += INPUT;
        int ones = 0;
        for (char c : Integer.toBinaryString(res).toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return (ones % 2 != 0);
    }

    /**
     * Prints the office (Walls and open spaces)
     */
    public static void visualizeOffice() {
        String output = "";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                output += office[i][j];
            }
            output += "\n";
        }
        System.out.println(output);
    }

    /**
     * Prints the minimum distance to each location matrix
     */
    public static void visualizeBFS() {
        for (int i = 1; i < ROWS - 1; i++) {
            for (int j = 1; j < COLUMNS - 1; j++) {
                int position = (i - 1) * (COLUMNS - 2) + (j - 1);
                if (minDist[position] != null) {
                    System.out.print(minDist[position].getWeight() + " ");
                } else {
                    System.out.print("-1 ");
                }
            }
            System.out.println();
        }
    }
}