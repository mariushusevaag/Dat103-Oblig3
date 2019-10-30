package no.hvl.dat103.buffer.java;

public class Main {

	public static void main(String[] args) {
		Que q = new Que();
		
		new Consumer(q);
		
		new Producer(q);
	}

}
