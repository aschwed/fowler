package retaltest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rental.Movie;
import rental.Rental;

public class RentalTest {

	private final static String MOVIE_TITLE = "title";
	private final static Movie TEST_MOVIE = new Movie(MOVIE_TITLE, Movie.NEW_RELEASE);
	private final static int TEST_DAYS = 4711;

	private Rental codeUnderTest;

	@Before
	public void setUp() {
		codeUnderTest = new Rental(TEST_MOVIE, TEST_DAYS);
	}

	@Test
	public void testGetDaysRented() {
		Assert.assertEquals(TEST_DAYS, codeUnderTest.getDaysRented());
	}

	@Test
	public void testGetMovie() {
		Assert.assertEquals(TEST_MOVIE, codeUnderTest.getMovie());
	}
	
}
