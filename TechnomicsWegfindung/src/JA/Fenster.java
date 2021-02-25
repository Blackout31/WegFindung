package JA;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fenster extends JFrame{
	  static int color = 0;
	  
	  private final int HEIGHT = 600;
	  
	  private final int WIDTH = 600;
	  
	  public Fenster() {
	    setTitle("A-Stern youtube.de/tomzalat");
	    setSize(600, 600);
	    setDefaultCloseOperation(3);
	    setVisible(true);
	    int rahmenbreiteLR = (getInsets()).left + (getInsets()).right;
	    int rahmenbreiteOU = (getInsets()).top + (getInsets()).bottom;
	    setVisible(false);
	    setSize(600 + rahmenbreiteLR, 600 + rahmenbreiteOU + 50);
	    setLocationRelativeTo((Component)null);
	    JPanel panel = new JPanel(null);
	    panel.add(new Wand(600, 600));
	    JTextArea anleitung = new JTextArea("Klicke mit der Maus um Steine zu entfernen oder zu plazieren.\nMit der Leertaste Startest du das Pathfinding.\nMehr zur Spieleprogrammierung auf youtube.de/tomzalat", 15, 2);
	    anleitung.setBounds(0, 600, 600, 50);
	    anleitung.setEditable(false);
	    panel.add(anleitung);
	    add(panel);
	    setVisible(true);
	  }
	}