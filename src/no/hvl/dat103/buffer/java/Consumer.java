package no.hvl.dat103.buffer.java;

public class Consumer extends Thread{
    BBuffer buffer;

    public Consumer(BBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.consume();
        }while (true);
    }
}