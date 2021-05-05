package JA;
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

	public static void login() {
		JFrame frame = new JFrame();//("Login");
		JPanel panel = new JPanel();
		JButton btnOhneLogin = new JButton("Hier Klicken um ohne Anmeldung fortzufahren");
		JButton btnLogin = new JButton("Anmelden");
		
		GraphicsEnvironment graphics =
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AnmeldenUI AUI=new AnmeldenUI();
			AUI.initialize();
			frame.dispose();
			}
		});
		
	    frame.add(panel); 
	    frame.add(btnLogin);
	    frame.add(btnOhneLogin);
		frame.setUndecorated(true);
	    frame.setResizable(false);
	    device.setFullScreenWindow(frame);

		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(0, 0, 100, 100);
		btnLogin.isBackgroundSet();
		btnLogin.setOpaque(true);
		frame.getContentPane().add(btnLogin);

		btnOhneLogin.setBackground(Color.WHITE);
		btnOhneLogin.isBackgroundSet();
		btnOhneLogin.setOpaque(true);
		frame.getContentPane().add(btnOhneLogin);
		btnOhneLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		BesucherUI BUI=new BesucherUI();
		BUI.initialize();
		frame.dispose();
		}
	});
}}
/*http://blog.mynotiz.de/programmieren/java-messagedialog-messagebox-242/*/