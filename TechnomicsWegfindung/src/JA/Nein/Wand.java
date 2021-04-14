package JA.Nein;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Wand extends JComponent {
	public final int WIDTH;
	  
	  private final int HEIGHT;
	  
	  private BufferedImage stein;
	  
	  private BufferedImage boden;
	  
	  private BufferedImage player;
	  
	  private int playerX = 2;
	  
	  private int playerY = 2;
	  
	  private BufferedImage ziel;
	  
	  private int zielX = 25;
	  
	  private int zielY = 25;
	  
	  public int x;
	  
	  public int y;
	  
	  private boolean[][] field;
	  
	  private final int ZELLEN = 30;
	  
	  public final int ratio;
	  
	  LinkedList<Wegpunkt> openList;
	  
	  LinkedList<Wegpunkt> closedList;
	  
	  private Wegpunkt finish;
	  
	  public boolean suche = false;
	  
	  public Wand(int width, int height) {
	    this.openList = new LinkedList<Wegpunkt>();
	    this.openList.add(new Wegpunkt(this.playerX, this.playerY, 1, heuristik(this.playerX, this.playerY), null));
	    this.closedList = new LinkedList<Wegpunkt>();
	    this.WIDTH = width;
	    this.HEIGHT = height;
	    getClass();
	    this.ratio = this.WIDTH / 30;
	    try {
	      this.boden = ImageIO.read(new File("boden.png"));
	      this.stein = ImageIO.read(new File("stein.png"));
	      this.player = ImageIO.read(new File("player.png"));
	      this.ziel = ImageIO.read(new File("ziel.png"));
	    } catch (IOException ex) {
	      Logger.getLogger(Wand.class.getName()).log(Level.SEVERE, (String)null, ex);
	    } 
	    this.field = new boolean[30][30];
	    for (int i = 0; i < 30; i++) {
	      for (int j = 0; j < 30; j++) {
	        if (Math.random() < 0.699999988079071D) {
	          this.field[i][j] = true;
	        } else {
	          this.field[i][j] = false;
	        } 
	      } 
	    } 
	    this.field[this.zielX][this.zielY] = true;
	    this.field[this.playerX][this.playerY] = true;
	    addMouseListener(new MyMouseListener(this));
	    setFocusable(true);
	    addKeyListener(new MyKeyListener(this));
	    setSize(width, height);
	  }
	  
	  public void paint(Graphics g) {
	    super.paint(g);
	    Wegpunkt wegpunkt = null;
	    if (this.finish != null) {
	      wegpunkt = this.finish;
	      this.suche = false;
	    } else if (!this.openList.isEmpty() && this.suche == true) {
	      wegpunkt = aStern();
	    } 
	    int i;
	    for (i = 0; i < 30; i++) {
	      for (int j = 0; j < 30; j++) {
	        if (this.field[i][j]) {
	          g.drawImage(this.boden, i * this.ratio, j * this.ratio, this.ratio, this.ratio, null);
	        } else {
	          g.drawImage(this.stein, i * this.ratio, j * this.ratio, this.ratio, this.ratio, null);
	        } 
	      } 
	    } 
	    g.setColor(new Color(0, 255, 0, 125));
	    for (i = 0; i < this.openList.size(); i++)
	      g.fillRect(((Wegpunkt)this.openList.get(i)).x * this.ratio, ((Wegpunkt)this.openList.get(i)).y * this.ratio, this.ratio, this.ratio); 
	    g.setColor(new Color(255, 0, 0, 125));
	    for (i = 0; i < this.closedList.size(); i++)
	      g.fillRect(((Wegpunkt)this.closedList.get(i)).x * this.ratio, ((Wegpunkt)this.closedList.get(i)).y * this.ratio, this.ratio, this.ratio); 
	    if (wegpunkt != null) {
	      g.setColor(new Color(75, 255, 255, 125));
	      wegpunkt.draw(g, this.ratio);
	      g.setColor(Color.yellow);
	      g.fillRect(wegpunkt.x * this.ratio, wegpunkt.y * this.ratio, this.ratio, this.ratio);
	    } 
	    g.drawImage(this.player, this.playerX * this.ratio, this.playerY * this.ratio, this.ratio, this.ratio, null);
	    g.drawImage(this.ziel, this.zielX * this.ratio, this.zielY * this.ratio, this.ratio, this.ratio, null);
	    if (this.suche)
	      repaint(); 
	  }
	  
	  public void changeFieldAtPos(int x, int y) {
	    this.field[x][y] = !this.field[x][y];
	    repaint();
	  }
	  
	  private Wegpunkt aStern() {
	    Wegpunkt bestWegpunkt = this.openList.get(getFirstBestListEntry(this.openList));
	    this.closedList.add(this.openList.remove(getFirstBestListEntry(this.openList)));
	    if (bestWegpunkt.x == this.zielX && bestWegpunkt.y == this.zielY) {
	      bestWegpunkt.print();
	      this.finish = bestWegpunkt;
	      return bestWegpunkt;
	    } 
	    openListAddHelper(bestWegpunkt.x, bestWegpunkt.y - 1, this.openList, this.closedList, bestWegpunkt);
	    openListAddHelper(bestWegpunkt.x + 1, bestWegpunkt.y, this.openList, this.closedList, bestWegpunkt);
	    openListAddHelper(bestWegpunkt.x, bestWegpunkt.y + 1, this.openList, this.closedList, bestWegpunkt);
	    openListAddHelper(bestWegpunkt.x - 1, bestWegpunkt.y, this.openList, this.closedList, bestWegpunkt);
	    return bestWegpunkt;
	  }
	  
	  private void openListAddHelper(int x, int y, LinkedList<Wegpunkt> openList, LinkedList<Wegpunkt> closedList, Wegpunkt vorher) {
	    getClass();
	    getClass();
	    if (x >= 0 && y >= 0 && x < 30 && y < 30)
	      if (!isPointInList(x, y, closedList) && this.field[x][y] == true && !isPointInList(x, y, openList))
	        openList.add(new Wegpunkt(x, y, 1, heuristik(x, y), vorher));  
	  }
	  
	  private int heuristik(int x, int y) {
	    int dx = x - this.zielX;
	    if (dx < 0)
	      dx = -dx; 
	    int dy = y - this.zielY;
	    if (dy < 0)
	      dy = -dy; 
	    return dx + dy;
	  }
	  
	  private int getFirstBestListEntry(LinkedList<Wegpunkt> list) {
	    int best = ((Wegpunkt)list.get(0)).getGesamtkosten();
	    int i;
	    for (i = 1; i < list.size(); i++) {
	      if (((Wegpunkt)list.get(i)).getGesamtkosten() < best)
	        best = ((Wegpunkt)list.get(i)).getGesamtkosten(); 
	    } 
	    for (i = 0; i < list.size(); i++) {
	      if (((Wegpunkt)list.get(i)).getGesamtkosten() == best)
	        return i; 
	    } 
	    System.out.println("da ist etwas schiefgelaufen in 'getFirstBestListEntry'");
	    return 0;
	  }
	  
	  private boolean isPointInList(int x, int y, LinkedList<Wegpunkt> list) {
	    for (int i = 0; i < list.size(); i++) {
	      if (((Wegpunkt)list.get(i)).x == x && ((Wegpunkt)list.get(i)).y == y)
	        return true; 
	    } 
	    return false;
	  }
	  
	  public void reset() {
	    this.openList = new LinkedList<Wegpunkt>();
	    this.openList.add(new Wegpunkt(this.playerX, this.playerY, 1, heuristik(this.playerX, this.playerY), null));
	    this.closedList = new LinkedList<Wegpunkt>();
	    this.finish = null;
	  }
	}

