package no.hvl.dat103.diningPhilosophers;

public class Semafor {
	private int count;
	
	public Semafor(int count) {
		this.count = count;
	}
	
	public void vent() {
		while(count <= 0) {
			Thread.yield();
		}
		count--;
	}
	
	public void signal() {
		count++;
	}
}
