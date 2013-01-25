/**
* Name:    Erik Arfvidson
* Section: 001
* Program: ThreeDimensionalShape.java definition
* Date: 9/24/2012
*Lab6
*/
public class ThreeDimensionalShape extends Shape 
{
	   protected double xLoc;        // x coordinate of a corner of the polygon
	   protected double yLoc;        // y coordinate of the same corner
	   protected double zLoc;		 // z coordinate of polygon
	   /**
	    * 
	    * @param x coordinate
	    * @param y coordinate
	    * @param z coordinate
	    * The cube constructor initializer take 3 arguments defining it's position(center of mass)
	    */
	   
	// initializer constructor for cube
	   public ThreeDimensionalShape(double x, double y, double z) 
	   {
		   // PRE: takes x>0.0, y>0.0, z>0.0,
		   if(name.isEmpty())
		     {
		  	  this.name="3D shape";
		    }
		   	  this.xLoc= x;
		      this.yLoc= y;
		      this.zLoc= z;
		
		      
	   }
	   
	   @Override
	   public String toString() 
	// POST: FCTVAL == String representation of ThreeDimensionalShape object
	   {
		   return super.toString() + " has a center of mass : (" + this.xLoc + "," + this.yLoc + "," + this.zLoc + ")";
	   }

}
