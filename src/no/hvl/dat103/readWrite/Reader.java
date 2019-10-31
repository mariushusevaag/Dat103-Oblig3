package no.hvl.dat103.readWrite;

public class Reader implements Runnable {
	private Semafor mutex;
	private Semafor write;
	private Buffer buffer;
	private int id;

	@Override
	public void run() {
		while (true) {
			mutex.vent();

			int readers = buffer.getReaders();

			buffer.setReaders(readers + 1);

			if (readers + 1 == 1) {
				write.vent();
			}

			int value = buffer.remove();
			System.out.println(String.format("Reader '%s' read '%s'", id, value));

			buffer.setReaders(readers);

			if (readers == 0) {
				write.signal();
			}

			mutex.signal();

			try {
				Thread.sleep(300);

			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Reader(Semafor mutex, Semafor write, Buffer buffer, int id) {
		this.mutex = mutex;
		this.write = write;
		this.buffer = buffer;
		this.id = id;
	}
}
