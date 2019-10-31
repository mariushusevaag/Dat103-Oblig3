package no.hvl.dat103.diningPhilosophers.java;

import java.util.concurrent.Semaphore;

public class Chopstick {
	private Semaphore mutex;

	public Chopstick() {
		this.mutex = new Semaphore(1);
	}

	public void grab() {
		try {
			mutex.acquire();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void release() {
		mutex.release();
	}
}