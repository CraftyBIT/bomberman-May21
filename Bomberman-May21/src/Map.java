// Project Bomberman

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.util.*;

import javax.swing.Timer;

public class Map implements ActionListener
{
	public static final int mapRows = 11, mapColumns = 15;
	
	private int[][] intMap;
	private Actor[][] actorMap;
	private int rowLoc, rowLoc2, colLoc, colLoc2;
	private int p1ba, p1bp, p2ba, p2bp; // players bomb amount and bomb power
	private int b1rl, b1cl, b2rl, b2cl; //stores bomb locations for players 1 and 2
	private int bpp1, bpp2; // bombs placed players 1 and 2
	private boolean moved1, moved2;
	
	public Map(String map) 
	{
		ClassLoader cldr = Map.class.getClassLoader();
		readFile(cldr.getResource(map));
		
		rowLoc = actorMap[1][1].getRow();
		colLoc = actorMap[1][1].getColumn();
		
		rowLoc2 = actorMap[9][13].getRow();
		colLoc2 = actorMap[9][13].getColumn();
		
		p1ba = p1bp = p2ba = p2bp = 1;
		
		bpp1 = bpp2 = 0;
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
					actorMap[rowLoc][colLoc].addBombs();
					p1ba++;
				}
				else
				{
					actorMap[rowLoc][colLoc].addPower();
					p1bp++;
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
					actorMap[rowLoc][colLoc].addBombs();
					p1ba++;
				}
				else
				{
					actorMap[rowLoc][colLoc].addPower();
					p1bp++;
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
					actorMap[rowLoc][colLoc].addBombs();
					p1ba++;
				}
				else
				{
					actorMap[rowLoc][colLoc].addPower();
					p1bp++;
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
					actorMap[rowLoc][colLoc].addBombs();
					p1ba++;
				}
				else
				{
					actorMap[rowLoc][colLoc].addPower();
					p1bp++;
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
					actorMap[rowLoc2][colLoc2].addBombs();
					p2ba++;
				}
				else
				{
					actorMap[rowLoc2][colLoc2].addPower();
					p2bp++;
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
					actorMap[rowLoc2][colLoc2].addBombs();
					p2ba++;
				}
				else
				{
					actorMap[rowLoc2][colLoc2].addPower();
					p2bp++;
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
					actorMap[rowLoc2][colLoc2].addBombs();
					p2ba++;
				}
				else
				{
					actorMap[rowLoc2][colLoc2].addPower();
					p2bp++;
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
					actorMap[rowLoc2][colLoc2].addBombs();
					p2ba++;
				}
				else
				{
					actorMap[rowLoc2][colLoc2].addPower();
					p2bp++;
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
		if (ch == '1' && p1ba > bpp1) 
		{
			b1rl = rowLoc;
			b1cl = colLoc;
		}
		else if (ch == '2' && p2ba > bpp2) 
		{
			b2rl = rowLoc2;
			b2cl = colLoc2;
		}
	}
	
	public void startBomb(char ch) 
	{
		if (ch == '1') 
		{
			if (b1rl != -1 && p1ba > bpp1) 
			{
				Bomb boom = new Bomb(b1rl, b1cl, p1bp, 1);
				actorMap[b1rl][b1cl] = boom;
				bpp1++;
				b1rl = b1cl = -1;
			}
		}
		else if (ch == '2') 
		{
			if (b2rl != -1 && p2ba > bpp2) 
			{
				Bomb boom = new Bomb(b2rl, b2cl, p2bp, 2);
				actorMap[b2rl][b2cl] = boom;
				bpp2++;
				b2rl = b2cl = -1;
			}
		}
	}
	
	public void explode(Bomb boop) 
	{
		int row = boop.getRow();
		int col = boop.getColumn();
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

	public void explode(int r, int c, int power) 
	{
		Explosion mid = new Explosion(r, c);
		actorMap[r][c] = mid;
		boolean broken;
		broken = false;
		
		for (int u = 1; u <= power; u++) 
		{ // up
			if (!(actorMap[r + u][c] instanceof UnbreakableBlock) && !(actorMap[r + u][c] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r + u, c);
				if (actorMap[r + u][c] instanceof BreakableBlock)
				{
					broken = true;
				}
				
				int rand = (int) (Math.random() * 2);
				if (rand == 1)
				{
					PowerUp powerUp = new PowerUp(r + u, c);
					actorMap[r + u][c] = powerUp;
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
		for (int d = 1; d <= power; d++) 
		{ //down
			if (!(actorMap[r - d][c] instanceof UnbreakableBlock) && !(actorMap[r - d][c] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r - d, c);
				if (actorMap[r - d][c] instanceof BreakableBlock)
				{
					broken = true;
				}
				actorMap[r - d][c] = ex;
			}
			else 
			{
				break;
			}
		}
		
		broken = false;
		
		for (int l = 1; l <= power; l++) 
		{ //left
			if (!(actorMap[r][c - l] instanceof UnbreakableBlock) && !(actorMap[r][c - 1] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r, c - l);
				if (actorMap[r][c - l] instanceof BreakableBlock)
				{
					broken = true;
				}
				actorMap[r][c - l] = ex;
			}
			else 
			{
				break;
			}
		}
		broken = false;
		for (int right = 1; right <= power; right++) 
		{ //right
			if (!(actorMap[r][c + right] instanceof UnbreakableBlock) && !(actorMap[r][c + right] instanceof Bomb) && !broken) 
			{
				Explosion ex = new Explosion(r, c + r);
				if (actorMap[r][c + right] instanceof BreakableBlock)
				{
					broken = true;
				}
				actorMap[r][c + right] = ex;
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
							bpp1--;
						}
						else if (a.getPlayer() == 2)
						{
							bpp2--;
						}
						explode(((Bomb) a).getRow(), ((Bomb) a).getColumn(), ((Bomb) a).getPower());
					}
				}
				else if (a instanceof Explosion) 
				{
						if (((Explosion) a).clear())
						{
							int tRow = a.getRow();
							int tCol = a.getColumn();
							actorMap[tRow][tCol] = null;
						}
				}
			}
		}
	}
}
