package no.hvl.dat103.buffer.java;

public class Main {
	 public static void main(String[] args){
	        BBuffer buffer = new BBuffer();
	        Consumer c1 = new Consumer(buffer);
	        Producer p1 = new Producer(buffer);
	        c1.start();
	        p1.start();
	    }
}
