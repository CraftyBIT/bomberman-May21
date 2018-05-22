import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener
{
	private JButton startButton, howToPlayButton;
	public MainMenu()
	{
		super("Bomberman");
		startButton = new JButton("Start game");
		howToPlayButton = new JButton("How to Play");
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}
