package no.hvl.dat103.readWrite;

public class Main {

	public static void main(String[] args) {
		Semafor mutex = new Semafor(1);
		Semafor write = new Semafor(1);

		Buffer buffer = new Buffer();

		Thread writer = new Thread(new Writer(write, buffer));
		Thread reader1 = new Thread(new Reader(mutex, write, buffer, 1));
		Thread reader2 = new Thread(new Reader(mutex, write, buffer, 2));

		writer.start();
		reader1.start();
		reader2.start();
	}
}
