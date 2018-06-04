// Project Bomberman

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class InGame extends JFrame implements ActionListener
{
	private JLayeredPane layered;
	private JPanel bombers, iGame;
	private JButton startButton;
	private Actor[][] map;
	private Image bomb, bomber, bomber2, breakable, dbImage, smoke, stoneTile, unbreakable;
	private Graphics dbGraphics;
	private int xPixel = 2, yPixel = 30;
	private boolean gameOver = true;
	private Map mapReader;
	
	public Action actionTime;
	
	public static final int rLength = 11, cLength = 15, resolution = 64;
	
	public static void main(String[] args)
	{
		InGame inGame = new InGame();
	}
	
	public InGame()
	{
		super("Bomberman");
		ImageLoader imageLoader = new ImageLoader();
		mapReader = new Map("map.txt");
		map = mapReader.getMap();
		
		setSize(966, 792);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		bomb = imageLoader.getBombImage().getImage();
		bomber = imageLoader.getBomberImage().getImage();
		bomber2 = imageLoader.getBomberImage2().getImage();
		breakable = imageLoader.getBreakableImage().getImage();
		smoke = imageLoader.getExplosionImage().getImage();
		stoneTile = imageLoader.getStoneTileImage().getImage();
		unbreakable = imageLoader.getUnbreakableImage().getImage();
		
		addKeyListener(new KeyHandler());
		
		layered = new JLayeredPane();
		
		iGame = new JPanel();
		iGame.setOpaque(true);
		iGame.setBackground(Color.WHITE);
		iGame.setLayout(null);
		iGame.setSize(966, 792);
		
		startButton = new JButton("Start");
		startButton.setSize(966, 50);
		startButton.setLocation(0, 704);
		startButton.addActionListener(this);
		
		iGame.add(startButton);
		layered.add(iGame);
		
		bombers = new JPanel();
		bombers.setOpaque(false);
		bombers.setBackground(Color.WHITE);
		bombers.setLayout(null);
		bombers.setSize(966, 792);
		layered.add(bombers);
		
		setContentPane(layered);
		setVisible(true);
		
		Timer timer = new javax.swing.Timer(50, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		paintComponent(dbGraphics);
		g.drawImage(dbImage, 0, 0, iGame);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paint(g);
		boolean isPlayer1 = true;
		
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
        			if (map[row][col] instanceof Bomber && isPlayer1)
        			{
        				g.drawImage(bomber, xPixel, yPixel, bombers);
        				isPlayer1 = false;
        			}
        			else if (map[row][col] instanceof Bomber && !isPlayer1)
        			{
        				g.drawImage(bomber2, xPixel, yPixel, bombers);
        			}
        			else if (map[row][col] instanceof Bomb) {
            			g.drawImage(bomb, xPixel, yPixel, iGame);
            		}
        			else if (map[row][col] instanceof Smoke)
        			{
        				g.drawImage(smoke, xPixel, yPixel, bombers);
        			}
        		}
        		xPixel += 64;
        	}
        	xPixel = 2;
        	yPixel += 64;
        }
		xPixel = 2;
		yPixel = 30;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == startButton && gameOver)
		{
			requestFocusInWindow();
			gameOver = false;
		}
		repaint();
	}
	
	private class KeyHandler implements KeyListener
	{
		public void keyPressed(KeyEvent event)
		{
			System.out.println(event.getKeyCode());
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
			else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
				mapReader.dropBomb('1');
				map = mapReader.getMap();
				repaint();
			}
			else if (event.getKeyCode() == KeyEvent.VK_CONTROL) {
				mapReader.dropBomb('2');
				map = mapReader.getMap();
				repaint();
				System.out.println("poop");
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
