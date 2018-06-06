// Project Bomberman

public class Explosion extends Actor
{
	private final int clearTime = 2; // About a quarter of a second
	private int time, myRow, myColumn;
	
	public Explosion(int row, int column)
	{
		myRow = row;
		myColumn = column;
		time = 0;
	}
	
	public boolean clear()
	{
		time++;
		if (time == clearTime) 
		{
			time = 0;
			return true;
		}
		
		return false;
	}
	
	public int getRow()
	{
		return myRow;
	}
	
	public int getColumn()
	{
		return myColumn;
	}
}