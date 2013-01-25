/**
 * Name: Erik Arfvidson Section: 001 Program: Cube.java definition
 * Date:9/24/2012 Lab6
 */
public class Cube extends ThreeDimensionalShape {
	private double leng;// the length of one side of the cube

	// @Override
	// initializer constructor for cube
	/**
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param z
	 *            coordinate
	 * @param leng
	 *            = the length of the sides of the cube The cube constructor
	 *            initializer take 4 arguments defining it's position(center of
	 *            mass) and also the length of one of the sides of the cube
	 */
	public Cube(double x, double y, double z, double leng)
	// PRE: takes x>0.0, y>0.0, z>0.0, leng >0.0
	// POST:
	// shape cube
	{

		super(x, y, z);
		this.setLeng(leng);
		super.SetName("Cube");

	}

	// get length method
	public double getLeng()
	// POST: returns the length of the cube
	{
		return leng;
	}

	// setLength method
	public void setLeng(double leng)
	// PRE: length>0.0
	// POST:Sets the length of the cube.
	{
		this.leng = leng;
	}

	// returns all information of cube
	@Override
	public String toString()
	// POST: FCTVAL == String representation of CUBE object
	{
		return super.toString() + " length=" + leng;
	}

}
