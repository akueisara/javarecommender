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
	    int minimalRaters = 3;
	    ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + sr.getTitle(r.getItem()));
	    }
	}
	
	public void getAverageRatingOneMovie() {
		SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
		String movieTitle = "The Godfather";
		String movieID = sr.getID(movieTitle);
		int minimalRaters = 0;
		ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
		for(Rating r: ratings) {
			if(r.getItem().equals(movieID))
				System.out.println("The average rating for the movie \"" + movieTitle + "\" is " + r.getValue());
		}
	}
}
