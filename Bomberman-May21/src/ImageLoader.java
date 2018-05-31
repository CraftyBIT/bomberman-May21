import java.net.URL;

import javax.swing.ImageIcon;


public class ImageLoader {
	private ImageIcon unbreakable, stoneTile;
	
	public ImageLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		
		try {
			URL unbreakableURL = cldr.getResource("images/unbreakable.png");
			unbreakable = new ImageIcon(unbreakableURL);
			
			URL stoneTileURL = cldr.getResource("images/stonetile.png");
			stoneTile = new ImageIcon(stoneTileURL);
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
}
