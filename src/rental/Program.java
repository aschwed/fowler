package rental;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line. Java console
 * applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program {
	/**
	 * This is the main entry point for the application
	 */

	private static final int DAYS_RENTED_FIRST_FILM = 10;
	private static final int DAYS_RENTED_SECOND_FILM = 5;
	
	
	public static void main(String args[]) {
		String result;
		System.out.println("Welcome to the Movie Store");
		Movie m1 = new Movie("movie1", Movie.NEW_RELEASE);
		Movie m2 = new Movie("movie2", Movie.CHILDRENS);
		Rental r1 = new Rental(m1, DAYS_RENTED_FIRST_FILM);
		Rental r2 = new Rental(m2, DAYS_RENTED_SECOND_FILM);
		Customer c1 = new Customer("joe");
		c1.addRental(r1);
		c1.addRental(r2);
		System.out.println("Let's get the Statement");
		result = c1.generateCustomerStatement();
		System.out.println(result);
	}
}
