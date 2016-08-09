/**
 * Programming Exercise: Step Three
 * Assignment 2: Filters
 * 
 * @author Kuei
 * @version August 8, 2016
 */

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {
	public void printAverageRatings() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    ArrayList<Rating> ratings = tr.getAverageRatings(minimalRaters);
	    System.out.println("found " + ratings.size() + " movies");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
	    }
	}
	
	public void printAverageRatingsByYear() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    int year = 2000;
	    Filter filterCriteria = new YearAfterFilter(year);
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    System.out.println("found " + ratings.size() + " movies");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " +  MovieDatabase.getTitle(r.getItem()));
	    }		
	}
	
	public void printAverageRatingsByGenre() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    String genre = "Crime";
	    Filter filterCriteria = new GenreFilter(genre);
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    System.out.println("found " + ratings.size() + " movies");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
	    }	
	}
	
	public void printAverageRatingsByMinutes() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    int min = 110;
	    int max = 170;
	    Filter filterCriteria = new MinutesFilter(min, max);
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    System.out.println("found " + ratings.size() + " movies");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
	    }		
	}
	
	public void printAverageRatingsByDirectors() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    String directors = "Charles Chaplin,Michael Mann,Spike Jonze"; 
	    Filter filterCriteria = new DirectorsFilter(directors);
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    System.out.println("found " + ratings.size() + " movies");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getDirector(r.getItem()));
	    }	
	}
	
	public void printAverageRatingsByYearAfterAndGenre() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    int year = 1980;
	    String genre = "Romance";
	    AllFilters filterCriteria = new AllFilters();
	    filterCriteria.addFilter(new YearAfterFilter(year));
	    filterCriteria.addFilter(new GenreFilter(genre));
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    if (ratings.size() == 0 || ratings.size() == 1)
	    	System.out.println(ratings.size() + " movie matched");
	    else
	    	System.out.println(ratings.size() + " movies matched");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
	    }			
	}
	
	public void printAverageRatingsByDirectorsAndMinutes() {
		ThirdRatings tr = new ThirdRatings("data/ratings_short.csv");
	    System.out.println("read data for " + tr.getRaterSize() + " raters");
	    MovieDatabase.initialize("ratedmovies_short.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
	    int minimalRaters = 1;
	    int min = 30;
	    int max = 170;
	    String directors = "Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola";
	    AllFilters filterCriteria = new AllFilters();
	    filterCriteria.addFilter(new DirectorsFilter(directors));
	    filterCriteria.addFilter(new MinutesFilter(min, max));
	    ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
	    if (ratings.size() == 0 || ratings.size() == 1)
	    	System.out.println(ratings.size() + " movie matched");
	    else
	    	System.out.println(ratings.size() + " movies matched");
	    Collections.sort(ratings);
	    for(Rating r: ratings) {
	    	System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getDirector(r.getItem()));
	    }			
	}
}
