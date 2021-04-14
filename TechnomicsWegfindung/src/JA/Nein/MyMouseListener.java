package JA.Nein;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
	 Wand wand;
	  
	  MyMouseListener(Wand w) {
	    this.wand = w;
	  }
	  
	  public void mouseClicked(MouseEvent e) {
	    int x = e.getX() / this.wand.ratio;
	    int y = e.getY() / this.wand.ratio;
	    this.wand.changeFieldAtPos(x, y);
	  }
	  
	  public void mousePressed(MouseEvent e) {}
	  
	  public void mouseReleased(MouseEvent e) {}
	  
	  public void mouseEntered(MouseEvent e) {}
	  
	  public void mouseExited(MouseEvent e) {}
	  
	  public void setWand(Wand w) {
	    this.wand = w;
	  }
	}