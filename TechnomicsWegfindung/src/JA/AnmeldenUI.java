package JA;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.border.LineBorder;

import org.json.simple.JSONObject;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnmeldenUI{
	public static String Passwordinput = "";
			
	private static JPasswordField passwordField;
	public static void main(String[] args) {
			initialize();	
		}

public static void Exit() {
	System.exit(0);
}
	public static void initialize() {
		JFrame frame = new JFrame("AnmeldenUI");
		JButton btn_Login = new JButton("Anmelden");
		JLabel lbl_Pw = new JLabel("Bitte Password eintragen");
		JButton btn_1 = new JButton("1");
		JButton btn_2 = new JButton("2");
		JButton btn_3 = new JButton("3");
		JButton btn_4 = new JButton("4");
		JButton btn_5 = new JButton("5");
		JButton btn_6 = new JButton("6");
		JButton btn_7 = new JButton("7");
		JButton btn_8 = new JButton("8");
		JButton btn_9 = new JButton("9");
		JButton btn_0 = new JButton("0");
		Icon icon = new ImageIcon("src/Backspace_Arrow.png");
		JButton btn_Loeschen = new JButton(icon);
		passwordField = new JPasswordField();
		JPanel panel = new JPanel();

		GraphicsEnvironment graphics =
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
				
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String password = passwordField.getText();
			passwordField.setText("");
			Passwordinput="";
		if(password.equals("4646")) {
			passwordField.setText("");	
			AdminUI AUI= new AdminUI();
			AUI.initialize();
			frame.dispose();
		
		}else if(password.equals("5858")) {
			passwordField.setText("");
			MitarbeiterUI MUI= new MitarbeiterUI();
			MUI.initialize();
			frame.dispose();
				
			
		}else {
			JOptionPane.showMessageDialog(frame, "Ungültige Eingabe","Error", JOptionPane.ERROR_MESSAGE);
		}
	};

		//lblNewLabel.setBounds(xaxepos, yaxepos, xgröße, ygröße);//
});
	    frame.getContentPane().setLayout(null);
	    
	    frame.getContentPane().add(panel); 
	    frame.getContentPane().add(btn_Loeschen);
	    frame.getContentPane().add(btn_1);
	    frame.getContentPane().add(btn_2);
	    frame.getContentPane().add(btn_3);
	    frame.getContentPane().add(btn_4);
	    frame.getContentPane().add(btn_5);
	    frame.getContentPane().add(btn_6);
	    frame.getContentPane().add(btn_7);
	    frame.getContentPane().add(btn_8);
	    frame.getContentPane().add(btn_9);
	    frame.getContentPane().add(btn_0);
	    frame.getContentPane().add(btn_Login);
	    frame.getContentPane().add(lbl_Pw);
	
		frame.setUndecorated(true);
	    frame.setResizable(false);
	    device.setFullScreenWindow(frame);
	    

		passwordField.setOpaque(true);
		passwordField.setBounds(404, 64, 177, 44);
		frame.getContentPane().add(passwordField);
		
		btn_Login.setBounds(431,118,125,44);
		btn_Login.setOpaque(true);
		frame.getContentPane().add(btn_Login);

		lbl_Pw.setBounds(431, 10, 150, 44);
		lbl_Pw.setOpaque(true);
		frame.getContentPane().add(lbl_Pw);
		
		btn_1.setBounds(411, 306, 50, 50);
		btn_1.setOpaque(true);
		frame.getContentPane().add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "1";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_2.setBounds(471, 306, 50, 50);
		btn_2.setOpaque(true);
		frame.getContentPane().add(btn_2);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "2";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_3.setBounds(531, 306, 50, 50);
		btn_3.setOpaque(true);
		frame.getContentPane().add(btn_3);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "3";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_4.setBounds(411, 246, 50, 50);
		btn_4.setOpaque(true);
		frame.getContentPane().add(btn_4);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "4";
				passwordField.setText(Passwordinput);
			}
		});
	
		btn_5.setBounds(471, 246, 50, 50);
		btn_5.setOpaque(true);
		frame.getContentPane().add(btn_5);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "5";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_6.setBounds(531, 246, 50, 50);
		btn_6.setOpaque(true);
		frame.getContentPane().add(btn_6);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "6";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_7.setBounds(411, 186, 50, 50);
		btn_7.setOpaque(true);
		frame.getContentPane().add(btn_7);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "7";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_8.setBounds(471, 186, 50, 50);
		btn_8.setOpaque(true);
		frame.getContentPane().add(btn_8);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "8";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_9.setBounds(531, 186, 50, 50);
		btn_9.setOpaque(true);
		frame.getContentPane().add(btn_9);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "9";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_0.setBounds(471, 366, 50, 50);
		btn_0.setOpaque(true);
		frame.getContentPane().add(btn_0);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordinput = Passwordinput + "0";
				passwordField.setText(Passwordinput);
			}
		});
		
		btn_Loeschen.setBounds(531, 366, 50, 50);
		btn_Loeschen.setOpaque(true);
		frame.getContentPane().add(btn_Loeschen);
		btn_Loeschen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Passwordinput = Passwordinput = "";
		passwordField.setText(Passwordinput);
			}
		});
	}
}