// Project Bomberman

import java.awt.event.*;
import java.net.URL;

import java.util.*;

import javax.swing.Timer;

public class Map implements ActionListener
{
	public static final int mapRows = 11, mapColumns = 15;
	
	private int[][] intMap;
	private Actor[][] actorMap;
	private int rowLoc, rowLoc2, colLoc, colLoc2;
	private int b1rl, b1cl, b2rl, b2cl; // Stores bomb locations for Players 1 and 2
	private boolean moved1, moved2;
	private Bomber player1, player2;
	
	public Map(String map) 
	{
		ClassLoader cldr = Map.class.getClassLoader();
		readFile(cldr.getResource(map));
		
		rowLoc = 1;
		colLoc = 1;
		
		rowLoc2 = 9;
		colLoc2 = 13;
		
		b1rl = b1cl = b2rl = b2cl = -1;
		
		Timer timer = new Timer(100, this);
		timer.start();
	}
	
	public void player1Move(char ch)
	{
		if (ch == 'W')
		{
			if (actorMap[rowLoc - 1][colLoc] instanceof PowerUp)
			{
				if (actorMap[rowLoc - 1][colLoc].getId() == 0)
				{
					player1.addBombs();
				}
				else
				{
					player1.addPower();
				}
				
				actorMap[rowLoc - 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc--;
				moved1 = true;
			}
			else if (actorMap[rowLoc - 1][colLoc] instanceof UnbreakableBlock == false && actorMap[rowLoc - 1][colLoc] instanceof BreakableBlock == false && actorMap[rowLoc - 1][colLoc] instanceof Bomb == false && actorMap[rowLoc - 1][colLoc] instanceof Bomber == false)
			{
				actorMap[rowLoc - 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc--;
				moved1 = true;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc + 1][colLoc] instanceof PowerUp)
			{
				if (actorMap[rowLoc + 1][colLoc].getId() == 0)
				{
					player1.addBombs();
				}
				else
				{
					player1.addPower();
				}
				
				actorMap[rowLoc + 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc++;
				moved1 = true;
			}
			
			else if (actorMap[rowLoc + 1][colLoc] instanceof UnbreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof BreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof Bomb == false && actorMap[rowLoc + 1][colLoc] instanceof Bomber == false)
			{
				actorMap[rowLoc + 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc++;
				moved1 = true;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc][colLoc - 1] instanceof PowerUp)
			{
				if (actorMap[rowLoc][colLoc - 1].getId() == 0)
				{
					player1.addBombs();
				}
				else
				{
					player1.addPower();
				}
				
				actorMap[rowLoc][colLoc - 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc--;
				moved1 = true;
			}
			
			else if (actorMap[rowLoc][colLoc - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof Bomb == false && actorMap[rowLoc][colLoc - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc - 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc--;
				moved1 = true;
			}
		}
		
		if (ch == 'D')
		{
			if (actorMap[rowLoc][colLoc + 1] instanceof PowerUp)
			{
				if (actorMap[rowLoc][colLoc + 1].getId() == 0)
				{
					player1.addBombs();
				}
				else
				{
					player1.addPower();
				}
				
				actorMap[rowLoc][colLoc + 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc++;
				moved1 = true;
			}
			
			else if (actorMap[rowLoc][colLoc + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof Bomb == false && actorMap[rowLoc][colLoc + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc + 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc++;
				moved1 = true;
			}
		}
		
		if (moved1) 
		{
			startBomb('1');
			moved1 = false;
		}
	}
	
	public void player2Move(char ch)
	{
		if (ch == 'W')
		{
			if (actorMap[rowLoc2 - 1][colLoc2] instanceof PowerUp)
			{
				if (actorMap[rowLoc2 - 1][colLoc2].getId() == 0)
				{
					player2.addBombs();
				}
				else
				{
					player2.addPower();
				}
				
				actorMap[rowLoc2 - 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2--;
				moved1 = true;
			}
			
			else if (actorMap[rowLoc2 - 1][colLoc2] instanceof UnbreakableBlock == false && actorMap[rowLoc2 - 1][colLoc2] instanceof BreakableBlock == false && actorMap[rowLoc2 - 1][colLoc2] instanceof Bomb == false && actorMap[rowLoc2 - 1][colLoc2] instanceof Bomber == false)
			{
				actorMap[rowLoc2 - 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2--;
				moved2 = true;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc2 + 1][colLoc2] instanceof PowerUp)
			{
				if (actorMap[rowLoc2 + 1][colLoc2].getId() == 0)
				{
					player2.addBombs();
				}
				else
				{
					player2.addPower();
				}
				
				actorMap[rowLoc2 + 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2++;
				moved2 = true;
			}
			
			else if (actorMap[rowLoc2 + 1][colLoc2] instanceof UnbreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof BreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomb == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomber == false)
			{
				actorMap[rowLoc2 + 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2++;
				moved2 = true;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc2][colLoc2 - 1] instanceof PowerUp)
			{
				if (actorMap[rowLoc2][colLoc2 - 1].getId() == 0)
				{
					player2.addBombs();
				}
				else
				{
					player2.addPower();
				}
				
				actorMap[rowLoc2][colLoc2 - 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2--;
				moved2 = true;
			}
			
			else if (actorMap[rowLoc2][colLoc2 - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 - 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2--;
				moved2 = true;
			}
		}
		
		if (ch == 'D')
		{
			if  (actorMap[rowLoc2][colLoc2 + 1] instanceof PowerUp)
			{
				if (actorMap[rowLoc2][colLoc2 + 1].getId() == 0)
				{
					player2.addBombs();
				}
				else
				{
					player2.addPower();
				}
				
				actorMap[rowLoc2][colLoc2 + 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2++;
				moved2 = true;
			}
			
			else if (actorMap[rowLoc2][colLoc2 + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 + 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2++;
				moved2 = true;
			}
		}
		
		if (moved2) 
		{
			startBomb('2');
			moved2 = false;
		}
	}
	
	public void dropBomb(char ch) 
	{
		if (ch == '1' && player1.ableToPlace()) 
		{
			b1rl = rowLoc;
			b1cl = colLoc;
		}
		else if (ch == '2' && player2.ableToPlace()) 
		{
			b2rl = rowLoc2;
			b2cl = colLoc2;
		}
	}
	
	public void startBomb(char ch) 
	{
		if (ch == '1') 
		{
			if (b1rl != -1 && player1.ableToPlace()) 
			{
				Bomb boom = new Bomb(b1rl, b1cl, player1.getPower(), 1);
				actorMap[b1rl][b1cl] = boom;
				player1.placeBomb();
				b1rl = b1cl = -1;
			}
		}
		else if (ch == '2') 
		{
			if (b2rl != -1 && player2.ableToPlace()) 
			{
				Bomb boom = new Bomb(b2rl, b2cl, player2.getPower(), 2);
				actorMap[b2rl][b2cl] = boom;
				player2.placeBomb();
				b2rl = b2cl = -1;
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
					case 1: player1 = new Bomber(1);
							actorMap[row][col] = player1;
							break;
							
					case 2: player2 = new Bomber(2);
							actorMap[row][col] = player2;
							break;
							
					case 3: UnbreakableBlock uBlock = new UnbreakableBlock();
							actorMap[row][col] = uBlock;
							break;
							
					case 4: BreakableBlock bBlock = new BreakableBlock();
							actorMap[row][col] = bBlock;
							break;
				}
			}
		}
	}

	public void explode(int r, int c, int power) 
	{
		actorMap[r][c] = new Explosion(r, c);
		
		boolean broken = false;
		for (int u = 1; u <= power; u++) // Upwards Explosion
		{
			if (!(actorMap[r + u][c] instanceof UnbreakableBlock) && !(actorMap[r + u][c] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r + u, c);
				if (actorMap[r + u][c] instanceof BreakableBlock)
				{
					broken = true;
				
					if (1 == (int) (Math.random() * 2))
					{
						actorMap[r + u][c] = new PowerUp();
					}
					else
					{
						actorMap[r + u][c] = ex;
					}
				}
				else
				{
					actorMap[r + u][c] = ex;
				}
			}
			else
			{
				break;
			}
		}
		
		broken = false;
		for (int d = 1; d <= power; d++) // Downwards Explosion
		{
			if (!(actorMap[r - d][c] instanceof UnbreakableBlock) && !(actorMap[r - d][c] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r - d, c);
				if (actorMap[r - d][c] instanceof BreakableBlock)
				{
					broken = true;
				
					if (1 == (int) (Math.random() * 2))
					{
						actorMap[r - d][c] = new PowerUp();
					}
					else
					{
						actorMap[r - d][c] = ex;
					}
				}
				else
				{
					actorMap[r - d][c] = ex;
				}
			}
			else 
			{
				break;
			}
		}
		
		broken = false;
		for (int l = 1; l <= power; l++) // Left Explosion
		{
			if (!(actorMap[r][c - l] instanceof UnbreakableBlock) && !(actorMap[r][c - 1] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r, c - l);
				if (actorMap[r][c - l] instanceof BreakableBlock)
				{
					broken = true;
				
					if (1 == (int) (Math.random() * 2))
					{
						actorMap[r][c - l] = new PowerUp();
					}
					else
					{
						actorMap[r][c - l] = ex;
					}
					
				}
				else
				{
					actorMap[r][c - l] = ex;
				}
			}
			else 
			{
				break;
			}
		}
		
		broken = false;
		for (int right = 1; right <= power; right++) // Right Explosion
		{
			if (!(actorMap[r][c + right] instanceof UnbreakableBlock) && !(actorMap[r][c + right] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r, c + right);
				if (actorMap[r][c + right] instanceof BreakableBlock)
				{
					broken = true;
				
					if (1 == (int) (Math.random() * 2))
					{
						actorMap[r][c + right] = new PowerUp();
					}
					else
					{
						actorMap[r][c + right] = ex;
					}
				}
				else
				{
					actorMap[r][c + right] = ex;
				}
			}
			else 
			{
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		for(Actor[] row: actorMap) 
		{
			for (Actor a: row) 
			{
				if (a instanceof Bomb) 
				{
					if (((Bomb) a).boom())
					{
						if (a.getPlayer() == 1)
						{
							player1.exploded();
						}
						else if (a.getPlayer() == 2)
						{
							player2.exploded();
						}
						explode(((Bomb) a).getRow(), ((Bomb) a).getColumn(), ((Bomb) a).getPower());
					}
				}
				else if (a instanceof Explosion) 
				{
					if (((Explosion) a).clear())
					{
						int tRow = ((Explosion) a).getRow();
						int tCol = ((Explosion) a).getColumn();
						actorMap[tRow][tCol] = null;
					}
				}
			}
		}
	}
}
