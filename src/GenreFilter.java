/**
 * Programming Exercise: Step Three
 * Assignment 2: Filters
 * 
 * @author Kuei
 * @version August 8, 2016
 */

public class GenreFilter implements Filter {
	private String myGenre;
	
	public GenreFilter(String genre) {
		myGenre = genre;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(myGenre);
	}
}
