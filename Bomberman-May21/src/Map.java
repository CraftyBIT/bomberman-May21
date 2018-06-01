import info.gridworld.actor.Actor;
import info.gridworld.actor.Block;
import info.gridworld.actor.Bomber;

import java.util.*;		// access to Scanner
import java.io.*;			// access to IOException
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent

import javax.swing.*;       // access to JFrame and JComponents

import java.net.URL;		// added for JAR file access

public class Map 
{
	public int[][] intMap;
	public static final int mapWidth = 15, mapHeight = 11;
	private static int tileSize = 64;
	Image bomb, breakable, stoneTile, unbreakable;
	public Actor[][] actorMap;
	
	public Map(String map) 
	{
		ImageLoader imageLoader = new ImageLoader();
		ClassLoader cldr = Map.class.getClassLoader();
		URL mapURL = cldr.getResource(map);
		readFile(mapURL);
		
		bomb = imageLoader.getBombImage().getImage();
		breakable = imageLoader.getBreakableImage().getImage();
		stoneTile = imageLoader.getStoneTileImage().getImage();
		unbreakable = imageLoader.getUnbreakableImage().getImage();
	}
	
	public Actor[][] getMap() 
	{
		return actorMap;
	}
	
	public void readFile(URL resource)
	{
		intMap = new int[mapWidth][mapHeight];

		try
		{
			Scanner file = new Scanner(resource.openStream());			
			for (int i = 0; i < mapWidth; i++)
			{
				for (int j = 0; j < mapHeight; j++)
				{
					intMap[i][j] = file.nextInt();
				}
			}
			file.close();
		}
		catch  (Exception e)
		{
	    	System.out.println("IO Exception: " + e);
	    }
		
		int row = 0, col = 0;
		
		for (int[] r : intMap){
    		for (int c: r){
    			switch (c){
    			case 1: Bomber p1 = new Bomber(row, col);
    					actorMap[row][col] = p1;
    			case 2: Bomber p2 = new Bomber(row, col);
    					actorMap[row][col] = p2;
    			case 3: Block u = new Block(false);
    					actorMap[row][col] = u;
    			case 4: Block b = new Block(true);
    					actorMap[row][col] = b;
    			}
    			col++;
    		}
    		row++;
    	}
	}
	
	public void draw()
	{
		
	}
}
