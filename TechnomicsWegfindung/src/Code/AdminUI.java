package Code;

//Importliste
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdminUI extends JPanel
		implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	public AdminUI() {
	}

	ControlHandler ch;
	JFrame window;
	static APathfinding pathfinding;
	boolean showSteps, btnHover;
	int size;
	double a1, a2;
	char currentKey = (char) 0;
	Node startNode, endNode;
	String mode;
	JInternalFrame jInternalFrame;
	static int Modus;

	public static void main(String[] args) {
		initialize();
	}

	// Administratoroberfläche
	public static void initialize() {
		JFrame frame = new JFrame("AdminUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Startpunkt setzen");
		JButton btnNewButton_1 = new JButton("Ausloggen");
		JButton btnNewButton_2 = new JButton("Räume / Wege sperren");
		JButton btnNewButton_3 = new JButton("Räume / Wege freigeben");
		JButton btnNewButton_4 = new JButton("Endpunktsetzen");
		JButton btnHilfe = new JButton("Hilfe");
		JButton btnEnde = new JButton("Schließen");
		int size;
		Frame f = new Frame();
		
		//Vollbild
		GraphicsEnvironment graphics =
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();

		// Frame bestücken
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
	    frame.setResizable(false);
	    device.setFullScreenWindow(frame);

		// Wegfindung hinzufügen
		JInternalFrame jInternalFrame = new JInternalFrame();
		jInternalFrame.setLocation(10, 50);
		jInternalFrame.setTitle("Internal frame");
		jInternalFrame.setVisible(true);
		jInternalFrame.setClosable(true);
		jInternalFrame.setResizable(true);
		frame.getContentPane().add(jInternalFrame);
		jInternalFrame.addMouseListener(f);
		jInternalFrame.addMouseMotionListener(f);
		jInternalFrame.addKeyListener(f);
		size = 25;
		pathfinding = new APathfinding(size);
		pathfinding.setDiagonal(false);
		jInternalFrame.setTitle("A* Pathfinding Visualization");
		jInternalFrame.getContentPane().setPreferredSize(new Dimension(1500, 700));
		jInternalFrame.pack();
		jInternalFrame.setVisible(true);
		jInternalFrame.getContentPane().add(f);
		Frame.ini();
		jInternalFrame.revalidate();
		jInternalFrame.repaint();

		// Startpunkt setzen: Schaltfälcheneigenschaften
		btnNewButton.setBounds(-14, 0, 191, 48);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		
		// Endpunktsetzten: Schaltfälcheneigenschaften
		btnNewButton_4.setBounds(200, 0, 191, 48);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setForeground(Color.BLACK);

		// Abmelden: Schaltfälcheneigenschaften
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(755, 0, 165, 48);
		frame.getContentPane().add(btnNewButton_1);

		// Räume Sperren: Schaltfälcheneigenschaften
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(0, 800, 191, 48);
		frame.getContentPane().add(btnNewButton_2);

		// Räume Freigeben: Schaltfälcheneigenschaften
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(355, 800, 191, 48);
		frame.getContentPane().add(btnNewButton_3);

		// Programm beenden: Schaltfälcheneigenschaften
		btnEnde.setBackground(Color.DARK_GRAY);
		btnEnde.setForeground(Color.BLACK);
		btnEnde.setBounds(600, 0, 100, 25);
		frame.getContentPane().add(btnEnde);

		// Hilfe: Schaltfälcheneigenschaften
		btnHilfe.setBackground(Color.DARK_GRAY);
		btnHilfe.setForeground(Color.BLACK);
		btnHilfe.setBounds(400, 0, 100, 50);
		btnHilfe.isBackgroundSet();
		frame.getContentPane().add(btnHilfe);

///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Startpunkt setzen
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modus = 1;
			}
		});

		// Abmelden: Schaltfächenfunktion
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainUI MuI = new MainUI();
				MuI.login();
				frame.dispose();
			}
		});

		// Räume / Wege sperren
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modus = 2;
			}
		});

		// Räume / Wege freigeben
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modus = 3;
			}
		});
		
		// Endpunkt setzen
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modus = 4;
			}
		});

		// Programm beenden: Schaltfächenfunktion
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Sind Sie Sicher?", "Programm beenden?",
						JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					System.exit(0);
				}
			}
		});

		// Hilfe: Schaltfächenfunktion
		btnHilfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Auf das Display klicken um den Startpunkt auszuwählen "
								+ "\nRaumnummer eingeben um das Ziel auszuwählen"
								+ "\nWegberechnen anklicken um den Weg ausgegeben zu bekommen" + "\n"
								+ "\nAusloggen anklicken um in den Bildschrimschoner zugelangen" + "\n"
								+ "\nRäume Sperren klicken um die Räume zu sperren" + "\n"
								+ "\nRäume Freigeben klicken um die Räume zu entsperren" + "\n"
								+ "\nRäume konfigurieren klicken um die Räume zu verwalten wie zum Beispiel umbennen");
			}
		});

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (pathfinding.isNoPath()) {
			ch.getB("run").setText("clear");
			mode = "No Path";

// Kein Möglicher Weg ausgeben
			ch.noPathTBounds();
			ch.getL("noPathT").setVisible(true);
			jInternalFrame.getContentPane().add(ch.getL("noPathT"));
			jInternalFrame.revalidate();
		}

