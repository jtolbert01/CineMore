package cinemorepract;
import java.util.ArrayList;

/*
 * Search Function
 */

public class SearchMovies {
	public static Sort sort = new Sort();
	
	//Function to delegate type of search and return the query
	public static ArrayList<Movie> returnMovie(ArrayList<Movie> movieList, String target, int searchType) {
		switch(searchType) {
		case 1: 
			if(titleSearchMovies(movieList, target) != null) {
				return titleSearchMovies(movieList, target);
			}
			break;
		case 2: 
			if(yearSearch(movieList, target) != null) {
				return yearSearch(movieList, target);
			}
			break;
		case 3: 
			if(genreSearch(movieList, target) != null) {
				return genreSearch(movieList, target);
			}
			break;
		case 4: 
			if(castSearch(movieList, target) != null) {
				return castSearch(movieList, target);
			}
			break;
		case 5: 
			if(ratingSearch(movieList, target) != null) {
				return ratingSearch(movieList, target);
			}
			break;
		case 6: 
			if(runtimeSearch(movieList, target) != null) {
				return runtimeSearch(movieList, target);
			}
			break;
		case 7: 
			if(mpaaSearch(movieList, target) != null) {
				return mpaaSearch(movieList, target);
			}
			break;
		//Sort Functions Below
		case 8:
			return sort.sortAlphaMovie(movieList);
		case 9:
			return sort.sortRatingMovie(movieList);
		default:
			return null;
		}
		
		return null;
		
	}
	
	//Findsall movies with a certain MPAA rating
	public static ArrayList<Movie> mpaaSearch(ArrayList<Movie> movieList, String mpaa) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			String currentMPAA = m.getMPAA();
			
		
				if(currentMPAA.compareTo(mpaa) == 0) {
					returnArray.add(m);
				}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}

	//Search's movies for any ones with a runtime less then what is given
	public static ArrayList<Movie> runtimeSearch(ArrayList<Movie> movieList, String runtime) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			double currentRuntime = m.getRuntime();
			double targetRuntime = Double.parseDouble(runtime);
			
			if(currentRuntime <= targetRuntime) {
				returnArray.add(m);
			}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}
	
	//Search's movies to find all movies above a certain rating
	public static ArrayList<Movie> ratingSearch(ArrayList<Movie> movieList, String rating) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			double currentRating = m.getRating();
			double targetRating = Double.parseDouble(rating);
			
			if(currentRating >= targetRating) {
				returnArray.add(m);
			}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}
	
	//Search's movies for a given cast member
	public static ArrayList<Movie> castSearch(ArrayList<Movie> movieList, String castMember) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			String[] currentCastMember = m.getCast();
			
			
			for(int i = 0; i < currentCastMember.length; ++i) {
				System.out.println(currentCastMember[i]);
				System.out.println(castMember);
				if(currentCastMember[i].compareTo(castMember) == 0) {
					returnArray.add(m);
				}
			}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}
	
	//Search's for all movies of a given genre
	public static ArrayList<Movie> genreSearch(ArrayList<Movie> movieList, String genre) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			String[] currentGenre = m.getGenres();
			
			
			for(int i = 0; i < currentGenre.length; ++i) {
				System.out.println(currentGenre[i]);
				System.out.println(genre);
				if(currentGenre[i].compareTo(genre) == 0) {
					System.out.println(m.toString());
					returnArray.add(m);
				}
			}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}
	
	//Search's for all movies from a certain year
	public static ArrayList<Movie> yearSearch(ArrayList<Movie> movieList, String year) {
		
		long targetYear = Long.parseLong(year);
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			
			long currentYear = m.getYear();
			
			if(currentYear == targetYear) {
				returnArray.add(m);
			}
		}
		
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}
	
	//Search's for the title of the movie, should be able to make generic
	public static ArrayList<Movie> titleSearchMovies(ArrayList<Movie> movieList, String title) {
		
		ArrayList<Movie> returnArray = new ArrayList<Movie>();
		for (Movie m : movieList) {
			String currentTitle = m.getTitle();

			if(currentTitle.compareTo(title) == 0) {
				returnArray.add(m);
			}
		}
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}

}