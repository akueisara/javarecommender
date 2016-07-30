import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieRunnerAverageTest {
	private MovieRunnerAverage ma;

	@Before
	public void setUp() throws Exception {
		ma = new MovieRunnerAverage();
	}

	@After
	public void tearDown() throws Exception {
		ma = null;
	}

	@Test
	public void printAverageRatingsTest() {
		ma.printAverageRatings();
	}
	
	@Test
	public void getAverageRatingOneMovieTest(){
		ma.getAverageRatingOneMovie();
	}

}
