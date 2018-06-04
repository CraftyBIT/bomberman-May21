// Project Bomberman

public class Bomb extends Actor
{
	private int bombPower;
	private int time = 0;
	private final int explodeTime = 30; //explode after 3 seconds
	
	public Bomb(int row, int column, int power)
	{
		super(row, column);
		bombPower = power;		
	}
	
	public boolean boom() {
		time++;
		if (time == explodeTime) {
			time = 0;
			return true;
		}
		return false;
		
	}
	
	public int getPower()
	{
		return bombPower;
	}
}
