// Project Bomberman

public class Bomb extends Actor
{
	private final int explodeTime = 20; // Bomb explodes after 2 seconds
	private int bombPower, playerId, time, myRow, myColumn;
	
	public Bomb(int row, int column, int power, int player)
	{
		myRow = row;
		myColumn = column;
		bombPower = power;		
		playerId = player;
		time = 0;
	}
	
	public boolean boom()
	{
		time++;
		if (time == explodeTime) 
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
	
	public int getPlayer()
	{
		return playerId;
	}
	
	public int getPower()
	{
		return bombPower;
	}
}