package JA;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.Color;

public class MainUI {

	public static void main(String[] args) {
//		initialize();
		login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static void initialize() {
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
		frame.setBounds(100, 100, 811, 829);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Btn_Start = new JButton("VALLAHI");
		Btn_Start.setBounds(0,0,15,15);
		frame.getContentPane().add(Btn_Start);
		
		Btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 JOptionPane.showMessageDialog(null,"Vallah","Lösch dich", JOptionPane.ERROR_MESSAGE);
			 System.exit(0);
				}
			});
		}
	
	public static void login() {
		JFrame frame = new JFrame("Login");
		JButton btnOhneLogin = new JButton("Hier Klicken um ohne Anmeldung fortzufahren");
		JButton btnLogin = new JButton("Anmelden");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AnmeldenUI AUI=new AnmeldenUI();
			AUI.initialize();
			frame.dispose();
			}
		});
		
		frame.setBounds(0, 0, 1006, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(0, 0, 100, 100);
		btnLogin.isBackgroundSet();
		frame.getContentPane().add(btnLogin);

		btnOhneLogin.setBackground(Color.WHITE);
		btnOhneLogin.setBounds(0, 0, 996, 992);
		btnOhneLogin.isBackgroundSet();
		frame.getContentPane().add(btnOhneLogin);
		btnOhneLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		BesucherUI BUI=new BesucherUI();
		BUI.initialize();
		frame.dispose();
		}
	});


};

}
/*http://blog.mynotiz.de/programmieren/java-messagedialog-messagebox-242/*/