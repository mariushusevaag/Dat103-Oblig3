package no.hvl.dat103.buffer.java;

public class Consumer implements Runnable {
	Que q;
	
	Consumer(Que q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			q.get();
		}
	}
}
