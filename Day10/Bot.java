public class Bot {
    private int id;
    private int[] chips;

    public Bot(int id) {
        this.id = id;
        chips = new int[2];
    }

    public void addChip(int chip) {
        if (chips[0] == 0) {
            chips[0] = chip;
        } else if (chips[1] == 0) {
            chips[1] = chip;
        } else {
            System.err.println("Bot " + id + "cannot handle more chips");
        }
    }

    public int removeLowestChip() {
        int chip;
        if (chips[0] < chips[1]) {
            chip = chips[0];
            chips[0] = 0;
        } else {
            chip = chips[1];
            chips[1] = 0;
        }
        return chip;
    }

    public int removeHighestChip() {
        int chip;
        if (chips[0] > chips[1]) {
            chip = chips[0];
            chips[0] = 0;
        } else {
            chip = chips[1];
            chips[1] = 0;
        }
        return chip;
    }

    public boolean hasTwoChips() {
        return (chips[0] != 0 && chips[1] != 0);
    }

    public boolean isResponsible(int chip1, int chip2) {
        return ((chips[0] == chip1 && chips[1] == chip2) ||
                (chips[0] == chip2 && chips[1] == chip1));
    }

    @Override
    public String toString() {
        return "Bot: " + id + " {" + chips[0] + ", " + chips[1] + "}";
    }
}
