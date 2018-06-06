import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JLabel background;
	private JPanel menuPanel;
	private ImageIcon mainMenu;
	
	public MainMenu()
	{
		super("Bomberman");
		setSize(960, 732);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		ImageLoader imageLoader = new ImageLoader();
		mainMenu = imageLoader.getMainMenuImage();

		
		menuPanel = new JPanel(new GridLayout(1, 1));
		menuPanel.setSize(960, 732);
		menuPanel.setOpaque(true);
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setLayout(null);
		
		background = new JLabel(mainMenu);
		background.setBounds(0, 0, 960, 732);
		
		startButton = new JButton("Start!");
		startButton.setSize(350, 50);
    	startButton.setLocation(283, 50);
		startButton.setBounds(283, 50, 350, 50);
		startButton.addActionListener(this);
		
		howToPlayButton = new JButton("How to Play");
		howToPlayButton.setSize(350, 50);
		howToPlayButton.setLocation(283, 125);
		howToPlayButton.addActionListener(this);
		
		quitButton = new JButton("Quit");
		quitButton.setSize(350, 50);
		quitButton.setLocation(283, 200);
		quitButton.addActionListener(this);
		
		menuPanel.add(startButton);
		menuPanel.add(howToPlayButton);
		menuPanel.add(quitButton);
		menuPanel.add(background);
		setContentPane(menuPanel);
		
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == startButton)
		{
			setVisible(false);
			InGame game = new InGame();
		}
		if (event.getSource() == howToPlayButton)
		{
			Instructions instructions = new Instructions();
		}
		if (event.getSource() == quitButton)
		{
			dispose();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		MainMenu menu = new MainMenu();
	}
}