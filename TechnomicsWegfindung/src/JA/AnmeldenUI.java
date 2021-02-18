package JA;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class AnmeldenUI{
	public static String Passwordinput = "";
			
	private static JPasswordField passwordField;
	public static void main(String[] args) {
			initialize();	
		}
	
	public static void initialize() {
		JFrame frame = new JFrame("AnmeldenUI");
		JButton btnLogin = new JButton("Anmelden");
		JLabel lblNewLabel = new JLabel("Bitte Password eintragen");
		JButton btnNewButton = new JButton("1");
		JButton btnNewButton_1 = new JButton("2");
		JButton btnNewButton_2 = new JButton("3");
		JButton btnNewButton_4 = new JButton("4");
		JButton btnNewButton_3 = new JButton("5");
		JButton btnNewButton_9 = new JButton("6");
		JButton btnNewButton_8 = new JButton("7");
		JButton btnNewButton_10 = new JButton("8");
		JButton btnNewButton_5 = new JButton("9");
		JButton btnNewButton_7 = new JButton("0");
		JButton btnNewButton_6 = new JButton("New button");
				
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String password = passwordField.getText();
		if(password.equals("Admin")) {
			passwordField.setText("");
			frame.setVisible(false);
			AdminUI AUI= new AdminUI();
			AUI.initialize();
		
		}else if(password.equals("Mitarbeiter")) {
			passwordField.setText("");
			frame.setVisible(false);
			MitarbeiterUI MUI= new MitarbeiterUI();
			MUI.initialize();
				
			
		}else {
			JOptionPane.showMessageDialog(frame, "Ungültige Eingabe","Error", JOptionPane.ERROR_MESSAGE);
		}
	};

		//lblNewLabel.setBounds(xaxepos, yaxepos, xgröße, ygröße);//
});
		frame.setBounds(0, 0, 690, 661);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 219, 177, 44);
		passwordField.isForegroundSet();
		frame.getContentPane().add(passwordField);
		
		btnLogin.setBounds(220,273,125,44);
		btnLogin.isForegroundSet();
		frame.getContentPane().add(btnLogin);
		
		lblNewLabel.setBounds(220, 165, 150, 44);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton.setBounds(157, 341, 41, 44);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "1";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_1.setBounds(208, 341, 41, 44);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "2";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_2.setBounds(259, 341, 41, 44);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "3";
				passwordField.setText(Passwordinput);
			}
		});
	
		btnNewButton_3.setBounds(208, 391, 41, 42);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "5";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_4.setBounds(157, 390, 41, 44);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "4";
				passwordField.setText(Passwordinput);
			}
		});
		
		
		btnNewButton_5.setBounds(259, 451, 41, 38);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "9";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_7.setBounds(208, 499, 41, 46);
		frame.getContentPane().add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "0";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_8.setBounds(157, 451, 41, 38);
		frame.getContentPane().add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "7";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_9.setBounds(259, 395, 41, 38);
		frame.getContentPane().add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "6";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_10.setBounds(208, 451, 41, 38);
		frame.getContentPane().add(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "8";
				passwordField.setText(Passwordinput);
			}
		});
		
		btnNewButton_6.setBounds(259, 504, 41, 44);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/JA/Unbenannt-6-69a068fa33888d06.jpg"));
		btnNewButton_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Passwordinput = Passwordinput = "";
		passwordField.setText(Passwordinput);
			}
		});
	}
}