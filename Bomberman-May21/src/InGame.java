import info.gridworld.actor.Actor;
import info.gridworld.actor.Block;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InGame<E> extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JPanel inGame;
	private JLabel[][] grid;
	private Actor[][] actors;
	
	public InGame()
	{
		super("Bomberman");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		inGame = new JPanel(new BorderLayout());
		actors = new Actor[11][15];
		
		for (int num = 0; num < 15; num++)
		{
			actors[0][num] = new Block(false);
		}
		
		grid = new JLabel[11][15];
		
		for (int row = 0; row < 11; row++)
		{
			for (int col = 0; col < 15; col++)
			{
				if (actors[row][col] instanceof Block)
				{
					grid[row][col] = new JLabel("|||");
				}
			}
		}
		inGame.add(grid, BorderLayout.CENTER);
		
		setContentPane(inGame);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}

