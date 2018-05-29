import info.gridworld.actor.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class InGame extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private Image ui;
	
	public InGame()
	{
		super(new GridLayout(11, 15));
		setSize(1280, 720);
		setOpaque(true);
		setBackground(Color.WHITE);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ui = toolkit.getImage("ingame.png");
		
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(ui, 0, 0, this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame screen = new JFrame("Bomberman");
		screen.setSize(1280, 720);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLocationByPlatform(true);
		
		JPanel game = new InGame();
		screen.add(game);
		screen.setVisible(true);
	}
}

