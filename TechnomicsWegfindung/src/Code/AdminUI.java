package Code;

//Importliste
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdminUI extends JPanel
implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

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
	
		public static void main(String[] args) {
			initialize();
		}
		
	//Administratoroberfläche
	public static void initialize() {
		JFrame frame = new JFrame("AdminUI");
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton = new JButton("Neue Route Bestimmen");
		JButton btnNewButton_1 = new JButton("Ausloggen");
		JButton btnNewButton_2 = new JButton("Räume sperren");
		JButton btnNewButton_3 = new JButton("Räume freigeben");
		JButton btnNewButton_4 = new JButton("Räume konfigurieren");
		JButton btnHilfe = new JButton("Hilfe");
		JButton btnEnde = new JButton("Schließen");
		JPanel panel;
		JPanel panel2;
		int size;
		Frame f = new Frame();

	//Frame bestücken
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(0, 0, 920, 785);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	//Wegfindung anzeige eigenschaften
		panel = new JPanel();
		panel.setBounds(0, 703, 907, -654);
		panel.setBackground(new Color(255,0,0));
		frame.getContentPane().add(panel);
		
	//Wegfindung anzeige eigenschaften
//		panel2 = f.Frame();
//		panel2.setBounds(0, 703, 907, -654);
//		panel2.setBackground(new Color(255,0,0));
//		frame.getContentPane().add(panel2);
		
        JInternalFrame jInternalFrame=new JInternalFrame();
        jInternalFrame.setLocation(100, 100);
        jInternalFrame.setSize(500, 300);
        jInternalFrame.setTitle("Internal frame");
        jInternalFrame.setVisible(true);
        jInternalFrame.setClosable(true);
        jInternalFrame.setResizable(true);
        frame.add(jInternalFrame);
        jInternalFrame.addMouseListener(f);
        jInternalFrame.addMouseMotionListener(f);
        jInternalFrame.addMouseWheelListener(f);
        jInternalFrame.addKeyListener(f);
        size = 25;
		pathfinding = new APathfinding(size);
		pathfinding.setDiagonal(false);
		jInternalFrame.setTitle("A* Pathfinding Visualization");
		jInternalFrame.getContentPane().setPreferredSize(new Dimension(700, 600));
		jInternalFrame.pack();
		jInternalFrame.setVisible(true);
		jInternalFrame.add(f);
		jInternalFrame.revalidate();
		jInternalFrame.repaint();
// sadad		frame.repaint();
		
	
	//Kartenbild	
		lblNewLabel.setIcon(new ImageIcon("file:///C:/Users/Sujan%20Sirimorhan/eclipse-workspace/TechnomicsWegfindung/src/img/Karte.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 47, 907, 657);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	
	//Wegfindung Starten: Schaltfälcheneigenschaften		
		btnNewButton.setBounds(-14, 0, 191, 48);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(Color.BLACK);
	
	//Abmelden: Schaltfälcheneigenschaften		
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(742, 0, 165, 48);
		frame.getContentPane().add(btnNewButton_1);
	
	//Räume Sperren: Schaltfälcheneigenschaften
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(0, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_2);
		
	//Räume Freigeben: Schaltfälcheneigenschaften	
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(357, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_3);
		
	//Räume	konfiguriren: Schaltfälcheneigenschaften 
		btnNewButton_4.setBackground(new Color(211, 211, 211));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBounds(716, 703, 191, 48);
		frame.getContentPane().add(btnNewButton_4);
	
	//Programm beenden: Schaltfälcheneigenschaften 
		btnEnde.setBackground(new Color(211, 211, 211));
		btnEnde.setForeground(Color.BLACK);
		btnEnde.setBounds(600, 0, 100, 25);
		frame.getContentPane().add(btnEnde);
		
	//Hilfe: Schaltfälcheneigenschaften			
		btnHilfe.setBackground(new Color(211, 211, 211));
		btnHilfe.setForeground(Color.BLACK);
		btnHilfe.setBounds(200, 0, 100, 50);
		btnHilfe.isBackgroundSet();
		frame.getContentPane().add(btnHilfe);
		
//////////////////////////////////////////////////////////////////////
	//Wegfindung: Schaltfächenfunktion
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//Abmelden: Schaltfächenfunktion
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			MainUI MuI = new MainUI();
			MuI.login();
			}
		});
		
	//Räume Sperren: Schaltfächenfunktion
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		
	//Räume konfiguriren: Schaltfächenfunktion
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//Räume Freigeben: Schaltfächenfunktion
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	//Programm beenden: Schaltfächenfunktion
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(null,"Sind Sie Sicher?","Programm beenden?", JOptionPane.YES_NO_OPTION);
			System.exit(0);
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
			+ "\nAusloggen anklicken um in den Bildschrimschoner zugelangen"
			+ "\n"
			+ "\nRäume Sperren klicken um die Räume zu sperren"
			+ "\n"
			+ "\nRäume Freigeben klicken um die Räume zu entsperren"
			+ "\n"
			+ "\nRäume konfigurieren klicken um die Räume zu verwalten wie zum Beispiel umbennen");
			}
		});

	}
