package no.hvl.dat103.readWrite.java;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1);
		Semaphore write = new Semaphore(1);

		Buffer buffer = new Buffer();

		Thread writer = new Thread(new Writer(write, buffer));
		Thread reader1 = new Thread(new Reader(mutex, write, buffer, 1));
		Thread reader2 = new Thread(new Reader(mutex, write, buffer, 2));

		writer.start();
		reader1.start();
		reader2.start();
	}
}
