package Day12;

public class Parser {
    private int[] registers;

    public Parser() {
        registers = new int[]{0, 0, 0, 0};  // {0,0,0,0} for part 1, {0,0,1,0} for part 2
    }

    public int processInstruction(String instruction) {
        int jump = 0;
        String[] instr = instruction.split(" ");
        switch (instr[0]) {
            case "cpy":
                cpy(instr[1], instr[2]);
                break;
            case "jnz":
                jump = jnz(instr[1], instr[2]);
                break;
            case "inc":
                inc(instr[1]);
                break;
            case "dec":
                dec(instr[1]);
                break;
            default:
                System.err.println("Error processing instruction");
        }
        return jump;
    }

    public void cpy(String x, String y) {
        int position = ((int) y.charAt(0)) - 97;
        int val;
        if (isNumber(x)) {
            val = Integer.parseInt(x);
        } else {
            val = registers[((int) x.charAt(0)) - 97];
        }
        registers[position] = val;
    }

    public void inc(String x) {
        int position = ((int) x.charAt(0)) - 97;
        registers[position]++;
    }

    public void dec(String x) {
        int position = ((int) x.charAt(0)) - 97;
        registers[position]--;
    }

    public int jnz(String x, String y) {
        int val;
        if (isNumber(x)) {
            val = Integer.parseInt(x);
        } else {
            val = registers[((int) x.charAt(0)) - 97];
        }
        if (val != 0) {
            return Integer.parseInt(y) - 1; // -1 to account for the i++ in the main loop
        }
        return 0;
    }

    public boolean isNumber(String str) {
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Register A: %d\nRegister B: %d\nRegister C: %d\nRegister D: %d", registers[0], registers[1], registers[2], registers[3]);
    }
}
