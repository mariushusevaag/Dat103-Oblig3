package no.hvl.dat103.buffer;

public class Main {
	public static void main(String[] args){
        BBuffer buffer = new BBuffer(1);
        Consumer c1 = new Consumer(buffer);
        //Consumer c2 = new Consumer(buffer);
        Producer p1 = new Producer(buffer);

        //c2.run();
        p1.start();
        c1.start();
    }
}
