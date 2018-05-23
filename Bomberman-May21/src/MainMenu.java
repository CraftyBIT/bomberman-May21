import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener
{
	private JButton startButton, howToPlayButton, quitButton;
	
	public MainMenu()
	{
		super("Bomberman");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		startButton = new JButton("Start!");
		howToPlayButton = new JButton("How to Play");
		quitButton = new JButton("Quit");
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}
