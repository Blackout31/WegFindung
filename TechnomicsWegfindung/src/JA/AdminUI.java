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
import java.awt.Label;
import javax.swing.ImageIcon;

public class AdminUI{

		public static void main(String[] args) {
			initialize();
		}
	
	public static void initialize() {
		JFrame frame = new JFrame("AdminUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Neue Route Bestimmen");
		JButton btnNewButton_1 = new JButton("Ausloggen");
		JButton btnNewButton_2 = new JButton("Räume sperren");
		JButton btnNewButton_3 = new JButton("Räume freigeben");
		JButton btnNewButton_4 = new JButton("Räume konfigurieren");

		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(0, 0, 920, 785);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/img/Karte.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 47, 907, 657);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
		btnNewButton.setBounds(-14, 0, 191, 48);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(742, 0, 165, 48);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainUI MuI = new MainUI();
				MuI.login();
			}
		});
		
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(0, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.setBounds(357, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_4.setBackground(new Color(211, 211, 211));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(716, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//lblNewLabel.setBounds(xaxepos, yaxepos, xgröße, ygröße);//
	}
}


