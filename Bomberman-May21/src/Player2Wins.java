// Project Bomberman

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Player2Wins extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JTextArea winner;
	
	public Player2Wins()
	{
		super("Bomberman");
		setSize(400, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		
		backButton = new JButton("Again?");
		backButton.addActionListener(this);
		winner = new JTextArea ("Player 2 Wins Lol");
		winner.setFont(new Font("Arial Black", Font.BOLD, 16));
		winner.setEditable(false);
		
		setLayout(new BorderLayout());
		add(backButton, BorderLayout.SOUTH);
		add(winner, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == backButton)
		{
			InGame game = new InGame();
			dispose();
		}
	}
}