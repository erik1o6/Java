public  class LibraryDVD extends LibraryObject {
	private String genre; // type of DVD, e.g., "movie," "educational" 
	private Double lateFee=3.0;//the late fee charge per day
	private String success = "DVD was succesfuly returned  on the:";//Success string
	/**
	 * 
	 * @param title: the title of the dvd
	 * @param call_number: the call number of the object
	 * @param isAvail: is the dvd in the inventory
	 * @param genre: What is the genre of the dvd
	 */
	public LibraryDVD(String title, String call_number, boolean isAvail, String genre)
	{
		// PRE: Title !=null , call_number!=null, Boolean IsAvail =true , genre =!null
		// POST: Call the super library object constructor and initializes its data members, also LibraryDVD data members
		super(title,call_number,isAvail);
		this.genre=genre;
		
	}
	
	@Override 
	public void checkOut() 
	{ 
		// PRE: class member isAvail == true 
		// POST: isAvail is set to false and monthDue and dateDue are reset 
		// to 5 days in the future
		isAvail = false;
		resetDueDate(5); // DVD is due 5 days from now
	}
	@SuppressWarnings("static-access")
	@Override
	public String checkIn() 
	{
		// PRE: class member isAvail == false
		// POST: isAvail is set to true and late fee is
		// assessed
		isAvail = true;
		double moneyDue;
		if(curDate>dateDue)
		
		{
		moneyDue= (super.curDate-super.dateDue)*lateFee;
		return success+ super.curDate+ " Late Fee Owed: "+ moneyDue;
		}
		else
		{
		return success+ super.curDate;
		}
	}

	@Override
	public String toString() 
	{
		// PRE: class has been initialized
		// POST: returns information with all library
		// object and libraryDVD members // to 3 weeks
		// in the future
		return super.toString() + "LibraryDVD [genre=" + genre +", lateFee per day="+ lateFee + "]";
	}
}