package no.hvl.dat103.buffer;

public class BBuffer {
	private int S;
    @SuppressWarnings("unused")
	private final int MAX;
    private Semafor full;
    private TomSemafor tom;
    private Mutex mutex;

    public BBuffer(int MAX){
        this.S = 0;
        this.MAX = MAX;
        this.full = new Semafor(MAX);
        this.tom = new TomSemafor();
        this.mutex = new Mutex();
    }

    void konsumer(){
        full.vent();
        mutex.vent();
        System.out.println("Konsumert");
        S--;
        mutex.signal();
        tom.signal();
    }

    void produser(){
        tom.vent();
        mutex.vent();
        System.out.println("Produsert");
        S++;
        mutex.signal();
        full.signal();
    }

    public int getS(){return S;}
}
