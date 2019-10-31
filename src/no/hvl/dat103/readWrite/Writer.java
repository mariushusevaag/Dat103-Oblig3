package no.hvl.dat103.readWrite;

import java.util.Random;

public class Writer implements Runnable {
	private Semafor write;
	private Buffer buffer;
	private Random random;

	@Override
	public void run() {
		while (true) {
			write.vent();

			int value = random.nextInt(100);
			buffer.add(value);

			System.out.println("Writer added value: " + value);

			write.signal();

			try {
				Thread.sleep(random.nextInt(200));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Writer(Semafor write, Buffer buffer) {
		this.write = write;
		this.buffer = buffer;
		this.random = new Random();
	}
}
