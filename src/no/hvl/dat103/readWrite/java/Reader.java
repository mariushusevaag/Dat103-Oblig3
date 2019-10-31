package no.hvl.dat103.readWrite.java;

import java.util.concurrent.Semaphore;

public class Reader implements Runnable {
	private Semaphore mutex;
	private Semaphore write;
	private Buffer buffer;
	private int id;

	@Override
	public void run() {
		while (true) {
			try {
				mutex.acquire();

				int readers = buffer.getReaders();

				buffer.setReaders(readers + 1);

				if (readers + 1 == 1) {
					write.acquire();
				}

				int value = buffer.remove();
				System.out.println(String.format("Reader '%s' read '%s'", id, value));

				buffer.setReaders(readers);

				if (readers == 0) {
					write.release();
				}

				mutex.release();

				try {
					Thread.sleep(300);

				} catch(InterruptedException e) {
					e.printStackTrace();
				}

			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Reader(Semaphore mutex, Semaphore write, Buffer buffer, int id) {
		this.mutex = mutex;
		this.write = write;
		this.buffer = buffer;
		this.id = id;
	}
}