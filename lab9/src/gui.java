import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JComboBox;


public class gui extends JApplet implements ActionListener, ItemListener
{
   private static final String[] OPTIONS = {" ", "Random", "top"};  //drop down array
   private static final int SIZE = 15;                              //size of message
   private static final int Length = 100;                  //The dimensions for the square

   private static boolean  isDrawn;     //Draw
   private boolean nColor;             //color black or random
   private boolean isSquare;            
   private boolean isMessage;           
   private boolean isRandom;			
   
   private JComboBox dropDown;              //Drop down menu to select where to draw
   private JCheckBox dColor;               //Check box option to draw in color
   private JRadioButton rSquare;            //The draw square radio button
   private JRadioButton rMessage;           //The write message radio button
   private JButton drawIt;                  //Button to draw
   private JTextField message;              //Text field for the user to input text
   private String input;                    //message the user types in the text field
   private int sWidth;						//X-Coordinate
   private int sHeight;						//Y-Coordinate
   private int top;								
   private JPanel topPanel;                     //Panel top
                                                
   private JPanel bottomPanel;                  //bottom panel
                                                
   Font nameFont;								

   @Override
   public void init()
   {
      JLabel dropDownDescription;               
      ButtonGroup buttonGroup;                   
      
      isRandom = false;
      isMessage = false;
      isSquare = false;
      nColor = false;
      isDrawn = false;
      
      setLayout(new FlowLayout());
      
      //Set font
      nameFont = new Font("TimesRoman",Font.BOLD,25);
      
      //Initialize app dimensions
      sWidth = 150;
      sHeight = 100;
      top = 95;
      
      //two radio buttons
      rSquare = new JRadioButton("Draw square");
      rMessage = new JRadioButton("Write message:");
       
      //link radiobuttons
      rSquare.addItemListener(this);
      rMessage.addItemListener(this);
      buttonGroup = new ButtonGroup();
      buttonGroup.add(rSquare);
      buttonGroup.add(rMessage);

      message = new JTextField(SIZE);
      

      dropDownDescription =  new JLabel("Select where to draw:");

      //Initialize dropDown
      dropDown = new JComboBox(OPTIONS);
      dropDown.addItemListener(this);

      //Initialize dColor
      dColor = new JCheckBox("Draw in color");
      dColor.addItemListener(this);

      //Initialize drawIt
      drawIt = new JButton("Draw it!");
      drawIt.addActionListener(this);

      //create the top panel
      topPanel = new JPanel();
      topPanel.add(rSquare);
      topPanel.add(rMessage);
      topPanel.add(message);

      //create the bottom panel
      bottomPanel = new JPanel();
      bottomPanel.add(dropDownDescription);
      bottomPanel.add(dropDown);
      bottomPanel.add(dColor);
      bottomPanel.add(drawIt);

      //add the top and bottom panel
      add(topPanel);
      add(bottomPanel);
   }

   @Override
   public void paint(Graphics g)
   //POST:  display either a square
   {
      super.paint(g);

      //Set the font
      g.setFont(nameFont);
      
      //if isDrawn is triggered
      if(isDrawn)
      {
         //if dColor is triggered
         if(nColor)
         {
            //draw the square in Orange
            g.setColor(Color.ORANGE);
            
         } 
         
         //if isRandom
         if(isRandom)
         {
            //set the coordinates randomly
            sWidth = (int) (Math.random() * (getWidth()/2) + (getWidth()/4));
            sHeight = (int) (Math.random() * (getHeight()/2) + (getHeight()/4));
                   
         }
         
         if(!isRandom)
         {
			  sHeight = top;
			  sWidth = getSize().width /2;
         }

         //draw the square
         if(isSquare)
         {
        	 g.fillRect(sWidth, sHeight, Length, Length);
         }
         
         //if isMessage
         if(isMessage)
         {
            input = message.getText();
            g.drawString(input, sWidth, sHeight);
         }   
      }
   }
   

   public void itemStateChanged( ItemEvent i)
   //POST: if the dColor, rSquare, or rMessage are triggered, nColor = true, 
   {
	  //if a dropDown option is selected
	  if(i.getSource() == dropDown)
	  {
		  //if the second option
		  if(dropDown.getSelectedIndex() == 1)
		  {
			  isRandom = true;
		  }
		  
		  //if the third option
		  if(dropDown.getSelectedIndex() == 2)
		  {
			  isRandom = false;
		  }
	  }
	  
      //Draw color
      if(i.getSource() == dColor)
      {
    	  if(i.getStateChange() == ItemEvent.SELECTED)
    	  {
    		  nColor = true;
    	  }
    	  if(i.getStateChange() == ItemEvent.DESELECTED)
    	  {
    		  nColor = false;
    	  }
      }

      //check radio
      if(i.getSource() == rSquare)
      {
    	  if(i.getStateChange() == ItemEvent.SELECTED)
    	  {
    		  isSquare = true;
    	  }
    	  if(i.getStateChange() == ItemEvent.DESELECTED)
    	  {
    		  isSquare = false;
    	  }
      }
      
      //check message
      if(i.getSource() == rMessage)
      {
    	  if(i.getStateChange() == ItemEvent.SELECTED)
    	  {
    		  isMessage = true;
    	  }
    	  if(i.getStateChange() == ItemEvent.DESELECTED)
    	  {
    		  isMessage = false;
    	  }
      }
   }

   public void actionPerformed(ActionEvent e)
   //POST: isDrawn == true 
   {
      if(e.getSource() == drawIt)                    
      {
         isDrawn = true;
      }

      repaint();
   }
}
