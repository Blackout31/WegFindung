package Code;

//Importliste
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.Color;

import java.awt.Toolkit;


public class MainUI {

	public static void main(String[] args) {
		login();
	}
	
	//Hauptoberfälche
	public static void login() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton btnOhneLogin = new JButton("Hier Klicken um ohne Anmeldung fortzufahren");
		JButton btnLogin = new JButton("Anmelden");
	
	//Vollbild
		GraphicsEnvironment graphics =
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		
	//Frame bestücken	
	    frame.add(panel); 
	    frame.add(btnLogin);
	    frame.add(btnOhneLogin);
		frame.setUndecorated(true);
	    frame.setResizable(false);
	    device.setFullScreenWindow(frame);

	//Anmeldung: Schaltfälcheneigenschaften
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(0, 0, 100, 100);
		btnLogin.isBackgroundSet();
		btnLogin.setOpaque(true);
		frame.getContentPane().add(btnLogin);
		
	//Ohne Anmeldung fortfahren: Schaltfälcheneigenschaften
		btnOhneLogin.setBackground(Color.WHITE);
		btnOhneLogin.isBackgroundSet();
		btnOhneLogin.setOpaque(true);
		frame.getContentPane().add(btnOhneLogin);
		
//////////////////////////////////////////////////////////////////////////////////////////
		
	//Anmelden: Schaltfächenfunktion
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AnmeldenUI AUI=new AnmeldenUI();
			AUI.initialize();
			frame.dispose();
			}
		});
		
	//Ohne Ameldung fortfahren: Schaltfächenfunktion
		btnOhneLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BesucherUI BUI=new BesucherUI();
			BUI.initialize();
			frame.dispose();
			}
		});

	}
}