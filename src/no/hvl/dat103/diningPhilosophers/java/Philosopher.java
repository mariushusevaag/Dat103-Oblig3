package no.hvl.dat103.diningPhilosophers.java;

public class Philosopher implements Runnable {
	private int number;

	private Chopstick first;
	private Chopstick second;

	public Philosopher(int number, Chopstick first, Chopstick second) {
		this.number = number;
		this.first = first;
		this.second = second;
	}

	public void eat() {
		first.grab();

		System.out.println(String.format("Philosopher %s has grabbed their first chopstick", number));

		second.grab();

		System.out.println(String.format("Philosopher %s has grabbed their second chopstick", number));


		System.out.println(String.format("Philosopher %s is eating", number));

		try {
			Thread.sleep(200);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(String.format("Philosopher %s is done eating", number));

		second.release();

		System.out.println(String.format("Philosopher %s has released their second chopstick", number));

		first.release();

		System.out.println(String.format("Philosopher %s has released their first chopstick", number));
	}

	@Override
	public void run() {
		while (true) {
			eat();
		}
	}
}