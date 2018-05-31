import java.net.URL;

import javax.swing.ImageIcon;


public class ImageLoader 
{
	private ImageIcon breakable, unbreakable, stoneTile, bomb;
	
	public ImageLoader() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		
		try 
		{
			unbreakable = new ImageIcon(cldr.getResource("images/unbreakable.png"));
			stoneTile = new ImageIcon(cldr.getResource("images/stonetile.png"));
			bomb = new ImageIcon(cldr.getResource("images/bomb.png"));
			breakable = new ImageIcon(cldr.getResource("images/breakable.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ImageIcon getUnbreakableImage()
	{
		return unbreakable;
	}
	
	public ImageIcon getStoneTileImage()
	{
		return stoneTile;
	}
	
	public ImageIcon getBombImage()
	{
		return bomb;
	}
	
	public ImageIcon getBreakableImage()
	{
		return breakable;
	}
}
