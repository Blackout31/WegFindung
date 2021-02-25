package JA;

import java.awt.Graphics;

public class Wegpunkt {
	public int x;
	  
	  public int y;
	  
	  public int kosten;
	  
	  public int heuristik;
	  
	  Wegpunkt vorgaenger;
	  
	  public Wegpunkt(int x, int y, int kosten, int heuristik, Wegpunkt vor) {
	    this.x = x;
	    this.y = y;
	    this.kosten = kosten;
	    this.heuristik = heuristik;
	    this.vorgaenger = vor;
	  }
	  
	  public int getGesamtkosten() {
	    return getBisherigeWegkosten() + this.kosten + this.heuristik;
	  }
	  
	  public int getBisherigeWegkosten() {
	    if (this.vorgaenger == null)
	      return 0; 
	    return this.vorgaenger.getBisherigeWegkosten() + this.kosten;
	  }
	  
	  public void setVorgaenger(Wegpunkt neuer) {
	    this.vorgaenger = neuer;
	  }
	  
	  public void print() {
	    if (this.vorgaenger != null)
	      this.vorgaenger.print(); 
	    System.out.println("x:" + this.x + " y:" + this.y);
	  }
	  
	  public void draw(Graphics g, int ratio) {
	    g.fillRect(this.x * ratio, this.y * ratio, ratio, ratio);
	    if (this.vorgaenger != null)
	      this.vorgaenger.draw(g, ratio); 
	  }
	}