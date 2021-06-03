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
		
	//Besucheroberfläche
	public static void initialize() {
		JFrame frame = new JFrame("BesucherUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Neue Route berechnen");
		JButton btnNewButton_1 = new JButton("Zurück zum Menü");
		JButton btnHilfe = new JButton("Hilfe");

	//Frame bestücken
		frame.setBounds(0, 0, 914, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	//Kartenbild		
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/JA/Unbenannt-6-69a068fa33888d06.jpg"));
		lblNewLabel.setBounds(0, 53, 900, 668);
		frame.getContentPane().add(lblNewLabel);
		
	//Wegfindung Starten: Schaltfälcheneigenschaften
		btnNewButton.setBounds(0, 0, 188, 63);
		frame.getContentPane().add(btnNewButton);
		
	//Hilfe: Schaltfälcheneigenschaften		
		btnHilfe.setBackground(Color.WHITE);
		btnHilfe.setBounds(200, 0, 100, 50);
		btnHilfe.isBackgroundSet();
		frame.getContentPane().add(btnHilfe);
		
	//Abmelden: Schaltfälcheneigenschaften	
		btnNewButton_1.setBounds(712, 0, 188, 56);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		
	//Wegfindung: Schaltfächenfunktion
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//Hilfe: Schaltfächenfunktion
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
		
	//Abmelden: Schaltfächenfunktion
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainUI MuI = new MainUI();
			MuI.login();
			frame.dispose();
			}
		});

	}
}