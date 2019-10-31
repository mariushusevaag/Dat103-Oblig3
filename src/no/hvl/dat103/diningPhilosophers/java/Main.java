package no.hvl.dat103.diningPhilosophers.java;

public class Main {
	public static void main(String[] args) {
		Table table = new Table(5);

		table.prepareSticks();
		table.populate();
		table.startDinner();
	}
}