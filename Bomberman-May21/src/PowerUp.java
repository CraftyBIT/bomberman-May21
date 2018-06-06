// Project Bomberman

public class PowerUp extends Actor
{
	private int powerUpId; // 0 = Bomb Amount, 1 = Bomb Power
	
	public PowerUp()
	{
		super();
		powerUpId = (int)(Math.random() * 2);
	}
	
	public int getId()
	{
		return powerUpId;
	}
}