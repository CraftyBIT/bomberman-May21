import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InGame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JPanel inGame;
	private JLabel[][] grid;
	
	public InGame()
	{
		super("Bomberman");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		inGame = new JPanel(new BorderLayout());
		grid = new JLabel[11][15];
		for (int row = 0; row < 11; row++)
		{
			for (int col = 0; col < 15; col++)
			{
				grid[row][col] = new JLabel();
				grid[row][col].setBorder(new LineBorder(Color.BLACK));
				grid[row][col].setOpaque(true);
				inGame.add(grid[row][col]);
			}
		}
		grid[0][0].setBackground(Color.WHITE);
		
		setContentPane(inGame);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}

