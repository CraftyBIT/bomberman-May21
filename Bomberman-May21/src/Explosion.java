// Project Bomberman

public class Explosion extends Actor
{
	private int time;
	private final int clearTime = 2; // ~quarter a second
	
	public Explosion(int row, int column)
	{
		super(row, column);
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
}