//////////////////////////////////////////////////////////////////////////////////////////
public void paintComponent(Graphics g) {
super.paintComponent(g);

// Grab dimensions of panel
int height = getHeight();
int width = getWidth();

// If no path is found
if (pathfinding.isNoPath()) {
// Set timer for animation
//timer.setDelay(50);
//timer.start();

// Set text of "run" button to "clear"
ch.getB("run").setText("clear");

// Set mode to "No Path"
mode = "No Path";


// Place "No Path" text on screen in center
ch.noPathTBounds();
ch.getL("noPathT").setVisible(true);
jInternalFrame.add(ch.getL("noPathT"));
jInternalFrame.revalidate();
}

// If pathfinding is complete (found path)
if (pathfinding.isComplete()) {
// Set run button to clear
ch.getB("run").setText("clear");

// Set timer delay, start for background animation
//timer.setDelay(50);
//timer.start();

// // Make the background flicker
// Color flicker = new Color(r, G, b);
// g.setColor(flicker);
// g.fillRect(0, 0, getWidth(), getHeight());

// Set completed mode
// if(showSteps) {
// 	mode = "Completed";
// }
// else {
mode = "Completed in " + pathfinding.getRunTime() + "ms";
// 	}
}

// Draws grid
g.setColor(Color.lightGray);
for (int j = 0; j < jInternalFrame.getHeight(); j += size) {
for (int i = 0; i < jInternalFrame.getWidth(); i += size) {
g.drawRect(i, j, size, size);
}
}

// Draws all borders
g.setColor(Color.black);
for (int i = 0; i < pathfinding.getBorderList().size(); i++) {
g.fillRect(pathfinding.getBorderList().get(i).getX() + 1, pathfinding.getBorderList().get(i).getY() + 1,
size - 1, size - 1);
}

// // Draws all open Nodes (path finding nodes)
// for (int i = 0; i < pathfinding.getOpenList().size(); i++) {
// 	Node current = pathfinding.getOpenList().get(i);
// 	g.setColor(style.greenHighlight);
// 	g.fillRect(current.getX() + 1, current.getY() + 1, size - 1, size - 1);

// 	drawInfo(current, g);
// }

// // Draws all closed nodes
// for (int i = 0; i < pathfinding.getClosedList().size(); i++) {
// 	Node current = pathfinding.getClosedList().get(i);

// 	g.setColor(style.redHighlight);
// 	g.fillRect(current.getX() + 1, current.getY() + 1, size - 1, size - 1);

// 	drawInfo(current, g);
// }

// Draw all final path nodes
for (int i = 0; i < pathfinding.getPathList().size(); i++) {
Node current = pathfinding.getPathList().get(i);

g.setColor(style.blueHighlight);
g.fillRect(current.getX() + 1, current.getY() + 1, size - 1, size - 1);

drawInfo(current, g);
}

// Draws start of path
if (startNode != null) {
g.setColor(Color.blue);
g.fillRect(startNode.getX() + 1, startNode.getY() + 1, size - 1, size - 1);
}
// Draws end of path
if (endNode != null) {
g.setColor(Color.red);
g.fillRect(endNode.getX() + 1, endNode.getY() + 1, size - 1, size - 1);
}

// If control panel is being hovered, change colours
//if(btnHover) {
//g.setColor(style.darkText);
//ch.hoverColour();
//}
//else {
//g.setColor(style.btnPanel);
//ch.nonHoverColour();
//}
// Drawing control panel rectangle
//g.fillRect(10, height-96, 322, 90);

// Setting mode text
//ch.getL("modeText").setText("Mode: " + mode);

// Position all controls
ch.position();

// Setting numbers in pathfinding lists
//ch.getL("openC").setText(Integer.toString(pathfinding.getOpenList().size()));
//ch.getL("closedC").setText(Integer.toString(pathfinding.getClosedList().size()));
//ch.getL("pathC").setText(Integer.toString(pathfinding.getPathList().size()));

// Setting speed number text in showSteps or !showSteps mode
//if(showSteps) {
//ch.getL("speedC").setText(Integer.toString(ch.getS("speed").getValue()));
//}
//else {
ch.getL("speedC").setText("N/A");
//}

// Getting values from checkboxes
//showSteps = ch.getC("showStepsCheck").isSelected();
//pathfinding.setDiagonal(ch.getC("diagonalCheck").isSelected());
//pathfinding.setDiagonal(false);
//showSteps = false;
//pathfinding.setTrig(ch.getC("trigCheck").isSelected());
}

