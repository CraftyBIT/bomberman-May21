import info.gridworld.actor.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.io.*;

import java.net.URL;

public class InGame extends JFrame implements ActionListener
{
    private JPanel inGame;
    private int[][] map;
    //private Image ui;
    private Image unbreakable;
    
    public static void main(String[] args)
    {
        InGame game = new InGame();
        
    }
    
    public InGame()
    {
    	
    	super("Bomberman");
    	ImageLoader imageLoader = new ImageLoader();
    	TileMap tileMap = new TileMap("maps/map.txt");
    	map = tileMap.getMap();
        setSize(1280, 744);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        //ui = toolkit.getImage("ingame.png");
        
        unbreakable = imageLoader.getUnbreakableImage().getImage();
        
        inGame = new JPanel();
        inGame.setOpaque(true);
        inGame.setBackground(Color.WHITE);
        inGame.setLayout(null);
        
        setContentPane(inGame);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(unbreakable, 0, 24, null);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
    }
}
