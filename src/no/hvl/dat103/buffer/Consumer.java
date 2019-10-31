package no.hvl.dat103.buffer;

public class Consumer extends Thread {
    private BBuffer buffer;

    public Consumer(BBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do {
            buffer.konsumer();
        }while (true);
    }
}
