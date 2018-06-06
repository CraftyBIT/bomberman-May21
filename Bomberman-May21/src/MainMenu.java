import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JPanel menuPanel;
	private Image mainMenu;
	private static MainMenu menu;
	private static InGame game;
	
	public MainMenu()
	{
		super("Bomberman");
		setSize(960, 732);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		ImageLoader imageLoader = new ImageLoader();
		mainMenu = imageLoader.getMainMenuImage().getImage();

		/*
		menuPanel = new JPanel(new GridLayout(1, 1));
		menuPanel.setSize(960, 732);
		menuPanel.setOpaque(true);
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setLayout(null);
		*/
		JButton backgndButton = new JButton(new ImageIcon(mainMenu));
		add(backgndButton);
		
		startButton = new JButton("Start!");
//		startButton.setSize(350, 50);
//		startButton.setLocation(283, 50);
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
		
		/*
		menuPanel.add(startButton);
		menuPanel.add(howToPlayButton);
		menuPanel.add(quitButton);
		setContentPane(menuPanel);
		*/
		
		backgndButton.setLayout(new GridLayout(3, 1));
		backgndButton.add(startButton);
		
		backgndButton.add(howToPlayButton);
		backgndButton.add(quitButton);
		
		
		setVisible(true);
	}
	
	/*
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(mainMenu, 0, 0, menuPanel);
	}
	*/
	
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