// Wegfinfung abgeschlossen
		if (pathfinding.isComplete()) {
// Schaltflächen beschriftung anpassen
			ch.getB("run").setText("clear");

			mode = "Completed in " + pathfinding.getRunTime() + "ms";
		}

// Zeichne das Grid
		g.setColor(Color.lightGray);
		for (int j = 0; j < jInternalFrame.getHeight(); j += size) {
			for (int i = 0; i < jInternalFrame.getWidth(); i += size) {
				g.drawRect(i, j, size, size);
			}
		}

// Zeichne die Wände
		g.setColor(Color.black);
		for (int i = 0; i < pathfinding.getBorderList().size(); i++) {
			g.fillRect(pathfinding.getBorderList().get(i).getX() + 1, pathfinding.getBorderList().get(i).getY() + 1,
					size - 1, size - 1);
		}

// Zeichne den Weg
		for (int i = 0; i < pathfinding.getPathList().size(); i++) {
			Node current = pathfinding.getPathList().get(i);

			g.setColor(style.blueHighlight);
			g.fillRect(current.getX() + 1, current.getY() + 1, size - 1, size - 1);
			drawInfo(current, g);
		}

// Zeichne den Startpunkt
		if (startNode != null) {
			g.setColor(Color.blue);
			g.fillRect(startNode.getX() + 1, startNode.getY() + 1, size - 1, size - 1);
		}
// Zeichne den Endpunkt
		if (endNode != null) {
			g.setColor(Color.red);
			g.fillRect(endNode.getX() + 1, endNode.getY() + 1, size - 1, size - 1);
		}

// Position all controls
		ch.position();
		ch.getL("speedC").setText("N/A");
	}

// Maus erkennen
	@Override
	public void mouseClicked(MouseEvent e) {
		MapCalculations(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		MapCalculations(e);
	}

	@Override
// Track mouse on movement
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int height = jInternalFrame.getHeight();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		currentKey = key;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentKey = (char) 0;
	}

// Starte Wegfindung
	void start() {
		if (startNode != null && endNode != null) {
			pathfinding.start(startNode, endNode);
		} else {
			JOptionPane.showMessageDialog(null, "Es muss ein Startpunkt, sowie ein Endpunkt definiert werden");
			System.out.println("ERROR: Needs start and end points to run.");
		}
	}

