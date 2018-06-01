import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.net.URL;

public class InGame extends JFrame implements ActionListener
{
    private JPanel inGame;
    private int[][] intMap;
    private Actor[][] map;
    private Image unbreakable, bomb, breakable, stoneTile;
    private Bomber p1, p2;
    
    public static final int pixels = 64;

    // empty = 0, player 1 = 1, player 2 = 2, unbreakable = 3, breakable = 4, bomb = 5
    
    public static void main(String[] args)
    {
        InGame game = new InGame();
        
    }
    
    public InGame()
    {
    	
    	super("Bomberman");
    	ImageLoader imageLoader = new ImageLoader();
    	Map mapReader = new Map("maps/map.txt");
    	map = mapReader.getMap();
    	
    	
        setSize(1280, 744);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        bomb = imageLoader.getBombImage().getImage();
        breakable = imageLoader.getBreakableImage().getImage();
        stoneTile = imageLoader.getStoneTileImage().getImage();
        unbreakable = imageLoader.getUnbreakableImage().getImage();
        
        inGame = new JPanel();
        inGame.setOpaque(true);
        inGame.setBackground(Color.WHITE);
        inGame.setLayout(null);
        
        setContentPane(inGame);
        setVisible(true);
        
        p1 = new Bomber(1, 1); //initialize players at locations
        p2 = new Bomber(5, 21);
        
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        int rLength = map[0].length;
        int cLength = map.length;
        
        int xPixel = 0;
        int yPixel = 24;
        
        for (int row = 0; row < rLength; row++)
        {
        	for (int col = 0; col < cLength; col++)
        	{
        		if (map[row][col] instanceof Block)
        		{
        			if (map[row][col].isBreakable() == false)
        			{
        				g.drawImage(unbreakable, xPixel, yPixel, null);
        			}
        			else
        			{
        				g.drawImage(breakable, xPixel, yPixel, null);
        			}
        			xPixel += 64;
        		}
        	}
        	xPixel = 0;
        	yPixel += 64;
        }
        
        
        // pair of nested loops going thru 'map'
        // 2 variables x, y
        // if map[i][j] is STONETILE, 
        g.drawImage(unbreakable, 0, 24, null);
        g.drawImage(unbreakable, 0, 88, null);
        g.drawImage(unbreakable, 64, 24, null);
        g.drawImage(stoneTile, 64, 88, null);
        g.drawImage(bomb, 64, 88, null);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
    }

	public void keyPressed(KeyEvent e) {  
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//System.out.println("Right key typed");
			if(p1.getLocation().getCol() != map[1].length && map[p1.getLocation().getRow()][p1.getLocation().getCol()] == 0){
				map[p1.getLocation().getRow()][p1.getLocation().getCol() + 1] = 1;
				if (p1.bombDown()){
					setBomb(p1.getLocation());
				}
				Location newLoc = new Location (p1.getLocation()c.getRow(), p1.getLocation().getCol() + 1);
				p1.moveTo(newLoc);
			}
			repaint();
			if (fishX > 570 )  fishX = 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			fishX -= 20;
			repaint();
			if (fishX < 0 )  fishX = 570;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//System.out.println("Right key typed");
			fishX += 20;
			repaint();
			if (fishX > 570 )  fishX = 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			fishX -= 20;
			repaint();
			if (fishX < 0 )  fishX = 570;
	}
	
	public void setBomb(Location loc){
		map[loc.getRow()][loc.getCol()] = 5;
		Bomb b = new Bomb(loc, 3);
	}
	
}
