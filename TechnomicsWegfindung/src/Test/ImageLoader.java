package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageLoader {
	
	BufferedImage image;
	
	public ImageLoader() {
	try {
		image = ImageIO.read(getClass() .getResourceAsStream("/Karte.jpg"));
	} catch (IOException e) {		
		e.printStackTrace();
	}
	
  }

	public void paint(Graphics g) {
		g.drawImage(image, 100, 100, null);
	}
}
