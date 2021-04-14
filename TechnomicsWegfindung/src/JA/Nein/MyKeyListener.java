package JA.Nein;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
	  Wand wand;
	  
	  public MyKeyListener(Wand w) {
	    this.wand = w;
	  }
	  
	  public void keyTyped(KeyEvent e) {}
	  
	  public void keyPressed(KeyEvent e) {
	    if (27 == e.getKeyCode())
	      System.exit(0); 
	    if (32 == e.getKeyCode()) {
	      this.wand.suche = true;
	      this.wand.reset();
	      this.wand.repaint();
	    } 
	  }
	  
	  public void keyReleased(KeyEvent e) {}
	}
