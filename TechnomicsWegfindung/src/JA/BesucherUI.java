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
import javax.swing.ImageIcon;

public class BesucherUI{

		public static void main(String[] args) {
			initialize();
		}
	
	public static void initialize() {
		JFrame frame = new JFrame("BesucherUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Neue Route berechnen");
		JButton btnNewButton_1 = new JButton("Zur�ck zum Men�");

		frame.setBounds(0, 0, 914, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/JA/Unbenannt-6-69a068fa33888d06.jpg"));
		lblNewLabel.setBounds(0, 53, 900, 668);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton.setBounds(0, 0, 188, 63);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1.setBounds(712, 0, 188, 56);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
				MainUI MuI = new MainUI();
				MuI.login();
			}
		});
		//lblNewLabel.setBounds(xaxepos, yaxepos, xgr��e, ygr��e);//
	}
}