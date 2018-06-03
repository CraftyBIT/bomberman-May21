// Project Bomberman

import javax.swing.*;

public class ImageLoader
{
	private ImageIcon bomb, bomber, bomber2, breakable, stoneTile, unbreakable;
	
	public ImageLoader()
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		
		try
		{
			bomb = new ImageIcon(cldr.getResource("images/bomb.png"));
			bomber = new ImageIcon(cldr.getResource("images/bomber.png"));
			bomber2 = new ImageIcon(cldr.getResource("images/bomber2.png"));
			breakable = new ImageIcon(cldr.getResource("images/breakable.png"));
			stoneTile = new ImageIcon(cldr.getResource("images/stonetile.png"));
			unbreakable = new ImageIcon(cldr.getResource("images/unbreakable.png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ImageIcon getBombImage()
	{
		return bomb;
	}
	
	public ImageIcon getBomberImage()
	{
		return bomber;
	}
	
	public ImageIcon getBomberImage2()
	{
		return bomber2;
	}
	
	public ImageIcon getBreakableImage()
	{
		return breakable;
	}
	
	public ImageIcon getStoneTileImage()
	{
		return stoneTile;
	}
	
	public ImageIcon getUnbreakableImage()
	{
		return unbreakable;
	}
}
