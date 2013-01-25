public class LibraryBook extends LibraryObject {
	private String author;// author of the book
	private Double lateFee = 1.0;// Late fee for books
	private String success = "Book was succesfuly returned  on the:";// Success string
/**
 * 
 * @param title: title of the book
 * @param call_number: call number of the library objecy
 * @param isAvail: is the book in the library
 * @param author: author of the book
 */
	public LibraryBook(String title, String call_number, boolean isAvail,
			String author) {
		// PRE: Title !=null , call_number!=null, Boolean IsAvail =true , author!=null
		// POST: Call the super library object constructor and initializes its data members and also intializes the libraryBooks data members
		super(title, call_number, isAvail);
		this.author = author;

	}

	@Override
	public void checkOut() { // PRE: class member isAvail == true
		// POST: isAvail is set to false and monthDue
		// and dateDue are reset // to 3 weeks in the
		// future
		isAvail = false;
		resetDueDate(21);// book will be checked out for 3 weeks = 21 days } }
	}

	@SuppressWarnings("static-access")
	public String checkIn() {// PRE: class member isAvail == false
		// POST: isAvail is set to true and late fee is
		// assessed
		isAvail = true;
		double moneyDue;
		if (curDate > dateDue)
		{
			moneyDue = (super.curDate - this.dateDue) * lateFee;
			return success + super.curDate + " Late Fee Owed: " + moneyDue;
		}
		else
		{
			return success + super.curDate;
		}
	}

	@Override
	public String toString() {// PRE: class has been initialized
		// POST: returns information with all library
		// object and libraryBook members // to 3 weeks
		// in the future
		return super.toString() + "LibraryBook [author=" + author
				+ ", lateFee per day=" + lateFee + "]";
	}
}