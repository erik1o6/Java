/**
 * Name: Erik Arfvidson 
 * Section: 001 
 * Program: Sphere.java definition 
 * Date:9/24/2012 Lab6
 */
public class Sphere extends ThreeDimensionalShape 
{
	private double radius;// radius of sphere
	// @Override
	// The Sphere constructor initializer takes 4 arguments defining it's
	// position(center of mass) and also the length of the radius of the cube.
	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 * @param radius
	 */
	public Sphere(double x, double y, double z, double radius)
	// PRE: x>0.0 y>0.0 z>0.0 radius>0.0
	// POST:the class data members would be set to the appropriate values
	// //The method takes the values of the center of mass and names the
	// shape cube
	{
		super(x, y, z);
		this.radius = radius;
		super.SetName("Sphere");
	}
	// get Radius method
	public double getRadius() 
	// POST:gets the radius of the sphere.
	{
		return radius;
	}
	// set Radius method
	public void setRadius(double radius)
	// POST:Sets the radius of the sphere.
	{
		this.radius = radius;
	}

	@Override
	// returns all information of cube
	public String toString() 
	// POST: FCTVAL == String representation of Sphere object
	{
		return super.toString() + " radius=" + radius;
	}

}
