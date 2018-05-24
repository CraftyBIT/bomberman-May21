import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Instructions extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JTextArea instructions;
	
	public Instructions()
	{
		super("Bomberbitch");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		instructions = new JTextArea ("Bomb the shit out of each other like the bitches you are!");

		
		this.setLayout(new BorderLayout());
		this.add(backButton, BorderLayout.SOUTH);
		this.add(instructions, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == backButton){
			MainMenu meme = new MainMenu();
			this.dispose();
		}
		
	}
}
