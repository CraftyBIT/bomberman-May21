// Project Bomberman

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InGame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	public static final int rLength = 11, cLength = 15, resolution = 64;
	
	private JLayeredPane layered;
	private JPanel bombers, iGame;
	private Actor[][] map;
	private Image bomb, bomber, bomber2, bombPowerUp, breakable, dbImage, explosion, powerPowerUp, stoneTile, unbreakable;
	private Graphics dbGraphics;
	private int xPixel = 0, yPixel = 25;
	private int winner, checks; // 1 = Player 1 Wins, 2 = Player 2 Wins, 3 = Tie/Both Lose, 0 = Invalid
	private boolean gameOver = true, isAlive = false, isAlive2 = false;
	private Map mapReader;
	
	public Action actionTime;
	
	public InGame()
	{
		super("Bomberman");
		ImageLoader imageLoader = new ImageLoader();
		mapReader = new Map("map.txt");
		map = mapReader.getMap();
		
		setSize(960, 732);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		bomb = imageLoader.getBombImage().getImage();
		bomber = imageLoader.getBomberImage().getImage();
		bomber2 = imageLoader.getBomberImage2().getImage();
		bombPowerUp = imageLoader.getBombPowerUpImage().getImage();
		explosion = imageLoader.getExplosionImage().getImage();
		breakable = imageLoader.getBreakableImage().getImage();
		powerPowerUp = imageLoader.getExplosionPowerUpImage().getImage();
		stoneTile = imageLoader.getStoneTileImage().getImage();
		unbreakable = imageLoader.getUnbreakableImage().getImage();
		
		addKeyListener(new KeyHandler());
		
		layered = new JLayeredPane();
		
		iGame = new JPanel();
		iGame.setOpaque(true);
		iGame.setBackground(Color.WHITE);
		iGame.setLayout(null);
		iGame.setSize(960, 732);
		
		layered.add(iGame);
		
		bombers = new JPanel();
		bombers.setOpaque(false);
		bombers.setBackground(Color.WHITE);
		bombers.setLayout(null);
		bombers.setSize(960, 732);
		layered.add(bombers);
		
		setContentPane(layered);
		setVisible(true);
		
		requestFocusInWindow();
		gameOver = false;
		
		Timer timer = new javax.swing.Timer(10, this);
		timer.start();
		
		checks = 0;
	}
	
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, iGame);
	}
	
	@SuppressWarnings("unused")
	public void paintComponent(Graphics g)
	{
		super.paint(g);
		winner = 0;
		isAlive = false;
		isAlive2 = false;
		
		for (int row = 0; row < rLength; row++)
        {
        	for (int col = 0; col < cLength; col++)
        	{
        		if (map[row][col] instanceof UnbreakableBlock)
        		{
        			g.drawImage(unbreakable, xPixel, yPixel, iGame);
        		}
        		else if (map[row][col] instanceof BreakableBlock)
        		{
        			g.drawImage(breakable, xPixel, yPixel, iGame);
        		}
        		else
        		{
        			g.drawImage(stoneTile, xPixel, yPixel, null);
        			if (map[row][col] instanceof Bomber && map[row][col].getId() == 1)
        			{
        				g.drawImage(bomber, xPixel, yPixel, bombers);
        				isAlive = true;
        			}
        			else if (map[row][col] instanceof Bomber && map[row][col].getId() == 2)
        			{
        				g.drawImage(bomber2, xPixel, yPixel, bombers);
        				isAlive2 = true;
        			}
        			else if (map[row][col] instanceof Bomb)
        			{
            			g.drawImage(bomb, xPixel, yPixel, iGame);
            		}
        			else if (map[row][col] instanceof PowerUp)
        			{
        				if (map[row][col].getId() == 0)
        				{
        					g.drawImage(bombPowerUp, xPixel, yPixel, iGame);
        				}
        				else
        				{
        					g.drawImage(powerPowerUp, xPixel, yPixel, iGame);
        				}
        			}
        			else if (map[row][col] instanceof Explosion)
        			{
        				g.drawImage(explosion, xPixel, yPixel, iGame);
        			}
        		}
        		xPixel += 64;
        	}
        	xPixel = 0;
        	yPixel += 64;
        }
		xPixel = 0;
		yPixel = 25;
		
		if (!isAlive && !isAlive2)
		{
			gameOver = true;
			winner = 3;
		}
		else if (!isAlive2)
		{
			gameOver = true;
			winner = 1;
		}
		else if (!isAlive)
		{
			gameOver = true;
			winner = 2;
		}
		
		if (winner != 0){
			checks++;
			if (checks == 100)
			{
				switch(winner) 
				{
			    	case 1:
			    		Player1Wins p1Wins = new Player1Wins();
			    		dispose();
			    		break;
					
			    	case 2:
			    		Player2Wins p2Wins = new Player2Wins();
			    		dispose();
			    		break;
			        
			    	case 3:
			    		BothLose losers = new BothLose();
			    		dispose();
			    		break;
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		repaint();
	}
	
	private class KeyHandler implements KeyListener
	{
		public void keyPressed(KeyEvent event)
		{
			if (!gameOver)
			{
				if (event.getKeyCode() == KeyEvent.VK_W)
				{
					mapReader.player1Move('W');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_S)
				{
					mapReader.player1Move('S');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_A)
				{
					mapReader.player1Move('A');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_D)
				{
					mapReader.player1Move('D');
					map = mapReader.getMap();
					repaint();
				}
			
				if (event.getKeyCode() == KeyEvent.VK_UP)
				{
					mapReader.player2Move('W');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_DOWN)
				{
					mapReader.player2Move('S');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_LEFT)
				{
					mapReader.player2Move('A');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					mapReader.player2Move('D');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_SPACE)
				{
					mapReader.dropBomb('1');
					map = mapReader.getMap();
					repaint();
				}
				else if (event.getKeyCode() == KeyEvent.VK_CONTROL)
				{
					mapReader.dropBomb('2');
					map = mapReader.getMap();
					repaint();
				}
			}
		}
		
		public void keyReleased(KeyEvent event)
		{
			
		}
		
		public void keyTyped(KeyEvent event)
		{
			
		}
	}
}