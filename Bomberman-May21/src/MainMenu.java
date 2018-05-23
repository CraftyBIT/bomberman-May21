import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	
	public MainMenu()
	{
		super("Bomberbitch");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		startButton = new JButton("Start!");
		startButton.addActionListener(e -> this.dispose());
		howToPlayButton = new JButton("How to Play");
		howToPlayButton.addActionListener(e -> this.dispose());
		quitButton = new JButton("Quit");
		quitButton.addActionListener(e -> this.dispose());
		
		this.setLayout(new BorderLayout());
		this.add(startButton, BorderLayout.NORTH);
		this.add(howToPlayButton, BorderLayout.SOUTH);
		this.add(quitButton, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == startButton){
			InGame game = new InGame();
			System.exit(0);
		}
		if (event.getSource() == howToPlayButton){
			Instructions instruc = new Instructions();
			//open instructions
		}
		if (event.getSource() == quitButton){
			this.dispose();
		}
		
	}
	public static void main(String[] args){
		MainMenu meme = new MainMenu();
	}
}
