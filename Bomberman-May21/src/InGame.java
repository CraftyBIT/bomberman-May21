import info.gridworld.actor.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class InGame extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JLabel unbreakable, player1, player2, blank;
	private Actor[][] actors;
	private Block noBreak;
	private Bomber bomber1, bomber2;
	private Image ui;
	
	public InGame()
	{
		super(new GridLayout(11, 15));
		setSize(1280, 720);
		setOpaque(true);
		setBackground(Color.WHITE);
        setLayout(null);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ui = toolkit.getImage("ingame.png");
        
		unbreakable = new JLabel("||");
		unbreakable.setForeground(Color.BLACK);
		player1 = new JLabel("1");
		player1.setForeground(Color.BLACK);
		player2 = new JLabel("2");
		player2.setForeground(Color.BLACK);
		blank = new JLabel(" ");
		
		actors = new Actor[11][15];
		noBreak = new Block(false);
		bomber1 = new Bomber();
		bomber2 = new Bomber();
		
		for (int col = 0; col < 15; col++)
		{
			actors[0][col] = noBreak;
		}
		
		for (int col = 0; col < 15; col++)
		{
			actors[10][col] = noBreak;
		}
		
		for (int row = 1; row < 11; row++)
		{
			actors[row][0] = noBreak;
		}
		
		for (int row = 1; row < 11; row++)
		{
			actors[row][14] = noBreak;
		}
		
		actors[1][1] = bomber1;
		actors[9][13] = bomber2;
		
		addToGrid();
		
		setVisible(true);
	}
	
	public void addToGrid()
	{
		boolean isP1 = true;
		for (Actor[] a : actors)
		{
			for (Actor actor : a)
			{
				if (actor instanceof Block)
				{
					add(unbreakable);
				}
				else if (actor instanceof Bomber && isP1)
				{
					add(player1);
					isP1 = false;
				}
				else if (actor instanceof Bomber && !isP1)
				{
					add(player2);
				}
				else
				{
					add(blank);
				}
			}
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(ui, 0, 0, this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame screen = new JFrame("Bomberman");
		screen.setSize(1280, 720);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLocationByPlatform(true);
		
		JPanel game = new InGame();
		screen.setContentPane(game);
		screen.setVisible(true);
	}
}

