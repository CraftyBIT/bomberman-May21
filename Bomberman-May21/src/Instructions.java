import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Instructions extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JTextArea instructions;
	
	public Instructions()
	{
		super("Bomberman");
		setSize(560,350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		instructions = new JTextArea ("WASD + Space for P1 \n\n\n\n Arrow Keys + R-Ctrl for P2 \n\n\n\n BOMB EACH OTHER!!! gogo");
		instructions.setFont(new Font("Arial Black", Font.BOLD, 16));
		instructions.setEditable(false);
		
		this.setLayout(new BorderLayout());
		this.add(backButton, BorderLayout.SOUTH);
		this.add(instructions, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == backButton)
		{
			this.dispose();
		}
		
	}
	
}