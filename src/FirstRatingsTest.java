/**
 * Programming Exercise: Step One
 * 
 * Programming Exercise: Step Three
 * Assignment 1: Efficiency
 * 
 * @author Kuei
 * @version August 8, 2016
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstRatingsTest {
	private FirstRatings fr;

	@Before
	public void setUp() throws Exception {
		fr = new FirstRatings();
	}

	@After
	public void tearDown() throws Exception {
		fr = null;
	}

	@Test
	public void testLoadMovieTest() {
		fr.testLoadMovies();
	}
	
	@Test
	public void testLoadRatersTest() {
		fr.testLoadRaters();
	}

}
