import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader
{
	private ImageIcon bomb, breakable, stoneTile, unbreakable;
	
	public ImageLoader()
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		
		try
		{
			bomb = new ImageIcon(cldr.getResource("images/bomb.png"));
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
