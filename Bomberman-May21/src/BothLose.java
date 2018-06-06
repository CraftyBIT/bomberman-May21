// Project Bomberman

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class BothLose extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JTextArea winner;
	
	public BothLose()
	{
		super("Bomberman");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		
		backButton = new JButton("Again?");
		backButton.addActionListener(this);
		winner = new JTextArea ("You both lose Lol");
		winner.setEditable(false);
		
		this.setLayout(new BorderLayout());
		this.add(backButton, BorderLayout.SOUTH);
		this.add(winner, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == backButton)
		{
			this.dispose();
			InGame game = new InGame();
		}
	}
}