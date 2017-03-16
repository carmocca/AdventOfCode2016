public class Vertex {
    private int weight;
    private int prev;
    private int pos;

    public Vertex(int weight, int prev, int pos) {
        this.weight = weight;
        this.prev = prev;
        this.pos = pos;
    }

    public int getWeight() {
        return weight;
    }

    public int getPos() {
        return pos;
    }
}
