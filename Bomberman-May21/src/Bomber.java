// Project Bomberman

public class Bomber extends Actor
{
	private int myBombs, myPower, bombsPlaced, myplayerId;
	
	public Bomber(int playerId)
	{
		super();
		myBombs = 1; // Number of bombs that can be placed at any given moment
		myPower = 1;
		bombsPlaced = 0;
		myplayerId = playerId;
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
	
	public void placeBomb()
	{
		bombsPlaced++;
	}
	
	public void exploded()
	{
		bombsPlaced--;
	}
	
	public boolean ableToPlace()
	{
		if (bombsPlaced < myBombs)
		{
			return true;
		}
		
		return false;
	}
	
	public int getId()
	{
		return myplayerId;
	}
}