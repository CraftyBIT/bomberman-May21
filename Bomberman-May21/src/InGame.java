import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InGame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private JPanel inGame;
	
	public InGame()
	{
		super("Bomberman");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
}

