import info.gridworld.actor.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InGame extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JLabel unbreakable, player1, player2, blank;
	private Actor[][] actors;
	private Block noBreak;
	private Bomber bomber1, bomber2;
	
	public InGame()
	{
		super(new GridLayout(11, 15));
		setSize(1280, 720);
		setOpaque(true);
		setBackground(Color.WHITE);
        setLayout(null);
        
		unbreakable = new JLabel("||");
		player1 = new JLabel("1");
		player2 = new JLabel("2");
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
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame screen = new JFrame();
		InGame game = new InGame();
		screen.setContentPane(game);
	}
}

