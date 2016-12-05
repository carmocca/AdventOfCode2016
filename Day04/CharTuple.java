public class CharTuple implements Comparable<CharTuple> {
    
    private char c;
    private int appearances;

    public CharTuple(char c, int appearances) {
        this.c = c;
        this.appearances = appearances;
    }

    public char getChar(){
        return c;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setChar(char c) {
        this.c = c;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CharTuple)) {
            return false;
        }
        CharTuple c = (CharTuple) o;
        if (this.c == c.getChar()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + c + ", " + appearances + ")";
    }

    @Override
    public int compareTo(CharTuple o) {
        int num = o.getAppearances();
        int thisNum = this.getAppearances();

        if (thisNum < num) {
            return 1;
        } else if (thisNum > num) {
            return -1;
        } else { //Order alphabetically
            Character ch = new Character(this.getChar());
            return ch.compareTo(o.getChar());
        }
    }
}