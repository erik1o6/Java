/**
 *  Lab 7: Enhance Library

    practice inheritance
    practice polymorphism

In class Day8, we worked with a LibraryObject class and two subclasses. We're going to add to that system here.

Task 1: Begin by creating a LibraryCD class. Have members for the artist and genre of the CD and create a new form of the checkOut() method for CDs. Allow CDs to be checked out for a week.

Update the test driver (name it Lab7Main) to test the creation and polymorphic check out of at least one CD.



Task 2: Update LibraryObject by adding a method that allows the month and date to be reset. Then call this method in your test driver to change the date to 9/22.

Task 3: Add late fees and checkIn functionality into the library system. Suppose the library has a different daily late fee for each kind of object that can be checked out. You choose the fees yourself, as long as they're different. The late fee can be set in the respective constructors. Each subclass of LibraryObject must have a different checkIn method. checkIn uses curDate and dateDue to determine whethere this is on time or late. When an item is checked in, return a string that tells what type it was, that it was returned, and if a late fee must be assessed, what that late fee is.

Your method only needs to handle dates within the current month properly. Just assume that it is always the same month (i.e. curMonth always equals monthDue. Practicing Date/Time is not the purpose of this lab so let's keep it simple.

Update the test driver to check in all objects that are checked out and print the results of checking them in to the console.

Task 4: Add more functionality to the classes:

    Provide a toString() for LibraryObject.
    Provide for each of the three kinds of library objects an initializer constructor that allows initialization of all of the data members of that particular kind of library object. You also need to add a constructor to LibraryObject to initialize the data members in it.

Now test each initializer constructor once by adding to your existing test driver (again, should be named Lab7Main) and printing out each object.

Report: Create a lab report using the lab report templacurMonthte with your source code (use separate headings for each file) and output from running a run of the final form of the test driver.

Note: (1) You must use the class and method names, including the test driver, indicated in this lab description. (2) Do NOT zip your files. Instead, include them one by one in your drop box (but still only one submission.) Your homework will receive lower grade if you fail to do either one.

 * @author ERIK
 *
 */
public class LibraryCD extends LibraryObject{
	private String genre;//CD genre
	private String artist;//CD artist name
	private Double lateFee=2.0;//lateFee for CD
	private String success = "CD was succesfuly returned  on the:";// CD success string return
/**
 * 
 * @param title the title of the CD
 * @param call_number the number of the cd
 * @param isAvail Is item available
 * @param genre the genre of the cd
 * @param artist the name of the artist
 */

	public LibraryCD(String title, String call_number, boolean isAvail, String genre,String artist)
	{// PRE: Title !=null , call_number!=null, Boolean IsAvail =true , genre =!null , artist!=null
		// POST: Call the super library object constructor and initializes its data members
		super(title,call_number,isAvail);
		this.genre=genre;
		this.artist=artist;
	}
	public void checkOut() 
	{ 
		// PRE: class member isAvail == true 
		// POST: isAvail is set to false and monthDue and dateDue are reset 
		// to 5 days in the future
		isAvail = false;
		resetDueDate(7); // DVD is due 5 days from now
	}

	@SuppressWarnings("static-access")
	public String checkIn() 
	{// PRE: class member isAvail == false
		// POST: isAvail is set to true and late fee is
		// assessed
		isAvail = true;
		double moneyDue;
		if(curDate>dateDue)

		{
			moneyDue= (this.curDate-this.dateDue)*lateFee;
			return success+ this.curDate+ " Late Fee Owed: "+ moneyDue;
		}
		else
		{
			return success+ super.curDate;
		}
	}
	@Override
	public String toString() 
	{// PRE: class has been initialized
		// POST: returns information with all library
		// object and libraryCD members // to 3 weeks
		// in the future
		return super.toString() + " LibraryCD [genre=" + genre + ",artist=" + artist +", lateFee per day="+ lateFee +"]";
	}
}