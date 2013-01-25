import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.applet.*;
import java.util.ArrayList;
import java.util.Random;



public class app extends JApplet implements ActionListener, ItemListener  {
	private JTextField nameField;
    private String message;                                // message to read back to user
	private JCheckBox rememberCheck;
	private JButton okButton;
	private JRadioButton drawSquare;
	private JRadioButton writeMessage;
	private JComboBox DropDown;
	private static final String[] whereDraw = {"           ", "top", "bottom", "random"};
	private JPanel       DrawOne;
	private JPanel       DrawTwo;
	private GridLayout layout;
	private GridBagLayout layouts;
	private GridBagConstraints constraints; 
	private Color colors = Color.BLACK;
	private int xcor=250;
	private int xcors=-150;
	private int ycor=200;
	private int size=0;
	private String messages="ls";
	//private squareShape square;
	public Random rand = new Random();
 int rads = rand.nextInt(2);
   	float rd = rand.nextFloat();
   	float gsd = rand.nextFloat();
   	float bd = rand.nextFloat();

	public Color randomColo1r = new Color(rd, gsd, bd);

	public void init()
	{
		layout = new GridLayout(4, 1);
		setLayout(layout);
		ButtonGroup radioDraw; 
		
  
		//layouts = new GridBagLayout(); 
		//constraints = new GridBagConstraints(); 
		
	      drawSquare = new JRadioButton("Draw square", false);
	      writeMessage = new JRadioButton("Write message:", false);
	      drawSquare.addItemListener(this);   
	      writeMessage.addItemListener(this);   
	      rememberCheck = new JCheckBox("Draw in color");
	      rememberCheck.addItemListener(this); 
	      okButton = new JButton("Draw It!");
	      okButton.addItemListener(this);
		  DropDown = new JComboBox( whereDraw ); 
		  
		  DropDown.setMaximumRowCount(2);
		  DropDown.setSize(20,10);
		  DropDown.addItemListener(this);
		  nameField = new JTextField(20);
		  nameField.addActionListener(this);
		  DrawOne = new JPanel(); 
		  DrawOne.add(rememberCheck);
		  DrawOne.add(drawSquare); 
		  DrawOne.add(writeMessage);
		  DrawOne.add(nameField);
		  
		  
	                       
		  
		  DrawTwo = new JPanel(); 
		  DrawTwo.add(DropDown);
		  DrawTwo.add(rememberCheck); 
		  DrawTwo.add(okButton);
		 
		  add(DrawOne); 
		  validate();
		  add(DrawTwo);
		  validate();
		  radioDraw = new ButtonGroup();                 // logically link buttons
		  radioDraw.add(drawSquare);
		  radioDraw.add(writeMessage);
		  
	}
	
	   public void paint(Graphics g) 
	   {
		   	  super.paint(g);

	           g.setColor(colors);
	           g.drawString(messages,xcors,ycor);
	           g.fillRect(xcor,ycor,size,size);
	}


	    public void actionPerformed(ActionEvent e) {          // process nameField, okButton, clearButton      
	        if(e.getSource() == nameField) {
	           // process "Enter" in nameField
	        	messages= nameField.getText();
	        }



	        repaint();                                       
	    }

		@Override
		public void itemStateChanged(ItemEvent e) 
		{             // handle radio button changes
	        if(e.getSource() == okButton && e.getStateChange() == ItemEvent.SELECTED && e.getSource() == rememberCheck && e.getStateChange() == ItemEvent.SELECTED) 
	        {  // black chosen
	            colors = randomColo1r;
	            
	        }
	        if(e.getSource() == rememberCheck && e.getStateChange() == ItemEvent.DESELECTED) 
	        {  // black chosen
	            colors = Color.BLACK;
	        }
	        if(e.getSource() == drawSquare && e.getStateChange() == ItemEvent.SELECTED) { 
	        	size=100;
	        }
	        if(e.getSource() == drawSquare && e.getStateChange() == ItemEvent.DESELECTED) {  
	        	size=0;
	        }
	        if(e.getSource() == writeMessage && e.getStateChange() == ItemEvent.SELECTED) { 
	          xcors=250;
	        }
	        if(e.getSource() == writeMessage && e.getStateChange() == ItemEvent.DESELECTED) {   
	        	xcors=-150;
		        }
	        if(e.getSource() == DropDown) {
	        	if(DropDown.getSelectedItem()=="top")
	        		ycor=200;
	        	if(DropDown.getSelectedItem()=="bottom")
	        		ycor=400;
	        	if(DropDown.getSelectedItem()=="random")
	        		ycor=400-(200*(rads));
	        }
	        repaint();    
		}

	  

}
