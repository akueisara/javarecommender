/**
 * Programming Exercise: Step Three
 * Assignment 1: Efficiency
 * 
 * @author Kuei
 * @version August 8, 2016
 */

import java.util.ArrayList;

public interface Rater {
	public void addRating(String item, double rating);
	public boolean hasRating(String item);
	public String getID();
	public double getRating(String item);
	public int numRatings();
	public ArrayList<String> getItemsRated();
}
