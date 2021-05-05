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

public class MitarbeiterUI{

		public static void main(String[] args) {
			initialize();
		}
	
	public static void initialize() {
		JFrame frame = new JFrame("MitarbeiterUI");
		JLabel lblNewLabel = new JLabel("New label");	
		JButton btnNewButton = new JButton("Neue Route bestimmen");
		JButton btnNewButton_1 = new JButton("Ausloggen");
		JButton btnHilfe = new JButton("Hilfe");
		
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0, 0, 914, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/JA/Unbenannt-6-69a068fa33888d06.jpg"));
		lblNewLabel.setBounds(0, 41, 902, 665);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
		btnNewButton.setBounds(0, 0, 147, 45);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_1.setBounds(772, 0, 130, 45);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainUI MuI = new MainUI();
				MuI.login();
				frame.dispose();
			}
		});
		
		btnHilfe.setBackground(Color.WHITE);
		btnHilfe.setBounds(200, 0, 100, 50);
		btnHilfe.isBackgroundSet();
		frame.getContentPane().add(btnHilfe);
		btnHilfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 JOptionPane.showMessageDialog(null,
					  "Auf das Display klicken um den Startpunkt auszuwählen "
			 		+ "\nRaumnummer eingeben um das Ziel auszuwählen"
			 		+ "\nWegberechnen anklicken um den Weg ausgegeben zu bekommen"
			 		+ "\n"
			 		+ "\nZurück zum Menü anklicken um in den Bildschrimschoner zugelangen");
				}
			});
		//lblNewLabel.setBounds(xaxepos, yaxepos, xgröße, ygröße);//
	}
}
/*JButton btnLogin = new JButton("Anmelden");
btnLogin.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	AnmeldenUI AUI=new AnmeldenUI();
	AUI.initialize();
	}
});*/