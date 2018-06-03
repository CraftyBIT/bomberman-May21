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
	private int b1rl, b1cl, b2rl, b2cl; //stores bomb locations for players 1 and 2
	private boolean moved1, moved2;
	
	public Map(String map) 
	{
		ClassLoader cldr = Map.class.getClassLoader();
		readFile(cldr.getResource(map));
		
		rowLoc = actorMap[1][1].getRow();
		colLoc = actorMap[1][1].getColumn();
		
		rowLoc2 = actorMap[9][13].getRow();
		colLoc2 = actorMap[9][13].getColumn();
		
		b1rl = b1cl = b2rl = b2cl = -1;
		
		Timer timer = new Timer(100, this);
		timer.start();
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
				moved1 = true;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc + 1][colLoc] instanceof UnbreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof BreakableBlock == false && actorMap[rowLoc + 1][colLoc] instanceof Bomb == false && actorMap[rowLoc + 1][colLoc] instanceof Bomber == false)
			{
				actorMap[rowLoc + 1][colLoc] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				rowLoc++;
				moved1 = true;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc][colLoc - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc - 1] instanceof Bomb == false && actorMap[rowLoc][colLoc - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc - 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc--;
				moved1 = true;
			}
		}
		
		if (ch == 'D')
		{
			if (actorMap[rowLoc][colLoc + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof BreakableBlock == false && actorMap[rowLoc][colLoc + 1] instanceof Bomb == false && actorMap[rowLoc][colLoc + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc][colLoc + 1] = actorMap[rowLoc][colLoc];
				actorMap[rowLoc][colLoc] = null;
				colLoc++;
				moved1 = true;
			}
		}
		
		if (moved1) {
			startBomb('1');
			moved1 = false;
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
				moved2 = true;
			}
		}
		
		if (ch == 'S')
		{
			if (actorMap[rowLoc2 + 1][colLoc2] instanceof UnbreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof BreakableBlock == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomb == false && actorMap[rowLoc2 + 1][colLoc2] instanceof Bomber == false)
			{
				actorMap[rowLoc2 + 1][colLoc2] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				rowLoc2++;
				moved2 = true;
			}
		}
		
		if (ch == 'A')
		{
			if (actorMap[rowLoc2][colLoc2 - 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 - 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 - 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2--;
				moved2 = true;
			}
		}
		
		if (ch == 'D')
		{
			if (actorMap[rowLoc2][colLoc2 + 1] instanceof UnbreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof BreakableBlock == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomb == false && actorMap[rowLoc2][colLoc2 + 1] instanceof Bomber == false)
			{
				actorMap[rowLoc2][colLoc2 + 1] = actorMap[rowLoc2][colLoc2];
				actorMap[rowLoc2][colLoc2] = null;
				colLoc2++;
				moved2 = true;
			}
		}
		
		if (moved2) {
			startBomb('2');
			moved2 = false;
		}
	}
	
	public void dropBomb(char ch) {
		if (ch == '1') {
			b1rl = rowLoc;
			b1cl = colLoc;
		}
		else if (ch == '2') {
			b2rl = rowLoc2;
			b2cl = colLoc2;
		}
		
	}
	
	public void startBomb(char ch) {
		if (ch == '1') {
			if (b1rl != -1) {
				Bomb boom = new Bomb(b1rl, b1cl, 3);
				actorMap[b1rl][b1cl] = boom;
				b1rl = b1cl = -1;
				
			}
		}
		else if (ch == '2') {
			if (b2rl != -1) {
				Bomb boom = new Bomb(b2rl, b2cl, 3);
				actorMap[b2rl][b2cl] = boom;
				b2rl = b2cl = -1;
			}
		}
	}
	
	public void explode(Bomb boop) {
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

	public void explode(int r, int c, int power) {
		actorMap[r][c] = null;
		for (int u = 1; u <= power; u++) { //up
			if (!(actorMap[r + u][c] instanceof UnbreakableBlock)) {
				Smoke s = new Smoke(r + u, c);
				actorMap[r + u][c] = null;
			}
			else
				break;
		}
		for (int d = 1; d <= power; d++) { //down
			if (!(actorMap[r - d][c] instanceof UnbreakableBlock)) {
				Smoke s = new Smoke(r - d, c);
				actorMap[r - d][c] = null;
			}
			else
				break;
		}
		for (int l = 1; l <= power; l++) { //left
			if (!(actorMap[r][c - l] instanceof UnbreakableBlock)) {
				Smoke s = new Smoke(r, c - l);
				actorMap[r][c - l] = null;
			}
			else
				break;
		}
		for (int right = 1; right <= power; right++) { //right
			if (!(actorMap[r][c + right] instanceof UnbreakableBlock)) {
				Smoke s = new Smoke(r, c + r);
				actorMap[r][c + right] = null;
			}
			else
				break;
		}
		for(Actor[] row: actorMap) {
			for (Actor a: row) {
				if (a instanceof Bomber) {
					
				}
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		for(Actor[] row: actorMap) {
			for (Actor a: row) {
				if (a instanceof Bomb) {
					if (((Bomb) a).boom()) {
						explode(((Bomb) a).getRow(), ((Bomb) a).getColumn(), ((Bomb) a).getPower());
					}
					if (a instanceof Smoke) {
						if (((Smoke) a).clear()) {
							actorMap[((Smoke) a).getRow()][((Bomb) a).getColumn()] = null;
						}
					}
				}
			}
		}
		
	}
}
