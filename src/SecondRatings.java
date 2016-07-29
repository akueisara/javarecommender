/**
 * Programming Exercise: Step Two
 * 
 * @author Kuei
 * @version July 29, 2016
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
	public SecondRatings() {
        // default constructor
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }
    
    public SecondRatings(String moviefile,String ratingsfile) {
        // default constructor
    	FirstRatings fr = new FirstRatings();
    	myMovies = fr.loadMovies(moviefile);
    	myRaters = fr.loadRaters(ratingsfile);
    }
    
    public int getMovieSize() {
    	return myMovies.size();
    }
    
    public int getRaterSize() {
    	return myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters) {
    	double average = 0;
    	double sum = 0;
    	int countRaters = 0;
    	for(Rater r: myRaters) {
    		if(r.hasRating(id)) {
    			countRaters++;  
    			sum += r.getRating(id);
    		}
    	}
    	if(countRaters >= minimalRaters)
    		average = sum / countRaters;
    	return average;
    }
    
    

}
