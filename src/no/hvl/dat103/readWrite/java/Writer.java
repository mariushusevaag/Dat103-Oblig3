package no.hvl.dat103.readWrite.java;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Writer implements Runnable {
	private Semaphore write;
	private Buffer buffer;
	private Random random;

	@Override
	public void run() {
		while (true) {
			try {
				write.acquire();

				int value = random.nextInt(100);
				buffer.add(value);

				System.out.println("Writer added value: " + value);

				write.release();

				try {
					Thread.sleep(random.nextInt(200));

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Writer(Semaphore write, Buffer buffer) {
		this.write = write;
		this.buffer = buffer;
		this.random = new Random();
	}
}