package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Block extends Rock
{
	private boolean canBreak; //determines whether block is breakable or no
	
	public Block(boolean cB)
  {
    canBreak = cB;
	}
	
	boolean isBreakable(){
		return isBreakable;
	}
  
  //pre-condition: the block isBreakable
  void Break()
  {
    if (!canBreak) //still to check if block is actually breakable depending on how other classes work
      return;
      
    Location currentLoc = getLocation();
    
    if (Math.random() < .5) //probabily of powerup is 50% 
    {
      PowerUp pu = new PowerUp(1);  //INCOMPLETE: Make a random chance of spawning a Powerup ID)
      pu.putSelfInGrid(currentLoc);
      removeSelfFromGrid();
    }
    
    removeSelfFromGrid();
  }
	



}
