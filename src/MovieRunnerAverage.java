/**
 * Programming Exercise: Step Two
 * 
 * @author Kuei
 * @version July 29, 2016
 */

import java.util.*;

public class MovieRunnerAverage {
	public void printAverageRatings() {
		SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
		System.out.println("The number of movies: " + sr.getMovieSize());
	    System.out.println("The number of raters: " + sr.getRaterSize());
//	    System.out.println(sr.getAverageByID("0068646", 4));
	}
}
