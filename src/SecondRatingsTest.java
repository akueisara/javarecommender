/**
 * Programming Exercise: Step Two
 * 
 * @author Kuei
 * @version July 29, 2016
 */

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SecondRatingsTest {
	private SecondRatings sr;
	private Method m;
	private static String METHOD_NAME = "getAverageByID";
	private Class[] parameterTypes;
	private Object[] parameters;
	private String inputID;
	private Integer inputRater;
	private Double expectedResult;
	
	@Before
	public void setUp() throws Exception {
		sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
		parameterTypes = new Class[2];
		parameterTypes[0] = java.lang.String.class;
		parameterTypes[1] = java.lang.Integer.TYPE;
		m = sr.getClass().getDeclaredMethod(METHOD_NAME, parameterTypes);
		m.setAccessible(true);
		parameters = new Object[2];
	}
	
	public SecondRatingsTest(String inputID, int inputRater, double expectedResult) {
		this.inputRater = inputRater;
		this.inputID = inputID;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection data() {
	     return Arrays.asList(new Object[][] {
	         {"0068646", 0, 9.0},
	         {"0068646", 1, 9.0},
	         {"0068646", 4, 9.0},
	         {"0068646", 5, 0.0},
	      });
	}

	@After
	public void tearDown() throws Exception {
		sr = null;
	}

	@Test
	public void getAverageByIDTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		parameters[0] = inputID;
		parameters[1] = inputRater;
		double result = (double)m.invoke(sr, parameters);
		assertEquals(expectedResult, result, 0.0);
//		assertEquals(9.0, sr.getAverageByID("0068646", 0), 0.0);
//		assertEquals(9.0, sr.getAverageByID("0068646", 1), 0.0);
//		assertEquals(9.0, sr.getAverageByID("0068646", 4), 0.0);
//		assertEquals(0.0, sr.getAverageByID("0068646", 5), 0.0);
	}

}
