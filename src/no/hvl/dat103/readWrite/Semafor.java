package no.hvl.dat103.readWrite;

public class Semafor {
	private int ledig_count;
	
	public Semafor(int ledig_count) {
		this.ledig_count = ledig_count;
	}
	
	void vent() {
		while(ledig_count <= 0) {
			Thread.yield();
		}
		ledig_count--;
	}
	
	void signal() {
		ledig_count++;
	}
}

