package JA;

import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.*;
public class Test{

	public static void main(String[] args) {
		
		JFrame fenster = new JFrame();
		fenster.setTitle("Test");
		fenster.setSize(400,300);
		fenster.setLocation(700,20);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setVisible(true);
		ImageIcon img = new ImageIcon("Karte.png");
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Text");
		panel.add(label);
		fenster.add(panel);
	}
}	