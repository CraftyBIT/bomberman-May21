//Written by Richard Zhu
//2018 Final Project APCS

package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Block extends Rock
{
	private boolean canBreak; //determines whether block is breakable or no
	
	public Block()//if empty constructor, canBreak = true
  	{
   		 canBreak = true;
	}
	
	public Block(boolean cB)
  	{
   		 canBreak = cB;
	}
	
	public boolean isBreakable()
	{
		return canBreak;
	}

  	public void destruct()
  	{
   		if (!canBreak) //still to check if block is actually breakable depending on how other classes work
      			{return;}
      
    		Location currentLoc = getLocation();
		Grid g = getGrid();
    
    		if (Math.random() < .5) //probabily of powerup is 50% 
    		{
      			PowerUp pu = new PowerUp(); 
			removeSelfFromGrid();
      			pu.putSelfInGrid(g, currentLoc);	
      			return;
   		}
   		 removeSelfFromGrid();
  	}
}
