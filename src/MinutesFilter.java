/**
 * Programming Exercise: Step Three
 * Assignment 2: Filters
 * 
 * @author Kuei
 * @version August 8, 2016
 */

public class MinutesFilter implements Filter {
	private int Min;
	private int Max;
	
	public MinutesFilter(int min, int max) {
		Min = min;
		Max = max;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id) >= Min && MovieDatabase.getMinutes(id) <= Max;
	}
}
