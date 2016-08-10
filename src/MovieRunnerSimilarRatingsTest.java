/**
 * Programming Exercise: Step Four
 * 
 * @author Kuei
 * @version August 10, 2016
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieRunnerSimilarRatingsTest {
	private MovieRunnerSimilarRatings mrsr;

	@Before
	public void setUp() throws Exception {
		mrsr = new MovieRunnerSimilarRatings();
	}

	@After
	public void tearDown() throws Exception {
		mrsr = null;
	}

	@Test
	public void printAverageRatingsTest() {
		mrsr.printAverageRatings();
		System.out.println();
	}
	
	@Test
	public void printAverageRatingsByYearAfterAndGenreTest() {
		mrsr.printAverageRatingsByYearAfterAndGenre();
		System.out.println();
	}
	
	@Test
	public void printSimilarRatingsTest() {
		mrsr.printSimilarRatings();
		System.out.println();
	}
	
	@Test
	public void printSimilarRatingsByGenreTest() {
		mrsr.printSimilarRatingsByGenre();
		System.out.println();
	}
	
	@Test
	public void printSimilarRatingsByDirectorTest() {
		mrsr.printSimilarRatingsByDirector();
		System.out.println();
	}	
	
	@Test
	public void printSimilarRatingsByGenreAndMinutesTest() {
		mrsr.printSimilarRatingsByGenreAndMinutes();
		System.out.println();
	}	
	
	@Test
	public void printSimilarRatingsByYearAfterAndMinutesTest() {
		mrsr.printSimilarRatingsByYearAfterAndMinutes();
		System.out.println();
	}
}
