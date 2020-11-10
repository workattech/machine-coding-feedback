
public class Ladder implements Dynamics{
	private int startLocation = 0;
	private int endLocation = 0;
	
	Ladder (int x, int y) {
		this.startLocation = x;
		this.endLocation = y;
	}
	
	public int getstartLocation () {
		return startLocation;
	}

	public int getendLocation () {
		return endLocation;
	}
}
