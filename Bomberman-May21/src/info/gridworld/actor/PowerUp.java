package info.gridworld.actor;

import info.gridworld.actor.Rock;

import java.awt.Color;

public class PowerUp extends Rock
{
	
	private int powerUpID;
	
	public PowerUp()
	{
		powerUpID = (int)(Math.random() * 2); //change to number of powerup types
	}
	
	int getID()
	{
		return powerUpID;
	}
	

}
