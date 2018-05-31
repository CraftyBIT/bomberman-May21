import java.net.URL;

import javax.swing.ImageIcon;


public class ImageLoader {
	private ImageIcon unbreakable, stoneTile, unbreakable2, bomb;
	
	public ImageLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		
		try {
			URL unbreakableURL = cldr.getResource("images/unbreakable.png");
			unbreakable = new ImageIcon(unbreakableURL);
			
			URL stoneTileURL = cldr.getResource("images/stonetile.png");
			stoneTile = new ImageIcon(stoneTileURL);
			
			URL unbreakable2URL = cldr.getResource("images/unbreakable_block2.png");
			unbreakable2 = new ImageIcon(unbreakable2URL);
			
			URL bombURL = cldr.getResource("images/bomb.png");
			bomb = new ImageIcon(bombURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ImageIcon getUnbreakableImage() {
		return unbreakable;
	}
	
	public ImageIcon getStoneTileImage() {
		return stoneTile;
	}
	
	public ImageIcon getUnbreakable2Image()
	{
		return unbreakable2;
	}
	
	public ImageIcon getBombImage()
	{
		return bomb;
	}
}
