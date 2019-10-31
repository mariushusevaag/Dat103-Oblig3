package no.hvl.dat103.buffer;

public class Producer extends Thread{
    private BBuffer buffer;

    public Producer(BBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.produser();
        }while (true);

    }
}
