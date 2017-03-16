public class Adjacent {

    private int dest;
    private int weight;

    public Adjacent(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public int getDest() {
        return dest;
    }

    @Override
    public String toString() {
        return String.format("Dest: %d", dest);
    }
}