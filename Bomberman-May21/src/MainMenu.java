import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JPanel menuPanel;
	private JLabel name;
	private static MainMenu menu;
	private static InGame game;
	
	public MainMenu()
	{
		super("Bomberman");
		setSize(960, 732);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		menuPanel = new JPanel(new GridLayout(1, 1));
		menuPanel.setSize(960, 732);
		menuPanel.setOpaque(true);
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setLayout(null);
		
		name = new JLabel("Bomberman");
		name.setFont(new Font("Serif", Font.PLAIN, 72));
		name.setLocation(100, 0);
		
		startButton = new JButton("Start!");
		startButton.setSize(350, 50);
		startButton.setLocation(283, 50);
		startButton.addActionListener(this);
		
		howToPlayButton = new JButton("How to Play");
		howToPlayButton.setSize(350, 50);
		howToPlayButton.setLocation(283, 125);
		howToPlayButton.addActionListener(this);
		
		quitButton = new JButton("Quit");
		quitButton.setSize(350, 50);
		quitButton.setLocation(283, 200);
		quitButton.addActionListener(this);
		
		menuPanel.add(name);
		menuPanel.add(startButton);
		menuPanel.add(howToPlayButton);
		menuPanel.add(quitButton);
		setContentPane(menuPanel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == startButton)
		{
			menu.setVisible(false);
			InGame game = new InGame();
		}
		if (event.getSource() == howToPlayButton)
		{
			Instructions instructions = new Instructions();
		}
		if (event.getSource() == quitButton)
		{
			menu.dispose();
		}
	}
	
	public static void main(String[] args)
	{
		menu = new MainMenu();
	}
}
