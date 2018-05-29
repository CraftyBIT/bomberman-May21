import info.gridworld.actor.Actor;
import info.gridworld.actor.Block;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InGame<E> extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JLabel unbreakable, player1, player2, blank;
	private Actor[][] actors;
	
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
		addToGrid();
		
		setVisible(true);
	}
	
	public void addToGrid()
	{
		for (int num = 0; num < 16; num++)
		{
			add(unbreakable);
		}
		
		add(player1);
		
		for (int num = 0; num < 13; num++)
		{
			add(blank);
		}
		
		add(unbreakable);
		
		
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}

