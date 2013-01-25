/**
 * 
 */

/**
 * @author ERIK
 *Lab 6: More with Shapes
understand inheritance
In class, we talked about a Shape class and looked into TwoDimensionalShape objects in some detail. Let's go into three dimensions here.

Begin with this simple Shape class. You are NOT permitted to change this class in any way.

You'll create three classes called ThreeDimensionalShape, Sphere, and Cube. You'll create simple forms of these classes:

Each of these classes should share data for the location of the center (center of mass, let's say) of the shape via x, y, and z coordinates.
Spheres should additionally know their radii.
Cubes should additionally know the length of any edge.
Each class should have a constructor that allows you to set all of its properties. (You only need the initializer constructor. Providing a default constructor is not required and is just extra work for you today, so don't.)
Each should have a toString() method that tells what type of shape and all known information about it.
In the interest of time, do not add additional functionality. Instead, you'll be required to write about additional sensible functionality in your report.

Task 1: Implement the ThreeDimensionalShape, Sphere, and Cube classes.

Task 2: Create a test driver called Lab6Main wherein you create an array of 4 shapes and use all three constructors at least once. Test the toString() methods on these objects. Also, in the interest of time, you may forego comments other than header comments in the test driver (but classes must absolutely be documented).

Report: Create a lab report using the lab report template with your source code (use separate headings for each file) and output from running the test driver. Also, write a short discussion (roughly 4-7 sentences) including (a) what you've learned about inheritance and (b) some additional functions you would find appropriate for these classes. Also draw (hand, PowerPoint, Word, etc.) a inheritance hierarchy and include it in the report.

Note: (1) You must use the class names, including the test driver, indicated in this lab description. (2) Do NOT zip your files. Instead, include them one by one in your drop box (but still only one submission.) Your homework will receive lower grade if you fail to do either one.
 */
public class Lab6Main {
public static void main(String[] args) 
	{
Shape[] Shapes= new Shape[4];
Cube cub = new Cube(1,2,3,4);
Sphere test = new Sphere(1,2,3,4);
Shape ball = new Shape();
ThreeDimensionalShape t3d = new ThreeDimensionalShape(1,2,3);
//t3d.SetName("3d Object");
Shapes[0]=ball;
Shapes[1]=cub;
Shapes[2]=test;
Shapes[3]=t3d;
System.out.println("The output of the Shapes array:");
for (Shape num : Shapes) {
	System.out.println(num);
}



	}

}
