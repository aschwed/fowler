package retaltest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rental.Movie;

public class MovieTest {

	private final static String MOVIE_TITLE = "title";

	private Movie codeUnderTest;

	@Before
	public void setUp() {
		codeUnderTest = new Movie(MOVIE_TITLE, Movie.REGULAR);
	}

	@Test
	public void testGetPriceCode() {
		Assert.assertEquals(Movie.REGULAR, codeUnderTest.getPriceCode());
	}

	@Test
	public void testSetPriceCode() {
		codeUnderTest.setPriceCode(Movie.NEW_RELEASE);
		Assert.assertEquals(Movie.NEW_RELEASE, codeUnderTest.getPriceCode());
	}

	@Test
	public void testGetTitle() {
		Assert.assertEquals(MOVIE_TITLE, codeUnderTest.getTitle());
	}

}
