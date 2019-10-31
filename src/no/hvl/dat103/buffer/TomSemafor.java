package no.hvl.dat103.buffer;

public class TomSemafor {
	private int tom;
    private int brukt;

    public TomSemafor() {
        this.tom = 0;
        this.brukt = 0;
    }

    void vent(){
        while (brukt <= tom);
        brukt--;
    }
    void signal(){
        brukt++;
    }

}
