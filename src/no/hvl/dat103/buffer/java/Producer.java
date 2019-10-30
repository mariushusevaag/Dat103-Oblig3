package no.hvl.dat103.buffer.java;

public class Producer implements Runnable {
	Que q;

	Producer(Que q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	
	public void run() {
		for(int i=0; i < 5; i++) {
			q.put(i);
		}
	}
}
