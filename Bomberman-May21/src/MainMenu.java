import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton startButton, howToPlayButton, quitButton;
	private static JFrame screen;
	private static MainMenu menu;
	private static InGame game;
	
	public MainMenu()
	{
		
		startButton = new JButton("Start!");
		startButton.addActionListener(this);
		howToPlayButton = new JButton("How to Play");
		howToPlayButton.addActionListener(this);
		quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		this.add(startButton,0);
		this.add(howToPlayButton,1);
		
		
		
		
		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(1, 1, 700, 600);
		g.setColor(Color.white);
		Font title = new Font("tittle", 1, 30);
		g.setFont(title);
		g.drawString("BOMBERMAN", 260, 100);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == startButton){
			screen.remove(menu);
			screen.add(game);
			
		}
		if (event.getSource() == howToPlayButton){
			
			
			//open instructions
		}
		if (event.getSource() == quitButton){
			
		}
		
	}
	public static void main(String[] args){
		screen = new JFrame();
		menu = new MainMenu();
		game = new InGame();
		screen.setBounds(10, 10, 700, 600);
		screen.setTitle("Bomberman");
		screen.setResizable(false);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.add(menu);
		
	}
	
	
	

		
	
}
