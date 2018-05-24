import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Instructions extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JPanel instructions;
	
	public Instructions()
	{
		super("Bomberbitch");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		instructions = new JPanel ("Howtoplaythisbitch");
		
		this.setLayout(new BorderLayout());
		this.add(backButton, BorderLayout.SOUTH);	
		
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
