package no.hvl.dat103.diningPhilosophers;


public class Table {
	private int count;
	private Philosopher[] philosophers;
	private Chopstick[] chopsticks;

	public Table(int count) {
		this.count = count;

		this.chopsticks = new Chopstick[count];
		this.philosophers = new Philosopher[count];

	}

	public void prepareSticks() {
		for (int i = 0; i < count; i++) {
			chopsticks[i] = new Chopstick();
		}
	}

	public void populate() {
		// Philosophers should alternate what chopstick they want to pick up first
		// This makes it easier to prevent deadlocks where each of them grab the one to their right
		for (int i = 0; i < count; i++) {
			Chopstick first = null;
			Chopstick second = null;

			if (i % 2 == 0) {
				first = chopsticks[i];
				second = chopsticks[(i + 1) % count];

			} else {
				first = chopsticks[(i + 1) % count];
				second = chopsticks[i];
			}

			philosophers[i] = new Philosopher(i, first, second);
		}
	}

	public void startDinner() {
		for (Philosopher p : philosophers) {
			(new Thread(p)).start();
		}
	}
}