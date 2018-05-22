package retaltest;

import org.junit.Assert;
import org.junit.Test;

import rental.Customer;
import rental.Movie;
import rental.Rental;

public class CustomerTest {

	private static final String CUSTOMER_NAME = "joe";
	private static final String MOVIE2_TITLE = "movie2";
	private static final String MOVIE1_TITLE = "movie1";
	private static final int DAYS_RENTED_FIRST_FILM = 10;
	private static final int DAYS_RENTED_SECOND_FILM = 5;
	


	private Customer codeUnderTest;

	
	
	@Test
	public void testGenerateCustomerStatement() {
		final String expectedStatement = "Rental Record for joe\n" + 
				"\tTitle\t\tDays\tAmount\n" + 
				"\tmovie1\t\t10\t30.0\n" + 
				"\tmovie2\t\t5\t4.5\n" + 
				"Amount owed is 34.5\n" + 
				"You earned 3 frequent renter points";
		
		Movie movie1 = new Movie(MOVIE1_TITLE, Movie.NEW_RELEASE);
		Movie movie2 = new Movie(MOVIE2_TITLE, Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, DAYS_RENTED_FIRST_FILM);
		Rental rental2 = new Rental(movie2, DAYS_RENTED_SECOND_FILM);
		
		codeUnderTest = new Customer(CUSTOMER_NAME);
		codeUnderTest.addRental(rental1);
		codeUnderTest.addRental(rental2);
		
		
		Assert.assertEquals(expectedStatement, codeUnderTest.generateCustomerStatement());
		
	}
	
	
}
