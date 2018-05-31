import java.util.*;		// access to Scanner
import java.io.*;			// access to IOException

import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and JComponents

import java.net.URL;		// added for JAR file access

public class TileMap {
	public int[][] textMap;
	public static final int mapWidth = 23, mapHeight = 7;
	private static int tileSize = 64;
	Image bomb, breakable, stoneTile, unbreakable;
	
	public TileMap(String map) {
		ImageLoader imageLoader = new ImageLoader();
		ClassLoader cldr = TileMap.class.getClassLoader();
		URL mapURL = cldr.getResource(map);
		readFile(mapURL);
		
		bomb = imageLoader.getBombImage().getImage();
		breakable = imageLoader.getBreakableImage().getImage();
		stoneTile = imageLoader.getStoneTileImage().getImage();
		unbreakable = imageLoader.getUnbreakableImage().getImage();
	}
	
	public int[][] getMap() {
		return textMap;
	}
	
	public void readFile(URL resource)
	{
		textMap = new int[mapWidth][mapHeight];

		try
		{
			Scanner file = new Scanner(resource.openStream());			
			for (int i = 0; i < mapWidth; i++)
			{
				for (int j = 0; j < mapHeight; j++)
				{
					textMap[i][j] = file.nextInt();
				}
			}
			file.close();
		}
		catch  (Exception e){
	    	System.out.println("IO Exception: " + e);
	    }
	}
	
	public void draw() {
		
	}
	
	
}
