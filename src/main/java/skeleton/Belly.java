package skeleton;

public class Belly {
    private int cukes = 0;

    public void eat(int cukes) {
        this.cukes += cukes;
    }

    public void starve(int minutes) {
        // Burn 1 cuke every 5 minutes
        int cukesConsumed = minutes / 5;
        cukes = cukes > cukesConsumed ? cukes - cukesConsumed : 0;
    }

    public boolean starving() {
        return cukes == 0;
    }
}
