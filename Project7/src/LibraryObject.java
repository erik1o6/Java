public abstract class LibraryObject 
{ 
	protected static int curMonth = 9; // current month number
	protected static int curDate = 1; // current day number 
	protected String title; // title of object 
	protected String call_number; // call number of object in library system 
	protected boolean isAvail; // availability indicator: true when object is // not checked out, false when it is 
	protected int monthDue; // number of month object is due back 
	protected int dateDue; // date of monthDue when object is due back 
	public LibraryObject() 
	{ 
		// POST: new LibraryObject constructed such that 
		// title and call_number are set to blank strings and isAvail is true 
		title = ""; 
		call_number = ""; 
		isAvail = true;
	}
	public LibraryObject(String title, String call_number, boolean isAvail ) 
	{ 
		// POST: new LibraryObject constructed such that 
		// title and call_number are set to blank strings and isAvail is true 
		this.title = title; 
		this.call_number =call_number; 
		this.isAvail = isAvail;
		
	}
	@Override
	public String toString() 
	{
		// PRE: class has been initialized
		// POST: returns information with all library
		// object data members
		return "LibraryObject [title=" + title + ", call_number=" + call_number
				+ ", isAvail=" + isAvail + ", monthDue=" + monthDue
				+ ", dateDue=" + dateDue + "]";
	}
	public abstract void checkOut();
	
	// PRE: class member isAvail == true 
	// POST: isAvail is set to false and monthDue and dateDue are reset 
	// according to what type of item this is 
	public abstract String checkIn();
	public void resetDueDate(int numDays) 
	{ 	// PRE: numDays > 0 
		// POST: monthDue and dateDue are adjusted numDays into the future 
		monthDue = curMonth; 
		dateDue = curDate + numDays; // lazy implementation -- can you fix it? } 
	}
	public void resetDate(int month, int day)
	{
		//PRE:month>0 day>0
		//POST:CurrentMonth And curDate are reset and set to a new value
		curMonth=month;
		curDate=day;
	
	}
		public String getStatus() 
		{ 
			// POST: FCTVAL == string stating "Available" if item is available or 
			// "Due Back [month]/[date]" is item is checked out 
			
			if(isAvail) // item is not checked out 
			{ 
				return title+" Available"; } 
			else 
			{ // item is checked out 
				return title+" Due Back " + monthDue + "/" + dateDue; 
			}
			
	
		}
}
