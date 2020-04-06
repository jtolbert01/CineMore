package cinemorepract;
import java.util.ArrayList;

/*
 * Search Function
 */

public class SearchPlays {
	public static Sort sort = new Sort();
	//Function to delegate type of search and return the query
	public static ArrayList<Play> returnPlay(ArrayList<Play> playList, String target, int searchType) {
		switch(searchType) {
		case 1: 
			if(titleSearchPlays(playList, target) != null) {
				return titleSearchPlays(playList, target);
			}
			break;
		case 2: 
			if(yearSearch(playList, target) != null) {
				return yearSearch(playList, target);
			}
			break;
		case 3: 
			if(characterSearch(playList, target) != null) {
				return characterSearch(playList, target);
			}
			break;
		case 4: 
			if(ratingSearch(playList, target) != null) {
				return ratingSearch(playList, target);
			}
			break;
		case 5: 
			if(runtimeSearch(playList, target) != null) {
				return runtimeSearch(playList, target);
			}
			break;
		case 6:
			if(authorSearch(playList, target) != null) {
				return authorSearch(playList, target);
			}
			break;
		//Sort Functions Below
		case 7:
			return sort.sortAlphaPlay(playList);
		
		case 8: 
			return sort.sortRatingPlay(playList);
		case 9:
			ArrayList<Play> alphaArray = sort.sortAlphaPlay(playList);
			ArrayList<Play> returnArray = new ArrayList<Play>();
			for(int i = alphaArray.size() - 1; i >= 0; --i) {
				returnArray.add(alphaArray.get(i));
			}
			return returnArray;
		case 10:
			ArrayList<Play> ratingArray = sort.sortRatingPlay(playList);
			ArrayList<Play> reverseArray = new ArrayList<Play>();
			for(int i = ratingArray.size() - 1; i >= 0; --i) {
				reverseArray.add(ratingArray.get(i));
			}
			return reverseArray;
		default:
			return null;
		}
		
		return null;
		
	}
	
	//Search's Plays for any ones with a runtime less then what is given
	public static ArrayList<Play> runtimeSearch(ArrayList<Play> PlayList, String runtime) {
		
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
			
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
	
	//Search's Plays to find all Plays above a certain rating
	public static ArrayList<Play> ratingSearch(ArrayList<Play> PlayList, String rating) {
		
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
			
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
	
	//Search's Plays for a given character member
	public static ArrayList<Play> characterSearch(ArrayList<Play> PlayList, String castMember) {
		
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
			
			String[] currentCastMember = m.getCharacters();
			
			
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
	
	//Search's for all Plays from a certain year
	public static ArrayList<Play> yearSearch(ArrayList<Play> PlayList, String year) {
		
		long targetYear = Long.parseLong(year);
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
			
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
	
	//Search's for the title of the Play
	public static ArrayList<Play> titleSearchPlays(ArrayList<Play> PlayList, String title) {
		
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
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
	public static ArrayList<Play> authorSearch(ArrayList<Play> PlayList, String author) {
		
		ArrayList<Play> returnArray = new ArrayList<Play>();
		for (Play m : PlayList) {
			String currentAuthor = m.getAuthor();

			if(currentAuthor.compareTo(author) == 0) {
				returnArray.add(m);
			}
		}
		if(returnArray.size() != 0) {
			return returnArray;
		}
		return null;
	}

}