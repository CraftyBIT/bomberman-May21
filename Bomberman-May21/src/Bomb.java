// Project Bomberman

public class Bomb extends Actor
{
	private int bombPower, playerId;
	private int time;
	private final int explodeTime = 30; //explode after 3 seconds
	
	public Bomb(int row, int column, int power, int player)
	{
		super(row, column);
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
	
	public int getPlayer()
	{
		return playerId;
	}
	
	public int getPower()
	{
		return bombPower;
	}
}