@Override
public void mouseClicked(MouseEvent e) {
MapCalculations(e);
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e) {}

@Override
public void mouseExited(MouseEvent e) {}

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

// Detects if mouse is within button panel
//if(x >= 10 && x <= 332 && y >= (height-96) && y <= (height-6)) {
//btnHover = true;
//}
//else {
//btnHover = false;
//}
//repaint();
}

@Override
public void keyTyped(KeyEvent e) {}

@Override
public void keyPressed(KeyEvent e) {
char key = e.getKeyChar();
currentKey = key;

// Start if space is pressed
//if (currentKey == KeyEvent.VK_SPACE) {
//ch.getB("run").setText("stop");
//start();
//}
}

@Override
public void keyReleased(KeyEvent e) {
currentKey = (char) 0;
}

// Starts path finding
void start() {
if(startNode != null && endNode != null) {
//if (!showSteps) {
pathfinding.start(startNode, endNode);
//} else {
//pathfinding.setup(startNode, endNode);
//setSpeed();
//timer.start();
//}
}
else {
JOptionPane.showMessageDialog(null,"Es muss ein Startpunkt, sowie ein Endpunkt definiert werden");
//reset()
System.out.println("ERROR: Needs start and end points to run.");
}
}

@Override
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
}

@Override
public void actionPerformed(ActionEvent e) {
// Moves one step ahead in path finding (called on timer)
if (pathfinding.isRunning() && showSteps) {
pathfinding.findPath(pathfinding.getPar());
mode = "Running";
}
// // Finish pathfinding background flicker!
// if (pathfinding.isComplete() || pathfinding.isNoPath()) {
// 	r = (int) (Math.random() * ((r + 15) - (r - 15)) + (r - 15));
// 	G = (int) (Math.random() * ((G + 15) - (G - 15)) + (G - 15));
// 	b = (int) (Math.random() * ((b + 15) - (b - 15)) + (b - 15));

// 	if (r >= 240 | r <= 15) {
// 		r = randomWithRange(0, 255);
// 	}
// 	if (G >= 240 | G <= 15) {
// 		G = randomWithRange(0, 255);
// 	}
// 	if (b >= 240 | b <= 15) {
// 		b = randomWithRange(0, 255);
// 	}
// }

// Actions of run/stop/clear button
if(e.getActionCommand() != null) {
if(e.getActionCommand().equals("run") && !pathfinding.isRunning()) {
ch.getB("run").setText("stop");
start();
}
else if(e.getActionCommand().equals("clear")) {
ch.getB("run").setText("run");
mode = "Map Creation";
ch.getL("noPathT").setVisible(false);
pathfinding.reset();
}
else if(e.getActionCommand().equals("stop")) {
ch.getB("run").setText("start");
//timer.stop();
}
else if(e.getActionCommand().equals("start")) {
ch.getB("run").setText("stop");
//timer.start();
}
}
repaint();
}

// Returns random number between min and max
int randomWithRange(int min, int max)
{
int range = (max - min) + 1;     
return (int)(Math.random() * range) + min;
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

/*				JSONParser jsonParser = new JSONParser();

//First Employee
JSONObject employeeDetails = new JSONObject();
employeeDetails.put("x", xBorder);
employeeDetails.put("y", yBorder);

JSONObject employeeObject = new JSONObject(); 
employeeObject.put("employee", employeeDetails);
JSONArray employeeList = new JSONArray();
employeeList.add(employeeObject);

try (FileReader reader = new FileReader("Passwort.json"))
{

//Read JSON file
Object obj = jsonParser.parse(reader);
JSONArray employeeList88 = (JSONArray) obj;
System.out.println(employeeList88);

employeeList.add(employeeList88);
System.out.println(employeeList);
//Write JSON file
try (FileWriter file = new FileWriter("Passwort.json")) {
//We can write any JSONArray or JSONObject instance to the file
file.write(employeeList.toJSONString()); 
file.flush();

} catch (IOException e4) {
e4.printStackTrace();
}

} catch (FileNotFoundException e99) {
e99.printStackTrace();
} catch (IOException e99) {
e99.printStackTrace();
} catch (ParseException e99) {
e99.printStackTrace();
}*/

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


