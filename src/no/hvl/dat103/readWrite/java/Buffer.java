package no.hvl.dat103.readWrite.java;

import java.util.ArrayList;

public class Buffer {
	private ArrayList<Integer> list;
	private int readers;

	public Buffer() {
		list = new ArrayList<>();
		readers = 0;
	}

	public void add(Integer v) {
		list.add(v);
	}

	public Integer remove() {
		if (!list.isEmpty()) {
			return list.remove(0);
		}

		return -1;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getReaders() {
		return readers;
	}

	public void setReaders(int readers) {
		this.readers = readers;
	}
}