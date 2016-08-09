/**
 * Programming Exercise: Step Three
 * Assignment 2: Filters
 * 
 * @author Kuei
 * @version August 8, 2016
 */

public class DirectorsFilter implements Filter {
	private String[] myDirector;
	
	public DirectorsFilter(String directors) {
		myDirector = directors.split(",");
	}
	
	@Override
	public boolean satisfies(String id) {
		for(String d: myDirector) {
			if (MovieDatabase.getDirector(id).contains(d))
			{
				return true;
			}
		}
		return false;
	}
}
