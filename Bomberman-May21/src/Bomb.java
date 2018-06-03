// Project Bomberman

public class Bomb extends Actor
{
	private int bombPower;
	
	public Bomb(int row, int column, int power)
	{
		super(row, column);
		bombPower = power;
	}
	
	public int getPower()
	{
		return bombPower;
	}
}
