package cinemorepract;
import java.util.ArrayList;

/*
 * Search Function
 */

public class Search {
	
	public static ArrayList<Movie> returnMovie(ArrayList<Movie> movieList, String target, int searchType) {
		switch(searchType) {
		case 1: 
			if(titleSearch(movieList, target) != null) {
				return titleSearch(movieList, target);
			}
		case 2: 
			if(yearSearch(movieList, target) != null) {
				return yearSearch(movieList, target);
			}
		case 3: 
			if(genreSearch(movieList, target) != null) {
				return genreSearch(movieList, target);
			}
		case 4: 
			if(castSearch(movieList, target) != null) {
				return castSearch(movieList, target);
			}
		case 5: 
			if(ratingSearch(movieList, target) != null) {
				return ratingSearch(movieList, target);
			}
		case 6: 
			if(runtimeSearch(movieList, target) != null) {
				return runtimeSearch(movieList, target);
			}
		case 7: 
			if(mpaaSearch(movieList, target) != null) {
				return mpaaSearch(movieList, target);
			}
		}
		
		return null;
		
	}
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
	
	public static ArrayList<Movie> titleSearch(ArrayList<Movie> movieList, String title) {
		
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