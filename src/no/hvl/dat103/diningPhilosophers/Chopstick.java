package no.hvl.dat103.diningPhilosophers;

public class Chopstick {
	private Semafor mutex;

	public Chopstick() {
		this.mutex = new Semafor(1);
	}

	public void grab() {
		mutex.vent();
	}

	public void release() {
		mutex.signal();
	}
}