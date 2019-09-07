package main.java.model;

public class Snake {
	private int head;
	private int tail;
	
	public Snake(int head, int tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + head;
		result = prime * result + tail;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snake other = (Snake) obj;
		if (head != other.head)
			return false;
		if (tail != other.tail)
			return false;
		return true;
	}
	
}
