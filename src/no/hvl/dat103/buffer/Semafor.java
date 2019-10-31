package no.hvl.dat103.buffer;

public class Semafor {
	private int full;
    private int brukt;

    public Semafor(int full) {
        this.full = full;
        this.brukt = 0;
    }

    void vent(){
        while (brukt >= full);
        brukt++;
    }

    void signal(){
        brukt--;
    }
}
