package Code;

//Importliste
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
		
	//Besucheroberfl�che
	public static void initialize() {
		JFrame frame = new JFrame("BesucherUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Neue Route berechnen");
		JButton btnNewButton_1 = new JButton("Zur�ck zum Men�");
		JButton btnHilfe = new JButton("Hilfe");

	//Frame best�cken
		frame.setBounds(0, 0, 914, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	//Kartenbild		
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/JA/Unbenannt-6-69a068fa33888d06.jpg"));
		lblNewLabel.setBounds(0, 53, 900, 668);
		frame.getContentPane().add(lblNewLabel);
		
	//Wegfindung Starten: Schaltf�lcheneigenschaften
		btnNewButton.setBounds(0, 0, 188, 63);
		frame.getContentPane().add(btnNewButton);
		
	//Hilfe: Schaltf�lcheneigenschaften		
		btnHilfe.setBackground(Color.WHITE);
		btnHilfe.setBounds(200, 0, 100, 50);
		btnHilfe.isBackgroundSet();
		frame.getContentPane().add(btnHilfe);
		
	//Abmelden: Schaltf�lcheneigenschaften	
		btnNewButton_1.setBounds(712, 0, 188, 56);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		
	//Wegfindung: Schaltf�chenfunktion
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//Hilfe: Schaltf�chenfunktion
		btnHilfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
			   "Auf das Display klicken um den Startpunkt auszuw�hlen "
			 + "\nRaumnummer eingeben um das Ziel auszuw�hlen"
			 + "\nWegberechnen anklicken um den Weg ausgegeben zu bekommen"
			 + "\n"
			 + "\nZur�ck zum Men� anklicken um in den Bildschrimschoner zugelangen");
			}
		});
		
	//Abmelden: Schaltf�chenfunktion
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainUI MuI = new MainUI();
			MuI.login();
			frame.dispose();
			}
		});

	}
}