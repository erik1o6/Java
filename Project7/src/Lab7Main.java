public class Lab7Main { 
	public static void main(String[] args) 
	{ 
		LibraryObject[] lib = new LibraryObject[4];// library 
		lib[0] = new LibraryBook("Harry Potter", "001",true,"Rowling"); // create some items 
		lib[1] = new LibraryDVD("Adventure time","002", true, "Anime");
		lib[2] = new LibraryBook("Lord of The Rings","003",true,"Tolkien");
		lib[3] = new LibraryCD("In Rainbows","004", true, "Alternative", "Radiohead");
		System.out.println("Initial Library: ");
		for(LibraryObject cur : lib) { // go through whole library 
			System.out.println(cur.toString());
			} 
		
		System.out.println("\nChecking out three items");
		lib[0].checkOut(); // check out some items 
		lib[1].checkOut();
		lib[3].checkOut();
		System.out.println("\nLibrary after check outs:");
		for(LibraryObject cur : lib) { // go through whole library 
			System.out.println(cur.getStatus()); 
		}
		System.out.println("\nSetting date to 9/28");
		lib[1].resetDate(9, 28);
		System.out.println("Check in one item :" +lib[1].checkIn());		
	}
}