/*	@Override
// Scales the map with mouse wheel scroll
	public void mouseWheelMoved(MouseWheelEvent m) {
		int rotation = m.getWheelRotation();
		double prevSize = size;
		int scroll = 3;

// Changes size of grid based on scroll
		if (rotation == -1 && size + scroll < 200) {
			size += scroll;
		} else if (rotation == 1 && size - scroll > 2) {
			size += -scroll;
		}
		pathfinding.setSize(size);
		double ratio = size / prevSize;

// new X and Y values for Start
		if (startNode != null) {
			int sX = (int) Math.round(startNode.getX() * ratio);
			int sY = (int) Math.round(startNode.getY() * ratio);
			startNode.setXY(sX, sY);
		}

// new X and Y values for End
		if (endNode != null) {
			int eX = (int) Math.round(endNode.getX() * ratio);
			int eY = (int) Math.round(endNode.getY() * ratio);
			endNode.setXY(eX, eY);
		}

// new X and Y values for borders
		for (int i = 0; i < pathfinding.getBorderList().size(); i++) {
			int newX = (int) Math.round((pathfinding.getBorderList().get(i).getX() * ratio));
			int newY = (int) Math.round((pathfinding.getBorderList().get(i).getY() * ratio));
			pathfinding.getBorderList().get(i).setXY(newX, newY);
		}

// New X and Y for Open nodes
		for (int i = 0; i < pathfinding.getOpenList().size(); i++) {
			int newX = (int) Math.round((pathfinding.getOpenList().get(i).getX() * ratio));
			int newY = (int) Math.round((pathfinding.getOpenList().get(i).getY() * ratio));
			pathfinding.getOpenList().get(i).setXY(newX, newY);
		}

// New X and Y for Closed Nodes
		for (int i = 0; i < pathfinding.getClosedList().size(); i++) {
			if (!Node.isEqual(pathfinding.getClosedList().get(i), startNode)) {
				int newX = (int) Math.round((pathfinding.getClosedList().get(i).getX() * ratio));
				int newY = (int) Math.round((pathfinding.getClosedList().get(i).getY() * ratio));
				pathfinding.getClosedList().get(i).setXY(newX, newY);
			}
		}
		repaint();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
// Moves one step ahead in path finding (called on timer)
		if (pathfinding.isRunning() && showSteps) {
			pathfinding.findPath(pathfinding.getPar());
			mode = "Running";
		}

// Actions of run/stop/clear button
		if (e.getActionCommand() != null) {
			if (e.getActionCommand().equals("run") && !pathfinding.isRunning()) {
				ch.getB("run").setText("stop");
				start();
			} else if (e.getActionCommand().equals("clear")) {
				ch.getB("run").setText("run");
				mode = "Map Creation";
				ch.getL("noPathT").setVisible(false);
				pathfinding.reset();
			} else if (e.getActionCommand().equals("stop")) {
				ch.getB("run").setText("start");
			} else if (e.getActionCommand().equals("start")) {
				ch.getB("run").setText("stop");
			}
		}
		repaint();
	}

// Returns random number between min and max
	int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public void drawInfo(Node current, Graphics g) {
		if (size > 50) {
			g.setFont(style.numbers);
			g.setColor(Color.black);
			g.drawString(Integer.toString(current.getF()), current.getX() + 4, current.getY() + 16);
			g.setFont(style.smallNumbers);
			g.drawString(Integer.toString(current.getG()), current.getX() + 4, current.getY() + size - 7);
			g.drawString(Integer.toString(current.getH()), current.getX() + size - 26, current.getY() + size - 7);
		}
	}

	public void MapCalculations(MouseEvent e) {
// If left mouse button is clicked
		if (SwingUtilities.isLeftMouseButton(e)) {
// If 's' is pressed create start node
			if (currentKey == 's') {
				int xRollover = e.getX() % size;
				int yRollover = e.getY() % size;

				if (startNode == null) {
					startNode = new Node(e.getX() - xRollover, e.getY() - yRollover);
				} else {
					startNode.setXY(e.getX() - xRollover, e.getY() - yRollover);
				}
				repaint();
			}
// If 'e' is pressed create end node
			else if (currentKey == 'e') {
				int xRollover = e.getX() % size;
				int yRollover = e.getY() % size;

				if (endNode == null) {
					endNode = new Node(e.getX() - xRollover, e.getY() - yRollover);
				} else {
					endNode.setXY(e.getX() - xRollover, e.getY() - yRollover);
				}
				repaint();
			}
// Otherwise, create a wall
			else {
				int xBorder = e.getX() - (e.getX() % size);
				int yBorder = e.getY() - (e.getY() % size);

				Node newBorder = new Node(xBorder, yBorder);
				pathfinding.addBorder(newBorder);

				pathfinding.speicherWand();
				repaint();
			}
		}
// If right mouse button is clicked
		else if (SwingUtilities.isRightMouseButton(e)) {
			int mouseBoxX = e.getX() - (e.getX() % size);
			int mouseBoxY = e.getY() - (e.getY() % size);

// If 's' is pressed remove start node
			if (currentKey == 's') {
				if (startNode != null && mouseBoxX == startNode.getX() && startNode.getY() == mouseBoxY) {
					startNode = null;
					repaint();
				}
			}
// If 'e' is pressed remove end node
			else if (currentKey == 'e') {
				if (endNode != null && mouseBoxX == endNode.getX() && endNode.getY() == mouseBoxY) {
					endNode = null;
					repaint();
				}
			}
// Otherwise, remove wall
			else {
				int Location = pathfinding.searchBorder(mouseBoxX, mouseBoxY);
				if (Location != -1) {
					pathfinding.removeBorder(Location);
				}
				repaint();
			}
		}
	}

}
