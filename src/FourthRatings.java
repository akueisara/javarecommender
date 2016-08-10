/**
 * Programming Exercise: Step Four
 * 
 * @author Kuei
 * @version August 10, 2016
 */

import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {
    
    private double getAverageByID(String id, int minimalRaters) {
    	ArrayList<Rater> myRaters = RaterDatabase.getRaters();
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
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
    	ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
    	ArrayList<Rating> ratings = new ArrayList<Rating>();
    	for(String id: movies) {
    		double averageRating = getAverageByID(id,minimalRaters);
    		if(averageRating!=0){
    			Rating r = new Rating(id, averageRating);
    			ratings.add(r);
    		}
    	}
    	return ratings;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
    	ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
    	ArrayList<Rating> ratings = new ArrayList<Rating>();
       	for(String id: movies) {
    		double averageRating = getAverageByID(id,minimalRaters);
    		if(averageRating!=0){
    			Rating r = new Rating(id, averageRating);
    			ratings.add(r);
    		}
    	}
    	return ratings;
    }
    
    private double dotProduct(Rater me, Rater r) {
    	double dotProduct = 0;
    	ArrayList<String> myMovies = me.getItemsRated();
    	for (String id: myMovies)
		{
			if (r.hasRating(id))
			{
				double myRating = me.getRating(id);
				double rRating = r.getRating(id);
				myRating -= 5;
				rRating -= 5;
				dotProduct += myRating * rRating;
			}
		}
		return dotProduct;
    }
    
    private ArrayList<Rating> getSimilarities(String id) {
    	ArrayList<Rating> list = new ArrayList<Rating>();
    	Rater me = RaterDatabase.getRater(id);
    	for(Rater r: RaterDatabase.getRaters()) {
    		// add dot_product(r, me) to list if r!= me
    		if(!r.equals(me)) {
    			double product = dotProduct(me, r);
    			if (product > 0)
    				list.add(new Rating(r.getID(), product));
    		}
    	}
    	Collections.sort(list, Collections.reverseOrder());
    	return list;
    }
    
    public ArrayList<Rating> getRecommendations(String id, int numRaters) {
    	ArrayList<Rating> list = getSimilarities(id);
    	ArrayList<Rating> res = new ArrayList<Rating>();
    	ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
    	for(String movieID: movies) {
        	double weightedAverage = 0;
        	double sum = 0;
        	int countRaters = 0;
    		for(int k=0; k < numRaters; k++) {
    			Rating r = list.get(k);
    			String raterID = r.getItem();
    			double weight = r.getValue();
    			Rater myRater = RaterDatabase.getRater(raterID);
    			if(myRater.hasRating(movieID)) {
    				countRaters++;
    				sum += weight * myRater.getRating(movieID);
    			}
    		}
    		weightedAverage = sum / countRaters;
    		res.add(new Rating(movieID, weightedAverage));
    	}
		Collections.sort(res, Collections.reverseOrder());
		return res;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
    	ArrayList<Rating> res = new ArrayList<Rating>();
    	ArrayList<Rating> list = getSimilarities(id);	
    	ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());	
	    for (String movieID : movies) {
        	double weightedAverage = 0;
        	double sum = 0;
        	int countRaters = 0;
	    	for (int i = 0; i < numSimilarRaters; i++) {
	    		Rating r = list.get(i);
	    		double weight = r.getValue();
	    		String raterID = r.getItem();
	    		Rater myRater = RaterDatabase.getRater(raterID);
	    		if(myRater.hasRating(movieID)) {
	    			countRaters++;
	    			sum += weight * myRater.getRating(movieID);
	    		}
	    		
	    	}
	    	if (countRaters >= minimalRaters) {
	    		weightedAverage = sum / countRaters;
	    		res.add(new Rating(movieID, weightedAverage));
			}			
	    }
		Collections.sort(res, Collections.reverseOrder());
		return res;		
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) {
    	ArrayList<Rating> res = new ArrayList<Rating>();
    	ArrayList<Rating> list = getSimilarities(id);	
    	ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
	    for (String movieID : movies) {
        	double weightedAverage = 0;
        	double sum = 0;
        	int countRaters = 0;
	    	for (int i = 0; i < numSimilarRaters; i++) {
	    		Rating r = list.get(i);
	    		double weight = r.getValue();
	    		String raterID = r.getItem();
	    		Rater myRater = RaterDatabase.getRater(raterID);
	    		if(myRater.hasRating(movieID)) {
	    			countRaters++;
	    			sum += weight * myRater.getRating(movieID);
	    		}
	    		
	    	}
	    	if (countRaters >= minimalRaters) {
	    		weightedAverage = sum / countRaters;
	    		res.add(new Rating(movieID, weightedAverage));
			}			
	    }
		Collections.sort(res, Collections.reverseOrder());
		return res;	
    }
}
