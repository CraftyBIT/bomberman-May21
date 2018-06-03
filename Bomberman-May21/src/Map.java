// Project Bomberman

import java.net.URL;

import java.util.*;

public class Map
{
	public static final int mapRows = 11, mapColumns = 15;
	
	private int[][] intMap;
	private Actor[][] actorMap;
	private int rowLoc, rowLoc2, colLoc, colLoc2;
	
	public Map(String map)
	{
		ClassLoader cldr = Map.class.getClassLoader();
		readFile(cldr.getResource(map));
		
		rowLoc = actorMap[1][1].getRow();
		colLoc = actorMap[1][1].getColumn();
		
		rowLoc2 = actorMap[9][13].getRow();
		colLoc2 = actorMap[9][13].getColumn();
	}
	
	public void player1Move(char ch)
	{
		if (ch == 'W')
		{
			if (actorMap[rowLoc - 1][colLoc] instanceof UnbreakableBlock == false && actorMap[rowLoc - 1][colLoc] instanceof BreakableBlock == false && actorMap[rowLoc - 1][colLoc] instanceof Bomb == false && actorMap[rowLoc - 1][colLoc] instanceof Bomber == false)
			{
				actorMap[rowLoc - 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc--;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc + 1][colLoc] instanceof UnbreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof BreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof Bomb == false && actorMap[rowLoc + 1][colLoc] instanceof Bomber == false)
			{
				actorMap[rowLoc + 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc++;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc][colLoc - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof Bomb == false && actorMap[rowLoc][colLoc - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc - 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc--;
			}
		}
		
		if (ch == 'D')
		{
			if (actorMap[rowLoc][colLoc + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof Bomb == false && actorMap[rowLoc][colLoc + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc + 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc++;
			}
		}
	}
	
	public void player2Move(char ch)
	{
		if (ch == 'W')
		{
			if (actorMap[rowLoc2 - 1][colLoc2] instanceof UnbreakableBlock == false && actorMap[rowLoc2 - 1][colLoc2] instanceof BreakableBlock == false && actorMap[rowLoc2 - 1][colLoc2] instanceof Bomb == false && actorMap[rowLoc2 - 1][colLoc2] instanceof Bomber == false)
			{
				actorMap[rowLoc2 - 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2--;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc2 + 1][colLoc2] instanceof UnbreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof BreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomb == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomber == false)
			{
				actorMap[rowLoc2 + 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2++;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc2][colLoc2 - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 - 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2--;
			}
		}
		
		if (ch == 'D')
		{
			if (actorMap[rowLoc2][colLoc2 + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 + 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2++;
			}
		}
	}
	
	public Actor[][] getMap()
	{
		return actorMap;
	}
	
	public void readFile(URL mapURL)
	{
		intMap = new int[mapRows][mapColumns];
		
		try
		{
			Scanner file = new Scanner(mapURL.openStream());			
			for (int row = 0; row < mapRows; row++)
			{
				for (int col = 0; col < mapColumns; col++)
				{
					intMap[row][col] = file.nextInt();
				}
			}
			file.close();
		}
		catch (Exception e)
		{
			System.out.println("IO Exception: " + e);
		}
		
		actorMap = new Actor[mapRows][mapColumns];
		
		for (int row = 0; row < mapRows; row++)
		{
			for (int col = 0; col < mapColumns; col++)
			{
				switch (intMap[row][col])
				{
					case 1: Bomber player1 = new Bomber(row, col);
							actorMap[row][col] = player1;
							break;
							
					case 2: Bomber player2 = new Bomber(row, col);
							actorMap[row][col] = player2;
							break;
							
					case 3: UnbreakableBlock uBlock = new UnbreakableBlock(row, col);
							actorMap[row][col] = uBlock;
							break;
							
					case 4: BreakableBlock bBlock = new BreakableBlock(row, col);
							actorMap[row][col] = bBlock;
							break;
				}
			}
		}
	}
}
