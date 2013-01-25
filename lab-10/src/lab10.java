import
import
import
import
import
import
import

java.awt.FlowLayout;
java.awt.Graphics;
java.awt.event.*;
javax.swing.*;
javax.swing.JOptionPane;
java.util.ArrayList;
java.awt.Color;

public class DrawPolygon extends JApplet implements ActionListener, MouseListener
{
private JButton doneButton;
// Button when all points are clicked
private Color color;
// Color of the polygon
private int numClicks;
// Number of times the user clicked
private int [] userX;
// X coordinates of user clicks
private int [] userY;
// Y coordinates of user clicks
private int [] x;
// Trimmed X coordinates of user clicks
private int [] y;
// Trimmed Y coordinates of user clicks
private boolean userDone;
// User is done adding points
private boolean finishedDrawing;
// A polygon has been drawn

@Override
public void init()
{
numClicks = 0;
userX = new int [50];
userY = new int [50];
userDone = false;
finishedDrawing = false;
setLayout(new FlowLayout());
addMouseListener(this);

doneButton = new JButton("Click When Done");
doneButton.addActionListener(this);
add(doneButton);

JOptionPane.showMessageDialog(null, "Click places on the screen to add points for a polygon, click
the Button when done");

}

@Override
public void paint(Graphics g)
// Draw Polylines or a Polygon
{
super.paint(g);
x = userX;
y = userY;
if(userDone == false)
// Draw Polylines
{
g.drawPolyline(x, y, numClicks);
}
else if(userDone == true && finishedDrawing == false) // Draw Polygon
{
color = JColorChooser.showDialog(this, "Choose a color", color); // Choose color
g.setColor(color);
g.drawPolygon(x, y, numClicks);
g.fillPolygon(x, y, numClicks);
finishedDrawing = true;
// So user input wont do anymore
}
}

public void actionPerformed(ActionEvent e)

// Set up GUI

// Process Done Button

CMPSC 221 Lab Report

{

if(e.getSource() == doneButton)
{
userDone = true;
}

requestFocus();
repaint();

}
public void mouseClicked(MouseEvent e)
{
userX[numClicks] = e.getX();
userY[numClicks] = e.getY();

numClicks++;
repaint();

}
public
public
public
public

}

(Josh Tucker)Page 2 of 2

// User is finished adding points

// Process mouse clicks

// X coordinate of mouse click
// Y coordinate of mouse click

// Add one to number of clicks

void
void
void
void

mouseReleased(MouseEvent e){}
mouseEntered(MouseEvent e){}
mouseExited(MouseEvent e){}
mousePressed(MouseEvent e){}