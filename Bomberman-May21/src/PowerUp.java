// Project Bomberman

public class PowerUp extends Actor
{
	private int powerUpId;
	
	public PowerUp(int row, int column)
	{
		super(row, column);
		powerUpId = (int)(Math.random() * 2);
	}
	
	public int getId()
	{
		return powerUpId;
	}
}
