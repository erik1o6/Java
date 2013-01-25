

// Name:        Erik Arfvidson
// Section:     1
// Program:     Lab 15: Drawing Polygons
// Description: Class DrawPolygon creates a Java applet that allows the user to
//              click any number (up to 50) of points on the screen

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;


public class lab11 extends JApplet implements ActionListener, MouseListener
{
    private JButton doneButton;                 // Button when all points are clicked
    private JButton resetButton;				//Button to reset the screen
    private Color color;                        // Color of the polygon
    private int numClicks;                      // Number of times the user clicked
    private int [] userX;                       // X coordinates of user clicks
    private int [] userY;                       // Y coordinates of user clicks
    private int [] x;                           // Trimmed X coordinates of user clicks
    private int [] y;                           // Trimmed Y coordinates of user clicks
    private boolean userDone;                   // User is done adding points
    private boolean finishedDrawing;            // A polygon has been drawn

    @Override
    public void init()                          // Set up GUI
    {   
        numClicks = 0;
        userX = new int [50];
        userY = new int [50];
        userDone = false;
        finishedDrawing = false;
        
        setLayout(new FlowLayout());
        addMouseListener(this);

        doneButton = new JButton("Choose Color");
        resetButton = new JButton("Reset");
        doneButton.addActionListener(this);
        resetButton.addActionListener(this);
        add(doneButton);
        add(resetButton);
        
        
JOptionPane.showMessageDialog(null, "Click places on the screen to add points for a polygon, click the Button when done");
    }

    @Override
    public void paint(Graphics g)               // Draw Polylines or a Polygon
    {
    	
        super.paint(g);
        x = userX;              
        y = userY;
        
        if(userDone == false)                   // Draw Polylines              
        {
            g.drawPolyline(x, y, numClicks);
        }
        else if(userDone == true && finishedDrawing == false)  // Draw Polygon
        {
            //color = JColorChooser.showDialog(this, "Choose a color", color);  // Choose color
            g.setColor(color);
            g.drawPolygon(x, y, numClicks);
            g.fillPolygon(x, y, numClicks);
            finishedDrawing = true;                            // So user input wont do anymore
        }       
    }

    public void actionPerformed(ActionEvent e)  // Process Done Button
    {
        if(e.getSource() == resetButton)         // User is finished adding points
        {
            userDone = false;
            finishedDrawing= false;
            userX = new int [50];
            numClicks = 0;
            requestFocus();
            repaint();
        }
        
        if(e.getSource() == doneButton)         // User is finished adding points
        {
            color = JColorChooser.showDialog(this, "Choose a color", color);  // Choose color
            finishedDrawing= false;
            userDone = true;
            repaint(); 
            //userDone = false;
            
            //userX = new int [50];
            //numClicks = 0;
            
        }
        
    }
   
    public void mouseClicked(MouseEvent e)      // Process mouse clicks
    {
        userX[numClicks] = e.getX();            // X coordinate of mouse click
        userY[numClicks] = e.getY();            // Y coordinate of mouse click

        numClicks++;                            // Add one to number of clicks
        
        if(SwingUtilities.isRightMouseButton(e))
        {
        	userDone = true;
        }
        
        if(!finishedDrawing)
        {
        	repaint();
        }
    }
    
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
}

