package models;

public class Ladder {
	private int start,end;
	public Ladder(int start,int end)
	{
		if(start>=end)
			throw new IllegalArgumentException("start must be smaller than end");
		this.start=start;
		this.end=end;
	}
	public int getStart()
	{
		return start;
	}
	public int getEnd()
	{
		return end;
	}
}
