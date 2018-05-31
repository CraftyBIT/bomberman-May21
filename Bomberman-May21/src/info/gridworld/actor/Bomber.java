package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Bomber extends Actor
{
	private int myBombs; // Amount of Bombs placed by this Actor on the Grid at instance

	private int myPower; // Strength of Bombs placed by this Actor (Explosion Radius)
	
	private boolean bombPlaced;
	private Location loc;
	
	public Bomber(int r, int c){
		myBombs = 3; //start with 3 bombs
		myPower = 2; //start with 2 power
		loc = new Location (r, c);
	}
	
	int getBombs(){
		return myBombs;
	}
	
	int getPower(){
		return myPower;
	}
	
	void addBombs(){
		myBombs++;
	}
	
	void addBombs(int num){
		myBombs+=num;
	}
	
	void addPower(){
		myPower++;
	}
	
	void addPower(int num){
		myPower+=num;
	}
	
	boolean bombDown(){
		return bombPlaced;
	}
	
	


}
