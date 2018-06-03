// Project Bomberman

public class Bomber extends Actor
{
	private int myBombs, myPower;
	
	public Bomber(int row, int column)
	{
		super(row, column);
		myBombs = 1;
		myPower = 1;
	}
	
	public void addBombs()
	{
		myBombs++;
	}
	
	public void addPower()
	{
		myPower++;
	}
	
	public int getBombs()
	{
		return myBombs;
	}
	
	public int getPower()
	{
		return myPower;
	}
}
